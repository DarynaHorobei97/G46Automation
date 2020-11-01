import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class B extends Parent {
    private final static Logger LOG = LogManager.getLogger("Class B");

    private String name;
    private int number;

    public B(String name) {
        super(name);
        LOG.info("Новый пустой экземпляр класса B");
    }

    public B(String name, int number) {
        super(name);
        this.number = number;
    }

    public B() {

    }

    public void sortAndPrint(List<String> list) {
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            LOG.debug(list.get(i));
        }
    }

}

