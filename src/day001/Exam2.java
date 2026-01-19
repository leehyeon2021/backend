package day001; // 패키지(폴더). 클래스 위치한 폴더명
public class Exam2 { // class s
    // public class: 공개용 클래스를 선언한다는 뜻을 갖는 키워드.
    // Exam2: 임의의 클래스명 정의한다. 첫 글자는 대문자로 해야 한다.

    // [1] m + 엔터: main함수
    // 자바에서 최초로 실행 흐름(스레드)을 갖는 (미리 만들어진) 함수
    public static void main(String[] args) { // main s

        // [2] 리터럴: 상수이면서 키보드로 입력 가능한 자료들.
        // ex) 3, 3.14, 'A', true, false
        System.out.println();            // sout + 엔터: System.out.println("출력하고 싶은 함수");
        System.out.println( 3 );         // JS의 console.log()와 동일한 기능의 함수.
        System.out.println("유");        // 선언 또는 함수 실행 뒤에 ;세미콜론 반드시 작성한다.
        System.out.println("유재석");     // 문자열 처리할 때 ""큰따옴표 사용.

        // [3] 자료형(타입,분류): 자료들을 효율적으로 사용하기 위한 분류 방법.
        // ⭐ 기본 타입 8가지. 외워야 함!! ⭐ (c언어랑 똑같음.)
        // 바이트(byte)란? bit(0또는1) ----> 01010101 (8bit/ bit가 8개)1바이트 -> 1024byte == 1mb -> 1024mb == 1gb
            // 나누는 이유: 효율 위함. -> 시계를 선물하기 위해 다이소에서 시계 크기 맞는 적당한(효율적인) 상자를 고른다.
        // 비트 안 따지는 이유: 윈도우 저장 운영체제가 bit가 아닌 byte이기 때문이다.
        // - 정수: byte(1byte, -128~127(0때문에128아님)),  short(2byte, +-3만정도),
        //        int(정수 기본 타임. 중요. 4byte, +-2억정도),    long(8byte, +-21억이상)
        // - 실수: float(4byte, 소수점8자리까지 가능),
        //        double(실수 기본 타입. 중요. 8byte, 소수점17자리 표현). (소수점이 이상으로 넘어가면 오차 생김)
        // - 문자: char(2byte, ''작은 따옴표 사용한다. 코드 번역법으로 유니코드 사용.)
        // - 문자열: String(문자열클래스, "" 큰따옴표로 감싼. 기본타입 아님.) (영어는 2byte, 한글은 3byte...)
        // - 논리: boolean(1byte, true/false) (실제로는 1bit를 사용하지만 운영체제 저장 방식 때문에 byte라고 표기.)
        // ======================= ⭐ 바이트, 기본 타입 8개+String ⭐ 다 외우기 !!! =======================

        // 1. boolean: true 또는 false 저장하는 타입
        boolean bool1 = true;
        // [JAVA] 자료형 변수명 = 값;    [동적 타입(JS 등)] let bool1 = true;
        boolean bool2 = false; // 변수명은 카멜표기법 권장, 숫자시작/특수/띄어쓰기 안 됨
        // boolean bool3 = 3; // [오류] boolean은 3을 저장할 수 없다.
        System.out.println( bool1 );
        System.out.println( bool2 );

        // 2. char: ''작은따옴표로 감싼 문자 1개를 저장하는 타입
        char ch1 = 'A';
        //char ch2 = 'ABC'; // [오류] 문자 여러 개 불가능.
        //char ch3 = "A"; // [오류] ""저장 불가능.

        // 3. String: ""큰따옴표로 감싼 문자 여러 개를 저장하는 (클래스)타입 (기본타입 아님!)
        String str1 = "ABC";
        System.out.println( str1 );

        // 4. byte: -128 ~ +127
        byte b1 = 100;
        // byte b2 = 300; // [오류] +127까지만 저장 가능.
        System.out.println( b1 );

        // 5. short: +-3만
        short s1 = 32000;
        //short s2 = 40000; // [오류] +30000까지만 저장 가능.
        System.out.println( s1 );

        // 6. int: +-21억정도, **정수의 리터럴 기본 타입**
        //         즉) 키보드로 부터 입력받은 값은 전부 int이다. 위에 나온 100, 32000 전부 int이다. int를 short, byte에 저장한 것
        int i1 = 2100000000;
        //int i2 = 3000000000; //[오류] 21억 넘어가면 안 됨
        System.out.println( i1 );

        // 7. long: +-21억 이상, 리터럴 뒤에 L/l(대소문자 엘) 붙인다.
        long l1 = 3000000000L; // 3000000000(==int타입이다!). 리터럴을 인트에서 롱으로 바꾸기 위해 L/l을 붙여주는(명시하는) 것이다.
        System.out.println( l1 );

        // 8. double: 소수점 17자리 표현, **실수의 리터럴 기본 타입**. 17자리 이상으로 가면 오차가 발생할 수 있다. (float의 두 배(double))
        double d1 = 0.12312312312121231233123;
        System.out.println( d1 );

        // 9. float: 소수점 8자리까지 표현. 리터럴 뒤에 F/f(대소문자 에프) 붙인다.
        float f1 = 0.123456789123456789F;
        System.out.println( f1 );
        float f2 = 123.123123123F; // 정수자리를 포함하여 8자리! (실무에선 잘 안 쓴다.)
        System.out.println( f2 );  // 123.12312 까지만 나온다.
            // +) 소수점 오차가 발생하거나 표현 한계로 사용 제약이 있다. String으로 문자열 처리하기도 함. 아니면 BigDecimal 등 사용. (다음에 배움)

        // 8가지가 부족하면 class 타입 (참조 타입) 만듦. 객체라고 부른다.


    } // main e

} // class e

/*
    ====== 코드 작성 ======        ====== 코드 실행 ======

    JS: console.log("자바");           브라우저

        -> 코드를 작성한 거지, 코드 실행은 아님.
           코드 실행은 브라우저가 함.

      JAVA: print("자바");             main함수 (c언어)

        -> 코드를 작성하고 메인 함수가 실행함.

*/