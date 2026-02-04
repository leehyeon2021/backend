package day010;

// 인터페이스

public class Exam1 {
    public static void main(String[] args) {

        // 1. 인터페이스 정의
        // : 서로 다른 시스템이나 장치 사이에서 정보를 주고 받는 접점/경계
        // 2. 생활 속 예시
        // : 리모컨, 키오스크, 키보드, 휴대폰, 게임기 (같은 기계(인터페이스) 안의 다른 소프트웨어/게임(클래스))
        // 3. 사용 목적
        // : **동일한 목적을 가졌으나 서로 다르게 작동**하는 걸 만들기 위함.
        // 함수/메소드 = 상호작용 = 매개변수/리턴
        // -> 상호작용 약속.  (목적만 보면 오버라이딩이랑 비슷함.)
        // 4. 특징
        //    1. 객체의 호환성을 높이고 다형성을 구현할 때 사용한다.
        //    2. 서로 다른 클래스들 사이에서 중간 매개 역할을 한다.
        //      + 자바 회사에서 먼저 상속(오버라이딩)을 개발했더니 다형성의 중요성이 커져서 오버라이딩 전용 타입이 개발되었다.
        //        --> 그게 인터페이스이다.
        // 5. 자바 새 JAVA 클래스 -> 인터페이스.
        //    1. interface 인터페이스명{}
        //    +) 인터페이스는 자체 객체 생성이 불가능하다. (== 생성자가 없기 때문이다.)
        //       (x)`TestInterface testInterface = new TestInterface();` <- 불가능. 생성자가 없음!
        //    2. class 클래스명 implements 인터페이스명{} (implements 구현 vs. extends 상속)
        //       **인터페이스를 구현해준 클래스의 객체 = 구현(객)체**
        //    예시) Tool이라는 클래스 하나 만듦.
        TestInterface testInterface = new Tool(); // Tool이 상속받았기 때문x , Tool이 구현했기 때문o
        // 6. 추상메소드 `public abstract 반환타입 메소드명( 타입 매개변수 );``
        // : 메소드 선언부만 존재하며 {} 구현부가 없다.
        //   (어차피 상속 받아서 오버라이딩 할 거면 애초에 부모가 구현을 왜 함 <- 이런 건가)
        //   implements 하는 클래스 내에서 추상메소드 오버라이딩/재정의
        testInterface.method1(); // "해당 메소드 구현"

        // - 상수 호출 가능.
        System.out.println(TestInterface.b);

        testInterface.method2( 10 );

// 같이 본 파일: Tool.java , TestInterface.java

    }
}
