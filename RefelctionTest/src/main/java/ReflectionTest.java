import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class ReflectionTest {
    public static void start(Class<?> с) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = с.getDeclaredMethods();
        Method before = null;
        Method after = null;
        List<Method> list = new ArrayList<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) list.add(method);
            else if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (before != null) {
                    throw new RuntimeException("You can have only one mark @BeforeSuite");
                }
                before = method;
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (after != null) {
                    throw new RuntimeException("You can have only one mark @AfterSuite");
                }
                after = method;
            }
        }
        list.sort(((o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority()));
        if (before != null) list.add(0, before);
        if (after != null) list.add(after);

        for (Method method: list) {
            method.setAccessible(true);
            method.invoke(null);
        }
    }

}

