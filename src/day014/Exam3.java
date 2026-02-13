package day014;

public class Exam3 {
    public static void main(String[] args) {

        /*
        ## 동기화 vs. 비동기화
        : 메소드들은 대부분 비동기화 상태이다.
        ### 동기화 (synchronized)
        1. 정의
        : 메소드/기능에 Lock(락) 사용하여 메소드를 점령하는 상태
        2. 목적
        : 서로 다른 여러 스레드가 동시에 하나의 메소드를 사용한다면 충돌이 발생할 수도 있다. 충돌 예방~~
        3. 비교
           - 동기화
             - 처리 **순서 보장됨**
             - 주문 순서대로 음료 제조 후 손님에게 준다.
           - 비동기화
             - 처리 순서 보장 안 됨
             - 순서 상관 없이 제조가 먼저 완료된 음료를 손님에게 준다.

         4. 사용법
            - synchronized 타입명 메소드명(){}
            : synchronized는 멀티스레드, 채팅에서 사용.
            +) 채팅?: 몇 백명이 들어왔을 때 동시 처리하면 안전성 떨어진다. 대량 데이터 처리에서는 synchronized를 사용하여 안전 순서를 지키기.

            +) 비동기 쓸 때?: 아예 다른 기능을 처리할 때. 계산기는 같은 계산기를 사용하고 있기 때문에 동기함.

         * 예제) 2개의 스레드가 동일한 계산기객체를 멤버변수로 갖는 예제
            1. 계산기 객체 생성                 */
        계산기 계산기 = new 계산기();
        //   2. 스레드A
        작업스레드A threadA = new 작업스레드A();
        threadA.계산기 = 계산기;
        //   3. 스레드B
        작업스레드B threadB = new 작업스레드B();
        threadB.계산기 = 계산기;

        threadA.start();
        threadB.start();
        // --> 첫 번째 두 번째 둘 다 200이 나옴! 순서 왔다갔다... 뒤죽박죽... 뭐고 이거

        // synchronized: 동기화 메소드
        // --> 이거 하면 순서대로. 정상으로 나온다. 정상처리가 가능해진다.


    }//m end
}//c end

class 계산기{
    int memory; // 멤버변수 //계산기가 갖는 값
    // 메소드
    //public void setMemory( int memory ){ --> synchronized 없어서 막 나옴
    // synchronized : '동기화 됨'. 멀티스레드 할 때 꼭 사용해야 한다.
    public synchronized void setMemory( int memory ){ // --> synchronized 있어서 순차로 나옴.
        // this란? 현재 메소드를 실행한 객체라는 뜻
        // 멤버변수명과 매개변수명이 같을 때 식별용
        this.memory = memory;
        try {
            Thread.sleep(2000); // 2초간 스레드 일시정지
        }catch (Exception e){}
        System.out.println(Thread.currentThread().getName()); // 현재 스레드의 이름을 알려줌!
        System.out.println("결과: "+this.memory);
        // --> 첫 번째 두 번째 둘 다 200이 나옴!
    }
}

// 2개의 쓰레드 가 동일한 계산기객체를 갖는 예제
class 작업스레드A extends Thread{
    계산기 계산기;
    @Override public void run() {
        계산기.setMemory( 100 ); // A계산기에 100 넣고
    }
}

class 작업스레드B extends Thread{
    계산기 계산기;
    @Override public void run() {
        계산기.setMemory( 200 ); // B계산기에 200 넣었을 때
    }
}