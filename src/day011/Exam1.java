package day011;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {

        // 1. 예외 처리: 개발자가 구현한 로직이나 사용자의 영향으로 문제가 발생할 때 예외 처리가 가능하다.
        //          +) 시스템오류: 시스템이 종료되는 심각한 문제.(하드웨어적 문제)
        // 2. 예외 종류
        //    1. 일반 예외: 컴파일(실행)될 때 예외 처리 코드 검사 (코딩하자 빨간줄 뜸 -> ㅇㅋ 바꿈 -> 끝)
        //       - 입출력, 네트워크, 파일, JDBC(DB연동) 등 주로 외부와 통신할 때 일반 예외가 많이 발생한다. 너무 많아서 암기 불가.
        //    2. 실행 예외: 실행 도중에 발생하는 예외 처리 코드 검사 (개발자의 예측/경험에 의존도가 크다.)
        //       - 연산 문제, null(자바 문제 오류 1등... nullPointer), index, 데이터 타입 등 주로 코드적인 문제.
        // 3. 목적
        //    1. 예외를 고치는 게 아니라 ⭐ (try에서)예외가 발생하면 피해서 다른 코드(catch)로 이동하는 것이 목적이다.
        //       - 즉: 24시간 코드가 실행될 수 있게 하는 것이다.
        //       - if와 유사함. if와 예외처리 모두 흐름제어이다.
        // 4. 사용법1
        //    try{ 예외가 발생하거나 발생할 것 같은 코드 } ->이래서 예측/경험에 의존한다는 것.
        //    catch( 발생한예외클래스명 변수명 ){ 만약에 예외가 발생했을 때 처리할 코드 }
        //  +) 예외는 실행했을 때 실행 도구 창에 나옴. (ctrl+shift+enter)
        // 5. 일반 예외 클래스 (외우지 못함) 주요 몇 개만 보는 중...
        //    1. ClassNotFoundException: 클래스를 못 찾았을 때 발생하는 예외 클래스
        //    2. InterruptedException : 흐름(스레드)이 중단 되었을 때 발생하는 예외 클래스
        // 6. 실행 예외 클래스 (외워두셈)
        //    1. NullPointerException : 널이라는 포인터에서 예외가 발생했다.
        //    2. NumberFormatException : 문자열을 정수로 바꿀 수 없다.
        //    3. ArrayIndexOutOfBoundsException : 인덱스 넘쳤어요! 반복문 처리하다가 많이 생기는 예외.
        //    4. InputMismatchException : Scanner 사용 시 비정상적인 입력값이 들어오면 예외 발생.
        //    ⭐ Exception : 모든 예외의 상위(부모) 클래스.
        //    +) finally : 예외 발생 여부 상관없이 무조건 실행되는 구역.
        // 7. 사용법2 (다중catch)
        //    try{ 예외가 발생하거나 발생할 것 같은 코드 }
        //    catch( 발생한예외클래스명 변수명 ){ 만약에 예외가 발생했을 때 처리할 코드 }
        //    catch( 발생한예외클래스명 변수명 ){ 만약에 예외가 발생했을 때 처리할 코드 }
        //    finally{ 예외 여부 상관없이 무조건 실행되는 코드 }

        //    1) 일반 예외 예시: Class.forName( "패키지명.클래스명" ); : 현재 프로젝트 내 클래스가 존재하는지 검사/동적할당
        try { // try에서 예외가 발생하면 catch로 넘어간다.
            Class.forName( "Java.lang.String" ); // <- String 클래스가 존재하는지 확인. 빨간줄 뜨기 때문에 하라는대로 try/catch 해줌.
        } catch (ClassNotFoundException e1) { // 변수명(e1) 아무거나. e == error
            System.out.println("예외발생1: String 클래스가 없습니다.");
        }
        //    2) 일반 예외 예시2: Thread.sleep( 밀리초 ) : 현재 흐름(스레드) 일시정지 메소드
        try {
            Thread.sleep( 1000 ); // 현재 흐름(스레드) 1초간 일시정지
        } catch (InterruptedException e2) {
            System.out.println("예외발생2: 스레드 중단이 발생했습니다.");
        }
            // 일반예외 클래스들은 실행 전에 코드 밑줄에 빨간색으로 예외 발생 가이드라인을 해준다.
        //    3) 실행 예외 예시3
        try {
            String name = null;
            System.out.println(name.length()); // `.`: 접근/도트 연산자. 객체가 존재해야만 기능한다. <- NullPointerException 널이라는 포인터에서 예외가 발생했다.
        }catch (NullPointerException e3){
            System.out.println("예외발생3: null은 메소드를 호출/사용할 수 없습니다.");
        }
        //    4) 실행예외 예시4
        try {
            String str1 = "100";
            String str2 = "1abc";
            int int1 = Integer.parseInt(str1);    // Interger.parseInt( 문자열 ): 문자열을 정수타입으로 변환하는 메소드이다.
            int int2 = Integer.parseInt(str2);    // NumberFormatException. "100" -> 100 [o] , "1abc" -> ? [x].
        }catch (NumberFormatException e4){
            System.out.println("예외발생4: 정수타입으로 반환이 불가능하다.");
        }
        //    5) 실행예외 예시5: ArrayIndexOutOfBoundsException
        try {
            int[] ary = {1, 2, 3};
            System.out.println(ary[2]); // 2번 인덱스 값은 3
            System.out.println(ary[3]); // 3번 인덱스 값은 없다. 인덱스 값 없을 때 예외 발생.
        }catch (ArrayIndexOutOfBoundsException e5){
            System.out.println("예외발생5: 존재하지 않는 인덱스 입니다.");
        }
        //    6) 실행예외 예시6: InputMismatchException
        try {
            Scanner scan = new Scanner((System.in));
            int value = scan.nextInt(); // 만약에 비정상적인 입력값이면 예외 발생.
        }catch ( InputMismatchException e6){
            System.out.println("예외발생6: 입력할 수 없는 정보 또는 잘못된 형식입니다." + e6); //<-- ⭐e6 프린트하면 왜 예외가 발생했는지 알 수 있다. ((이거 하래))
        }
        //    7) 다중 catch : 예외는 다양한 이유로 발생한다. 예외 중에 상위클래스가 존재한다. Exception 클래스. InputMismatchException 같은 곳에 Exception 넣으면 된다.
        try {
        }catch ( NumberFormatException e77 ){
            System.out.println( e77 );
        }catch ( NullPointerException e7 ){
            System.out.println( e7 );
        }catch ( Exception e ){                 // 모든 예외를 처리해주는 상위 클래스. 다중 catch할 경우 가장 마지막에 사용한다. 다중할 경우 위 두 개 제외 모든 예외를 처리해준다.
            System.out.println( e );            // Exception을 위에서 사용하면 밑으로 나오는 예외들이 죽는다. (Exception이 다 해먹어서...)
        }finally { //    8) finally : 예외가 있든 없든 무조건 실행되는 구역.
            System.out.println("예외 발생 여부 상관없이 무조건 실행되는 구역");
        }

    }// main end
}// class end

