import java.lang.reflect.InvocationTargetException;

public class Start {
    public static void main(String[] args) {
        try{
            ReflectionTest.start(ForTest.class);
        }catch (InvocationTargetException|IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
