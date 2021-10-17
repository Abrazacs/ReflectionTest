public class ForTest {


    @BeforeSuite
    public static void before (){
        System.out.println("Welcome traveler!");
    }

    @Test(priority = 3)
    public static void method1 (){
        System.out.println((1+2 == 3));
    }
    @Test(priority = 5)
    public static void method3 (){
        System.out.println("123123123123");
    }
    @Test(priority = 5)
    public static void method4 (){
        System.out.println("11243123");
    }
    @Test
    public static void method5 (){
        System.out.println("123123");
    }
    @Test(priority = 4)
    public static void method6 (){
        System.out.println("13244224422344234");
    }
    @Test(priority = 7)
    public static void method7 (){
        System.out.println("1223");
    }

    @AfterSuite
    public static void method8 (){
        System.out.println("Goodbye traveller");
    }

}
