package day013;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Exam1 {
    public static void main(String[] args) {

        // 지난 시간... : 미리 만들어진 라이브러리/클래스: Object, Class, 래퍼 클래스
        // 1. 날짜/시간 클래스
        //    1. 현재 날짜 클래스 `LocalDate.now()` static이라 new를 안 쓴다.
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate); // localDate = 2026-02-11
        //    2. (컴퓨터)현재 시간 클래스
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime); // localTime = 09:43:23.227357700
        //    3. 현재 날짜+시간 클래스
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime); // localDateTime = 2026-02-11T09:44:04.210614400
        //    4. 정해진 날짜/시간 생성 `.of( 연도, 월, 일, 시, 분, 초 )`
        LocalDateTime dateTime = LocalDateTime.of( 2025, 7, 25, 11, 35, 15 );
        System.out.println("dateTime = " + dateTime); // dateTime = 2025-07-25T11:35:15
        //    5. 정해진 패턴(형식) 지정. 패턴(대소문자 유의): y M d h m s
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초"); // 원하는 패턴 만들기
        String today = dateTime.format( formatter ); // `날짜/시간객체.format( 날짜/시간패턴 )`
        System.out.println("today = " + today); // today = 2025년 07월 25일 11시 35분 15초 <-신기하다,,
        //    6. 날짜 계산: `.plusXXX(증가값)` , `.minusXXX(감소값)`
        LocalDateTime dateTime1 = dateTime.plusDays( 10 ); // `.plus어쩌고(증가할 값)`: 10일을 더한다.
        System.out.println("dateTime1 = " + dateTime1); // dateTime1 = 2025-08-04T11:35:15
        LocalDateTime localTime1= dateTime.minusDays(30);
        System.out.println("localTime1 = " + localTime1); // localTime1 = 2025-06-25T11:35:15
        //    7. 날짜 세부 정보
        int year = localDateTime.getYear();
        System.out.println("year = " + year); // year = 2026
        int month = localDateTime.getMonthValue();
        System.out.println("month = " + month); // month = 2
        int day = localDateTime.getDayOfMonth();
        System.out.println("day = " + day); // day = 11
        int hour = localDateTime.getHour();
        System.out.println("hour = " + hour); // hour = 10
        int minute = localDateTime.getMinute();
        System.out.println("minute = " + minute); // minute = 1
        int second = localDateTime.getSecond();
        System.out.println("second = " + second); // second = 13


    }//main end
}
