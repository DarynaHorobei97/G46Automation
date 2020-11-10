package old;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calc {
    private final static Logger LOG = LogManager.getLogger("Class Calc");

    public int calc(int a, int b) {
        return a + b;
    }

    public int calc(String a, int b) {
        try {
            int result = Integer.parseInt(a);
            return result + b;
        } catch (Exception e) {
            LOG.error(e.getMessage());

        } finally {
            return -1;
        }

    }
}
