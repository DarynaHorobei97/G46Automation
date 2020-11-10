package old;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Parent {
    private final static Logger LOG = LogManager.getLogger("Class Parent");

    protected String name;

    public Parent(String name) {
        this.name = name;
    }

    public Parent() {
    }

    public void printMethod() {
        LOG.info(name + ": Text output");
    }

    public void textToLetters(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            char[] lettersArr = list.get(i).toCharArray();
            for (int j = 0; j < lettersArr.length; j++) {
                LOG.debug(lettersArr[j]);
            }

        }
    }
}
