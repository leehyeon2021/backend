package day014;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam4 {
    public static void main(String[] args) {


        /*
        * 자료 구조 책 무조건 봐야 한대~~~~~
        * 포폴에 필요한 것: 큰 작업을 하기 위한 작은 프로그램
          예) 굳이굳이 이런 스레드풀 같은 기능 넣어서 할 줄 안다는 거 보여주기...
             규모가 작더라도 큰 규모를 대비해서 한번 써보기.

        ## Thread Pool 스레드풀
        1. 정의
        : 미리 일정 개수의 Thread를 생성하고 필요에 따라 재사용하는 방식
        2. 목적
        : 작업이 들어올 때마다 새로운 스레드가 아닌 기존 스레드를 이용한다.
        3. 효과
        : Thread 재사용, 자원 효율성, 서버과부하 방지 등등
        4. 구조
        : '큐'라는 자료구조를 배치하여 순서대로 스레드풀에서 대기 중인 스레드에게 작업 배정
           - 큐
           : 자료의 데이터를 요청 순서대로 처리하는 방법. 먼저 들어온 요청이 먼저 처리한다.
                ---------------------------------------------
           input(입구)         [요청3][요청2][요청1]       output(출구)
                ---------------------------------------------
         5. 스레드풀 예시( 콜센타 )

                              직원1(김기덕/스레드)
             콜 요청  ------>  직원2(강감찬/스레드)
                              직원3(이순신/스레드)
            - 만약에 2개의 콜이 동시에 들어오면 -> 2명이 각각 배정되고 직원 1명이 대기
            - 만약에 5개의 콜이 동시에 들어오면 -> 3명이 각각 배정되고 콜요청 2개 대기

         6. 사용처
            1. 서버프로그램
            2. 채팅
            3. 대기프로그램
            4. SPRING 프레임워크

         7. 사용법
            1. ExecutorService executorService = Executors.newFixedThreadPool( 총스레드수 );
            2. executorService.submit( 스래드객체 );
            3. executorService.shutdown(  );
            */

        // 1. 작업스레드 배정/만들기
        //   - '3'이면 -> 총 3개의 스레드가 돌아가면서 작업을 처리한다.
        ExecutorService executorService = Executors.newFixedThreadPool( 3 ); // 넣은 숫자만큼 처리됨
        // 2. 여러 스레드를 만들어서 각 스레드 들을 작업 스레드풀에 등록하기
        for( int i = 1; i <=10 ; i++){
            String name = "Thread " +i; // 스레드 이름 배정
            // 3. 작업 스레드 생성
            Runnable runnable = new Runnable() {
                @Override public void run() {
                    try{
                        //+ new Random().nextInt(1000) <- 난수 넣은 이유 (몰라ㅠㅠ 랜덤으로 하려고??)
                        Thread.sleep( 1000 + new Random().nextInt(1000) );
                    }catch (Exception e){}
                    System.out.println("작업 중인 스레드: "+ name);
                }
            };
            // 4. 생성된 작업스레드를 스레드*풀에 등록한다.
            //    만일 스레드풀에 대기 중인(놀고 있는) 스레드가 있으면 실행, 아니면 대기.
            executorService.submit( runnable );
        }
        // 5. 스레드풀 종료( 스레드풀에 저장된 모든 스레드 안전하게 종료 )
        executorService.shutdown(); // 해당하는 스레드 완전히 끝남. 아니면 프로그램이 끝나거나.
    }
}
