package day011;

public class Exam2 {
    // 메소드1
    // throws : 해당 메소드에서 예외 발생시 메소드를 호출했던 곳으로 예외를 전달한다.
    public static void method1() throws NullPointerException{ // <-- 여기서 예외 던지기 throws
        String str = null;
        System.out.println( str.length() ); // 예외 발생 짐작 됨...
    }
    // 메소드2
    public static void method2() throws ClassNotFoundException { // 에외 던지기 <- throws 하면 method2();에 빨간줄 생김.
        Class.forName("java.lang.String3"); // 일반예외(빨간줄로 알려줌)
    }





    public static void main(String[] args) { // 메인함수에 떠넘기기 하지 말기... (흐름제어목적달성불가)
        // 예외처리 : try{}catch{}
        // 예외던지기(예외떠넘기기/전달) : throws
        // 1.
        try { method1(); }catch ( NullPointerException e ){System.out.println( e );}
        // 2.
        try { method2(); }catch ( ClassNotFoundException e ){System.out.println( e );} // <- 메소드2에서 throws하면 빨간줄 뜨기 때문에 try catch 필요. (예외 던졌다고 처리 안 하면 안 되겠구만)
    }
}
