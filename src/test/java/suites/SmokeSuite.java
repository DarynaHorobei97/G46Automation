package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.authorization.LoginNegativeTest;
import tests.authorization.LoginParametrizedTest;
import tests.authorization.LoginPositiveTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginPositiveTest.class,
                LoginNegativeTest.class
        }
)
public class SmokeSuite {
}
