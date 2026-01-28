package day007;

public class Exam4 {

    //main함수는 어떻게 돌아가는 걸까요
    void 멤버메소드(){} // 1) 멤버함수
    static void 정적멤버메소드(){} // 2) 정적메소드

    public static void main(String[] args) {
        /*
        1. final
            : 고정, 최종 이라는 뜻. 고정/최종이니까 변수 수정 안 됨. 오버라이딩(재정의같은거) 금지.
            - 사용법
                : final 타입 변수명 = 초기값 ;
                -> final 변수는 초기값이 무조건 필수이다. < 수정 못하니까 >*/

        // 클래스명.정적(static)변수 ->static넣으면 객체 없이도 가능하다.
        System.out.println( D.point ); // 정적 변수는 객체가 필요 없다.
        System.out.println( D.name );
        // 객체변수명.고정(final)변수 -> final은 객체를 만들어서 호출해야 한다.
        D d = new D();
        System.out.println( d.PI ); // D.PI 안 됨.
        // d.PI = 3.112; //error -> final은 수정 안 됨.

        /*3. static
            : 정적인 이라는 뜻. 공유변수만들때사용, 서로 다른 객체들끼리 공유.
            - 사용법
                : static 타입 변수명; , static void 메소드명(){}
                -> static 변수/메소드는 프로그램 실행시 **우선(메모리)할당** 되고 프로그램 종료시까지 유지. !!우선 할당!!
                -> 메모리 할당된 변수/메소드이므로 객체가 필요없다. < 과도한 사용은 좋지 않다. >
                -> 프로그램내 공유 변수 , 공유 메소드에 대해서 사용 , 즉] 프로그램 내 1개만 존재해야 하는 변수/메소드
                -> static 갖는 메소드는 실행문에서 일반메소드 호출이 불가능하다. < 객체 필요 >
            +) 멤버메소드(); -> error. static이 갖는 변수/메소드는 우선할당이므로 객체가 아닌 멤버메소드를 모른다.*/
               Exam4 exam4 = new Exam4(); // 객체 만들어서 멤버메소드 호출하자
               exam4.멤버메소드(); // 이건 오류 안 남.
               정적멤버메소드(); // main메소드가 static 갖고, 정적멤버메소드도 static 갖기 때문에 서로 알고 있는 상태이다. 그래서 < 객체 필요 없음 >

        // 4. public static final
        //    : 상수

        //
        //D.method1(); //error 오버라이딩 금지
        d.method1();
        D.method2();





    } //main end
} // class end

class D{

    // * final 키워드는 초기값이 필수다.
    //final int 최종변수; -> error.
    final double PI = 3.14159;

    // * static 키워드는 (객체들 간) 공유변수. 초기값이 필요 없다.
    static int point;

    // * 상수(수정불가능한변수): public static final. 위 두 개 합쳐서 static final,그리고 public도 넣음.
    public static final char name = 'A';

    // final 메소드: 오버라이딩/재정의 금지
    public final void method1(){}
    // static 메소드: 객체 유무 없이 호출 가능한 메소드
    public static void method2(){}


}