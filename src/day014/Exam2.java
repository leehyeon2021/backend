package day014;

import java.time.LocalTime;
import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {

        /* 멀티스레드 사용해보기
        ### 타이머 만들기
           - class 만들기 -> 스레드
        - 시게 스레드 만들기    */
        시계스레드 시계스레드 = new 시계스레드();
        Thread thread1 = new Thread( 시계스레드 );
        thread1.start();
        // - 타이머 스레드 만들기
        타이머스레드 타이머스레드 = new 타이머스레드(); //사실 여기서는 그냥 변수 선언만 해도 됨. 왜냐면 아래 for문에서 다시 정의할 거니까.
        타이머스레드.start();

        // [ MAIN THREAD 입력 ]
        for(;;){
            System.out.println(" 타이머: 1)ON  2) OFF :");
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();
            if(ch==1){
                타이머스레드=new 타이머스레드();
                타이머스레드.state=true;// 멤버변수로 상태 관리. 타이머스레드.stop()으로 해도 되는데 write()처럼 비권장.
                타이머스레드.start();
            }
            else if(ch==2){
                if (타이머스레드 != null){
                    타이머스레드.state=false;
                }
            }
        }

        // --> 입력 대기하는 애: 메인 스레드
        //     시계 계속 출력하는 애: 시계 스레드
        //     1입력하면 시계랑 타이머 출력하는 애: 시계스레드+타이머스레드
        // => 총 세 개가 실행되고 있다.


    }
}

// 타이머 만들기
// 시계 스레드 만들기
class 시계스레드 implements Runnable{
    // run 정의
    @Override public void run() {
        // 무한루프
        for(;;){
            // 현재시간
            System.out.println( LocalTime.now() );
            // main스레드가 아닌 !현재! 작업스레드 1초
            try{ Thread.sleep( 995 ); } //숫자는 그냥 오차 봐서 대충 정한 거. 보통 1000으로 함. (전에 함)
            catch(InterruptedException e){}

        }
    }
}

// 타이머 스레드 만들기
class 타이머스레드 extends Thread{
    // 타이머 실행 상태
    boolean state = false;
    @Override public void run(){
        // 타이머가 계산하는 초
        int second = 0;
        for(;;){
            if( state == false){break;} // 타이머 종료
            // 1초 증가
            second++;
            System.out.printf("[타이머]: %d초\n",second);
            try{ Thread.sleep( 995 ); } //숫자는 그냥 오차 봐서 대충 정한 거. 보통 1000으로 함. (전에 함)
            catch(InterruptedException e){}
        }
    }
}