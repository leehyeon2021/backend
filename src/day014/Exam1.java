package day014;

import java.awt.*;

public class Exam1 {
    public static void main(String[] args) {
        /*
        ## Thread 스레드
        - 프로세스
        : 프로그램(명령어집합)이 실행 중인 흐름.
           - 작업관리자(ctrl+alt+delete): 현재 프로세스 확인
        - 멀티 태스킹
        : 2가지 이상의 작업을 동시에 처리하는 것.
        - 멀티 프로세스
        : 하나의 운영체제가 2가지 이상의 프로세스(프로그램)을 동시에 처리하는 것 (멀티 테스킹을 하고 있는 것이다.)
        - 멀티 스레드
        : 프로그램이 2가지 이상의 명령어 동시에 처리하는 것. (멀티 테스킹을 하고 있는 것이다.)
        (그니까 한 번에 두 개의 기능이 진행되는 것 같은...?)
        - 스레드
        : 하나의 프로세스(프로그램) 내에서 실행되는 작업 단위. 실행 흐름 단위이다.
           - JS는 자체적인 스레드가 없다. 그래서 브라우저(크롬) 사용. 크롬이 스레드 역할을 한다.
           - JAVA/PYTHON/C는 자체적인 스레드가 있다. main 함수 사용. (프로그램 안에 main 함수 하나)
           1. 목적: 코드(명령어)들을 읽어 들이고 CPU에게 전달한다.
           2. 자바의 (기본)스레드
             - public static void main(String[] args) {} 함수가 내장됨.   */

        // 자바의 UI 제공하는 클래스
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // 1. 딘일(싱글) 스레드
        //    - 딘일(싱글) 스레드 에서는 '띵' 소리 기능과 '띵' 출력 기능을 동시에 할 수 없다.
        for( int i = 1 ; i <= 5 ; i++ ){ // **[ MAIN THREAD ]**
            toolkit.beep(); // '띵'(비프음)소리 제공하는 메소드
            try{Thread.sleep( 1000 );}catch (Exception e){} }// Thread.sleep(밀리초) 밀리초 만큼 현재 스레드 일시정지
        for(int i = 1 ; i <= 5 ; i++){ // **[ MAIN THREAD ]**
            System.out.println("띵");}
            /* 위 두 가지 for문은 **[ MAIN THREAD ]**가 처리.

        2. 멀티 스레드
        : 추가 스레드를 만드는 것은 메인 스레드가 한다. 반복문 돌리는 것도 메인 스레드가 한다.
        : main 스레드 외 새로운 **작업 스레드**를 생성하여 동시에 작업한다.
           1. 목적
           : **병렬 처리**. 동시에 여러 작업 처리 위함
           2. 사용처
           : 웹/앱 , 채팅 , 첨부파일 업로드 , JDBC 등등
           3. 구현방법
             - 방법1) 익명구현체 (이벤트, 웨이팅, 채팅 많은 게임 쪽에서 이걸 많이 사용)
             ```
             Runnable runnalbe = new Runnable(){ @Override public void run(){ 작업스레드코드 } }
             Thread thread = new Thread( runnable ).start()
             thread.start()
             ```
             - 방법2) 구현체 (웹/앱에서 많이 사용)
             ```
             class 작업스레드 implements Runnable{ @Override public void run(){ 작업스레드코드 } }
             작업스레드 변수 = new 작업스레드();
             Thread thread = new Thread( 변수 );
             thread.start();
             ```
             - 방법3) 상속 (많이 안 씀)
             ```
             class 작업스레드 extends Thread{ @Override public void run(){ 작업스레드코드 } }
             작업스레드 변수 = new 작업스레드();
             변수.start();
             ```

             > 주요 메소드
             >> Runnable 인터페이스
             >>: run추상메소드.
             >> 생성한 작업 스레드가 처리할 코드 집합
             >
             >> Thread 클래스
             >>: start메소드.
             >> 구현된 run 메소드 실행 메소드.
             >>+) 굳이 start 따로 뺀 이유: 다형성 때문이다. 편하게 쓰기 위함!

           1. 멀티 스레드1 **Runnable 인터페이스**
             : 익명 구현체(클래스가 추상메소드 구현)*/
        Runnable runnable = new Runnable(){ // **[ MAIN THREAD ]**
            //2. 추가된 작업스레드가 처리할 코드
            @Override public void run(){
                for( int i = 1 ; i <= 5 ; i++ ){ // **[ MAIN THREAD ] --> [ TASK1 THREAD ]**
                    toolkit.beep(); // '띵'(비프음)소리 제공하는 메소드
                    try{Thread.sleep( 1000 );}catch (Exception e){} }
            }
        }; // 익명구현체는 닫은 후에 꼭 ;세미콜론 넣기.
        //    3. 익명구현체 인터페이스를 thread 객체에 대입한다.
        Thread thread1 = new Thread( runnable ); // **[ MAIN THREAD ]**
        //    4. 스레드 객체가 start() 메소드를 호출하면 구현한 run메소드가 실행된다.
        thread1.start(); // **[ MAIN THREAD ] --> [ TASK1 THREAD ]**
        for( int i = 1 ; i <= 5 ; i++ ){ // **[ MAIN THREAD ]**
            toolkit.beep(); // '띵'(비프음)소리 제공하는 메소드
            try{Thread.sleep( 1000 );}catch (Exception e){}
        }

        /*
           3. 멀티 스레드2 구현체
             - 메인 스레드는 추가 스레드 만들어줌
             - 클래스로 구현해서 사용하는 방법.
             - [ MAIN THREAD ]⬇️        */
        SoundBeep soundBeep = new SoundBeep();
        Thread thread2 = new Thread( soundBeep );
        thread2.start(); // **[ MAIN THREAD ] --> [ TASK1 THREAD ]**. start() 넘어가서 SoundBeep 클래스가 실행된다.
        for( int i = 1 ; i <= 5 ; i++ ){ // **[ MAIN THREAD ]**
            toolkit.beep();
            try{Thread.sleep( 1000 );}catch (Exception e){}
        }

        /*
           4. 멀티 스레드3 (만드는법3) 상속
             - [ MAIN THREAD ]⬇️        */
        SoundBeep2 thread3 = new SoundBeep2();
        thread3.start(); // **[ MAIN THREAD ] --> [ TASK1 THREAD ]**. start()하면 넘어가서 SoundBeep2 클래스가 실행.
        for( int i = 1 ; i <= 5 ; i++ ){ // **[ MAIN THREAD ]**
            toolkit.beep();
            try{Thread.sleep( 1000 );}catch (Exception e){}
        }

    }
}

// [3]
class SoundBeep implements Runnable{/*   Runnable 구현.
    - Runnable 인터페이스 구현
    - run 추상메소드 구현 --> 추가 작업 스레드가 처리할 코드   */
    @Override public void run(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for( int i = 1 ; i <= 5 ; i++ ){
            toolkit.beep();
            try{Thread.sleep( 1000 );}catch (Exception e){}
        }
    }
}

// [4]
class SoundBeep2 extends Thread{ /*
    - Thread 클래스 상속
    - run 메소드 재정의 -> 추가 작업스레드가 처리할 코드 */
    @Override public void run(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for( int i = 1 ; i <= 5 ; i++ ){
            toolkit.beep();
            try{Thread.sleep( 1000 );}catch (Exception e){}
        }
    }
}//2 end