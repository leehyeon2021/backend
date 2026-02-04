package day010;

public class Tool implements TestInterface {
    // 해당 인터페이스를 구현한다. == "오버라이딩 한다."
    @Override public void method1(){
        System.out.println("해당 메소드 구현");
    }
    // method2 추상체를 만들었으면 무조건 구현체에서 메소드를 오버라이드해야 한다.
    // 상속은 오버라이드가 선택이었지만 인터페이스 추상은 오버라이드가 필수이다.
    @Override public void method2( int x ){
        System.out.println("해당 메소드 구현" + x );
    }
}
