package servicetests

import com.example.jpaSpielwiese.DemoApplication
import com.example.jpaSpielwiese.persistence.entities.Account
import com.example.jpaSpielwiese.persistence.entities.Adresse
import com.example.jpaSpielwiese.persistence.entities.Player
import com.example.jpaSpielwiese.service.AccountService
import com.example.jpaSpielwiese.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.jdbc.JdbcTestUtils
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

import javax.sql.DataSource

import static org.springframework.boot.test.util.TestPropertyValues.of

@Testcontainers
@SpringBootTest(classes = DemoApplication.class)
@ContextConfiguration(initializers = Initializer.class)
class DemoApplicationSpec extends Specification {

    @Autowired
    DataSource dataSource

    @Autowired
    PlayerService playerService

    @Autowired
    AccountService accountService


    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        def postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
                .withDatabaseName("int-test-db")
                .withUsername("sa")
                .withPassword("sa")

        void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            postgreSQLContainer.start()
            of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    def 'Speichern der player in den datastore funktioniert'(){

        given: 'players'
        Player richard = new Player(name: 'richard', alter: 26)
        Player toni = new Player(name: 'toni', alter: 25)

        and: 'addresses'
        Adresse bonnAdr = new Adresse(plz: '53227', hausNr: 318, stadt: 'Bonn', straße: 'Teststraße')
        Adresse baerenstein = new Adresse(plz: '01127', hausNr: 13, stadt: 'Bärenstein', straße: 'Am Markt')

        richard.setAdresse(bonnAdr);
        toni.setAdresse(baerenstein);

        and: 'an empty table'
        assert JdbcTestUtils.countRowsInTable(new JdbcTemplate(dataSource: dataSource),'player') == 0

        when: 'storing players into the repo'
        playerService.savePlayer(richard)
        playerService.savePlayer(toni)

        then:
        JdbcTestUtils.countRowsInTable(new JdbcTemplate(dataSource: dataSource),'player') == 2

    }

    def 'Specihern der Accounts in den datastore auch'(){
        given: 'players'
        Player richard = new Player(name: 'richard', alter: 26)
        Player toni = new Player(name: 'toni', alter: 25)

        and:'an account'
        Account zockerAccount = new Account(fsk18: true, id: UUID.randomUUID())

        Set<Player> spielers = new HashSet<>()
        spielers.add(richard)
        spielers.add(toni)

        richard.setAccount(zockerAccount)
        toni.setAccount(zockerAccount)
        zockerAccount.setSpieler(spielers)

        and: 'an empty table'
        assert JdbcTestUtils.countRowsInTable(new JdbcTemplate(dataSource: dataSource),'accounts') == 0

        when: 'storing an account'
        def storedAccount = accountService.saveAccount(zockerAccount)

        then:
        assert JdbcTestUtils.countRowsInTable(new JdbcTemplate(dataSource: dataSource),'accounts') == 1
    }
}
