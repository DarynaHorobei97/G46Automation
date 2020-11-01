import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    private final static Logger LOG = LogManager.getLogger("Основной класс приложения");

    public static void main(String[] args) throws NullPointerException {

        Parent p = new Parent("Some name");
        p.printMethod();


        A a = new A();
        B b = new B();


        List<String> list = new ArrayList<>();
        list.add(null);

        try {
            a.textToLetters(list);
            b.textToLetters(Arrays.asList(a.getArray()));
            b.textToLetters(a.fromArrayToArrayList(a.getArray()));

            b.textToLetters(new ArrayList<String>());
        } catch (NullPointerException e) {
            LOG.error("Массив не определён. Пожалуйста проверьте корректность вводимых значений");
        } catch (Exception e) {
            LOG.error("Произошла неизвестная ошибка. Подробнее:" + e.getMessage());
        }


        A aa = new A();
        String[] array = new String[]{"aaa", "ddd", "bbb", "ccc", "eee"};
        a.fromArrayToArrayList(a.getArray());

        B bb = new B();
        String[] array1 = new String[]{"aaa", "ddd", "bbb", "ccc", "eee"};
        bb.sortAndPrint(aa.fromArrayToArrayList(array));
    }
}

