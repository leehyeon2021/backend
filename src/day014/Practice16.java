package day014;

public class Practice16 {
    public static void main(String[] args) {

        // [1]
        DeliveryTask deliveryTask = new DeliveryTask();
        Thread thread1 = new Thread( deliveryTask );
        thread1.start();

        for(int i=1;i<=3;i++){
            System.out.println("[메인] 주문 화면 갱신"+i);

        }


    }

}
/*[문제 1] 배달 진행 + 화면 갱신 “동시 실행” 구현
상황: 배달 진행(작업 스레드)과 주문 화면 갱신(메인 스레드)이 동시에 돌아야 한다.
요구사항(구현)
DeliveryTask implements Runnable 클래스를 만든다.
run()에서 1초마다 아래 문장을 3번 출력한다.
        [배달기사] 이동중 1
        [배달기사] 이동중 2
        [배달기사] 이동중 3
main에서는 DeliveryTask를 작업 스레드로 실행한다. (start() 사용)
동시에 main 스레드도 1초마다 아래 문장을 3번 출력한다.
        [메인] 주문 화면 갱신 1
        [메인] 주문 화면 갱신 2
        [메인] 주문 화면 갱신 3
작업 스레드가 끝날 때까지 main에서 join()으로 대기한 후
[안내] 배달 처리 종료 출력
출력 예시(순서는 섞여도 됨)
        [배달기사] 이동중 1
        [메인] 주문 화면 갱신 1
        [배달기사] 이동중 2
        [메인] 주문 화면 갱신 2
        ...
        [안내] 배달 처리 종료*/
class DeliveryTask implements Runnable{
    @Override public void run() {
        for(int i=1;i<=3;i++){
            System.out.println("[배달기사] 이동중"+i);
            try{
                Thread.sleep( 1000 );
            }catch (Exception e){}
        }
    }
}

/*[문제 2] 공유 장바구니 “안전한 총액 계산” 구현 (synchronized 적용 버전)
상황: 두 사용자가 동시에 장바구니 총액을 수정해도 값이 정확해야 한다.
요구사항(구현)
Cart 클래스에 int total 멤버변수를 만든다.
addPrice(int price) 메소드를 만든다.
total += price;
Thread.sleep(500);
[장바구니] 추가금액=price, 현재총액=total 출력
addPrice()는 반드시 synchronized로 동기화한다.
UserAThread는 addPrice(100)을 5번 호출한다.
UserBThread는 addPrice(200)을 5번 호출한다.
두 스레드를 실행하고, 종료될 때까지 join()으로 대기한다.
마지막에 아래 출력:
        [최종] total=?? / 예상=1500
출력 예시(순서는 달라도 되지만 total은 최종 1500이어야 함)
        [장바구니] 추가금액=100, 현재총액=100
        [장바구니] 추가금액=200, 현재총액=300
        ...
        [최종] total=1500 / 예상=1500*/


/*[문제 3] 고객 문의 처리 시스템 구현 (스레드풀)
상황: 고객 문의 10건을 처리하는데, 동시에 최대 3건까지만 처리하도록 제한한다.
요구사항(구현)
ExecutorService pool = Executors.newFixedThreadPool(3); 생성
InquiryTask implements Runnable 클래스를 만든다.
        문의 1~10까지 작업을 pool에 제출한다.
각 작업은 아래 순서로 동작해야 한다.
        [처리시작] 문의 n | 스레드=... 출력
Thread.sleep(2000);
[처리완료] 문의 n | 스레드=... 출력
모든 작업 제출 후 shutdown() 호출
프로그램이 바로 끝나지 않도록 awaitTermination()로 최대 30초 대기
종료 직전:
        [안내] 모든 문의 처리 종료
출력 예시(한 번에 3개씩 처리되는 느낌이 나야 함)
        [처리시작] 문의 1
        [처리시작] 문의 2
        [처리시작] 문의 3
        (2초 후)
        [처리완료] 문의 1
        [처리완료] 문의 2
        [처리완료] 문의 3*/