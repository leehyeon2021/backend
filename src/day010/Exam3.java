package day010;


public class Exam3 {
    public static void main(String[] args) {

        // 1. 구현체 만들기
        //new Customer(); // 인터페이스를 만들어준 구현(객)체~
        Buy buy = new Customer();
        buy.method1(); // 추상메소드 호출 가능. 오버라이딩 된 것이 나온다.
            //buy.method6(); <-- 형제 관계에서는 불가능.
            //Sell sell = buy; <-- 형제 관계에서는 형변환 불가능.
        Customer customer = (Customer) buy; // 거쳐가기
        Sell sell = customer;
        sell.method6();
        // Customer로 갔다가 Sell로 가는 거 가능. 이유: 태생이 Customer라서. Customer는 부모가 두 개.
        // Customer를 가지고 Buy, Sell 운용?가능. 동일한 목적으로 서로 다른 기능 수행.

        // 2. 디폴트 메소드 실행 가능
        buy.method2( 2 );

        // 3. static(정적)메소드 실행 가능
        Buy.method3(); // Buy. 첫 글자 대문자

        // 4. private 메소드 호출 실행 불가능
        //Buy.method4();
        //Buy.method5();


    }// main end
}// class end

interface Buy{
    // * 상수
    // 1. 추상메소드: 선언부만 있고 구현부{}가 없는 메소드 . <-- **구현체가 구현할 대상**
    public abstract void method1();
    // 2. 디폴트 메소드: 인터페이스가 구현한 메소드 .
    public default int method2( int x ){ return x; }
    // 3. 정적메소드: 인터페이스 내 정적 구현 메소드 . 구현체 없이 실행 가능.
    public static void method3(){System.out.println("정적구현메소드");}
    // 4. private 메소드: 현재 인터페이스내에서 사용하는 메소드 (오버라이딩 안 됨~)
    private void method4(){}
    private static void method5(){}

}// inter end

interface Sell{void method6();}// inter end

class Customer extends Object implements Buy, Sell{ // 상속(extends)은 1번만 가능 , 구현(implements)은 여러 번 가능.
    // !! extends는 오버라이딩이 선택 , implements는 오버라이딩이 필수.
    // 오른쪽 클릭 -> 생성 -> 메소드 재정의
    @Override
    public void method1() {System.out.println("[판매]");}
    @Override
    public void method6() {System.out.println("[구매]");}
}