package old;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class A extends Parent {

    private final static Logger LOG = LogManager.getLogger("Class A");

    private String name;
    private int number;

    private String[] array = new String[]{"aaa", "ddd", "bbb", "ccc", "eee"};

    public A(String name) {
        super(name);
        LOG.info("Новый пустой экземпляр класса A");
    }

    public A(String name, int number) {
        super(name);
        this.number = number;
    }

    public A() {
        super();
    }


    public String[] getArray() {
        return array;
    }

    public List<String> fromArrayToArrayList(String array[]) {
        int i = 0;
        List<String> arrayList = new ArrayList<>();

        while (i != 4) {
            arrayList.add(array[i]);
            i++;
        }

        return arrayList;
    }
}
