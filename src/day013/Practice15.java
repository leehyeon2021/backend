package day013;

import 종합.과제3.model.dto.BookDto;
import 종합.예제7.model.dto.BoardDto;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

public class Practice15 {
    public static void main(String[] args) {
        /*[실습] 제출용 */
        /*[문제 1] BookDto는 toString()을 오버라이딩하지 않고
        BoardDto는 toString()을 오버라이딩하도록 만든 뒤 Object 타입 변수에 저장하여
        두 객체를 하나의 출력문으로 출력했을 때 결과 차이가 나타나게 만드세요.
        [출력예시]        day.BookDto@7cca494b | BoardDto{...}        */
        Object BookDto = new BookDto();
        Object BoardDto = new BoardDto();
        System.out.println(BookDto+" | "+BoardDto.toString());
        // 종합.과제3.model.dto.BookDto@448139f0 | BoardDto{bno=0, bcontent='null', bwriter='null', bdate='null'}

        /*[문제 2] new String("유재석")으로 생성한 두 객체의 == 와 equals() 비교 결과를  출력하시오.
        [출력예시]        == 비교:false, equals 비교:true        */
        String a2 = new String("유재석");
        String b2 = new String("유재석");
        System.out.println( a2 == b2 ); // false
        System.out.println( a2.equals(b2) ); // true

        /*[문제 3] Class 리플렉션
        1. String 객체를 하나 생성하고 getClass()를 이용하여 클래스 타입 정보를 가져오세요.
        2. Class.forName("java.lang.String")을 사용하여 String 클래스를 직접 로드하세요.
        3. 로드된 Class 객체에서 getMethods()를 사용하여 메소드 개수를 구하세요.
        4. 위 결과들을  출력하시오.
        [출력예시]        class java.lang.String | forName 성공 | method count:90        */
        String obj3 = "String 객체";
        Class a3 = obj3.getClass();
        System.out.println("a3 = " + a3);
        try {Class.forName("java.lang.String");
            System.out.println("forName 성공");} catch (ClassNotFoundException e) {}
        Method[] methods = a3.getMethods();
        int sum3 = 0;    for(int i = 0 ; i<methods.length;i++){sum3++;}
        System.out.println("method count: "+sum3);
        /*
        a3 = class java.lang.String
        forName 성공
        method count: 90
        */

        /*[문제 4] 문자열 "100"과 "3.14"를 각각 기본타입으로 변환하고 기본타입을 문자열로 변환하는 방법을 포함하여 출력하시오.
        [출력예시]        int:100, double:3.14, str1:"100", str2:"100"        */
        String a4 = 100+"";   String d4 = 3.14+"";  // 문자열 변환 해보기
        int b4 = Integer.parseInt(a4);     double e4 = Double.parseDouble(d4); // 기본 타입으로 변환
        String c4 = String.valueOf(b4);    String f4 = String.valueOf(e4);     // 문자열로 변환
        System.out.println(c4);            System.out.println(f4);             // 100  3.14

        /*[문제 5] LocalDateTime.now()로 현재 날짜/시간을 생성하고 지정된 포맷으로 변환 후 +10일, -30일 계산 결과를  출력하시오.
        [출력예시]        현재:2025년 07월 25일 11:43:11 | +10일:2025-08-04T11:43:11 | -30일:2025-06-25T11:43:11        */
        LocalDateTime localDateTime = LocalDateTime.now();        System.out.println("localDateTime = " + localDateTime);
        LocalDateTime dateTime1 = localDateTime.plusDays(10);        System.out.println("dateTime1 = " + dateTime1);
        LocalDateTime dateTime2 = localDateTime.minusDays(30);        System.out.println("dateTime2 = " + dateTime2);
        /*
        localDateTime = 2026-02-11T12:28:32.238527600
        dateTime1 = 2026-02-21T12:28:32.238527600
        dateTime2 = 2026-01-12T12:28:32.238527600
        */


    }
}
