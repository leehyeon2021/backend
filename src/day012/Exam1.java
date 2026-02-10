package day012;

import 종합.예제7.model.dto.BoardDto;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Exam1 {
    public static void main(String[] args) {

        /*
        ## 잊지 말아야 할 것들
        ### **기본** 타입
        : byte , short , int , long , flot, double, boolean, char.
           - 8개. 리터럴(상수)(키보드로 입력받는) 값 들을 분류하는 타입.
           - 소문자로 시작한다.
           - 자료 1개 저장할 때 사용.
         ### **참조** 타입
         : String , Scanner , MemberDto, [] 등등.
            - 기본타입 외 모두 침조 타입이다.
            예) 배열, 클래스, 인터페이스
            - 대문자로 시작한다.
            - 기본 타입 외 개발자가 새로운 타입을 만드는 행위
            예) int/double 2개를 합친 타입은 없음. 이런 서로 다른 타입들을 하나로 묶어주는 게 참조타입.

        ## 자바 회사에서 제공하는 기본 클래스 들
        ### 1. Object
        : 자바의 최상위 클래스. 모든 클래스는 object로 부터 상속 받는다.     */
        Object o1 = 3;          // 상속 받았기 때문에 대입 가능하다. 모든 값들은 Object로 부터.
        Object o2 = 3.14;       // 3.14(자식) , Object(부모)
        Object o3 = true;
        Object o4 = "홍길동";            Object o5 = new Object();
        Object o6 = new int[3];         Object o7 = new BoardDto();/* 종합예제7일 걸 - 그냥 예제로.
        즉) 모든 자료들은 Object로 타입변환 가능하다. 다형성!

           1. toString(): 인스턴스/자료 주소값(메모리위치) 반환 함수    */
        System.out.println( o6.toString() ); // [I@214c265e. 할당된 주소값 나옴.(개발자가 제어 불가. 확인용)
        System.out.println( o7.toString() ); /* BBoardDto{bno=0, bcontent='null', bwriter='null', bdate='null'} . 이와 같이 toString을 오버라이딩한 객체는 문자열 출력.

           2. .equals() : 주소가 참조하는 객체 내부를 비교. vs == : 변수가 갖는 주소(위치) 또는 리터럴 비교.*/
        Object o8 = new BoardDto();
        Object o9 = new BoardDto();
        System.out.println( o8 == o9 ); // false
        System.out.println( o8.equals( o9 ) ); // false

        Object o10 = o9; // 객체 참조 복사/복제
        System.out.println( o10 == o9 ); // true

        String str1 = new String("홍길동");
        String str2 = new String("홍길동");
        System.out.println( str1 == str2 ); // false. 주소값 다름. 서로 다른 객체가 같은 문자열을 갖는다.
        System.out.println( str1.equals( str2 ) ); /* true. 서로 다른 객체 내 문자열을 비교.

           3. .hashCode() : 객체를 식별하는 값을 정수로 반환.*/
        System.out.println( str1.hashCode() );  // 54150062 홍길동
        System.out.println( str2.hashCode() );  // 54150062 홍길동
        System.out.println( o10.hashCode() ); // 2093176254 o9
        System.out.println( o9.hashCode() );  // 2093176254 new BoardDto()
        System.out.println( o8.hashCode() );  /* 1854731462 new BoardDto()

        ### 2. Class: 클래스 정보(멤버변수/메소드 등등) 담는 클래스  (자바 클래스 중 하나. 클래스의 Class 엌ㅋㅋㅋ)*/
        String obj1 = new String();
        Class c1 = obj1.getClass();
        System.out.println( c1 ); // class java.lang.String

        Integer obj2 = 3;
        Class c2 = obj2.getClass();
        System.out.println( c2 ); /* class java.lang.Integer

           1. Class.forName( "패키지명.클래스명" ); . 일반예외 (이것만 알고 있어도 된대)
              - ** 리플랙션**: 최초실행(컴파일)할 때 객체 생성하지 않고 **실행 도중**에 객체 생성. == '동적 처리'
              - 사용처: JDBC(DB연동) , 스프링프레임워크( 자바플랫폼. 스프링은 아래를 자동으로 해줌. )= = '외부 라이브러리 동적 객체 생성' (개발자 편의성 위함.) */
        try{Class.forName( "java.lang.String" );} // String 클래스가 존재하면 객체가 동적으로 생성된다.
        catch (ClassNotFoundException e){} /*

           2. 클래스 내 멤버변수 , 생성자 , 메소드 확인. ( 배열에 넣어서 프린트 했음 )        */
        Field[] fields = c1.getFields(); // 클래스 내 모든 멤버변수/속성/필드/프로퍼티 이름 확인. (private는 조회 안 됨.)
        for( int i = 0 ; i<fields.length ; i++){ // 하나 있어서 하나 나옴
            System.out.println(fields[i]); // public static final java.util.Comparator java.lang.String.CASE_INSENSITIVE_ORDER
        }

        Constructor[ ] constructors = c1.getConstructors(); //클래스 내 모든 생성자 확인 (매개변수 확인)
        for(int i=0;i<constructors.length;i++){
            System.out.println(constructors[i]); // 15개. 오버로딩으로 만들어진 다수의 생성자.
        }

        Method[ ] methods = c1.getMethods(); // 클래스 내 모든 메소드 확인
        for( int i = 0 ; i<methods.length;i++){
            System.out.println(methods[i]); //엄청많이나옴...
        }
        /*

        ### 3. 래퍼 클래스: 기본타입을 참조 타입으로 표현.
           - 장점: 기본 타입은 메소드가 없다. (메소드==기능)
                  참조 타입은 메소드가 있기 때문에 사용. 점 찍어서 기능 사용하려고 쓴대. */
        int value1 = 100; // 자료는 100, 분류/타입은 int
        Integer value2 = 100; // 자료는 100, 분류/타입은 Integer
        // System.out.println( value1.toString() );
        System.out.println( value2.toString() ); /* Integer는 참조타입이라서 기능이 있다.
           1. 언박싱과 오토박싱
              1. 언박싱
              : 참조 타입에서 기본 타입으로 가는 것.
              예) Integer -> int.*/
        int value3 = value2;
        /*
              2. 오토박싱
              : 기본 타입에서 참조 타입으로 가는 것.
              예) int -> Integer*/
        Integer value4 = value1; /*
        - 사용처
        : 자바에서 외부자료들과 자료들을 주고받을 때 타입을 변환한다. (엑셀/CSV/공공데이터API/JS통신/PYTHON통신)   (parse라서 파싱이라고 하시는 것 같음. 파싱!)
           - 파싱: 외부 자료 가져올 때.
           `기본타입 변수 = 참조타입.parse기본타입("문자열");` 이렇게 하는 듯 */
        int val1 = Integer.parseInt("100"); // "100" -> 100
        double val2 = Double.parseDouble("3.14"); // "3.14" -> 3.14
        float val3 = Float.parseFloat("3.14"); // "3.14" -> 3.14
        boolean val4 = Boolean.parseBoolean("true"); /* "true" -> true
        - 기본타입 -> 문자열 반환법 */
        String s1 = 100+""; // `기본타입자료+""`
        String s2 = String.valueOf( 100 ); // `String.valueOf()`
    }
}
