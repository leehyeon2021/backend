package 종합.과제1;

import java.util.Scanner;

public class WaitingService {
    public static void main(String[] args) {
        // 객체 생성
        WaitingController wc = new WaitingController();

        // for문
        for(;;){
            // 메뉴 보여주기
            System.out.println("\n========== 맛집 대기 시스템 ==========");
            System.out.println("1. 대기 등록    |    2. 대기 현황");
            System.out.println("=====================================");

            // 입력 받기
            Scanner scan = new Scanner(System.in);
            System.out.print("선택> "); int ch = scan.nextInt();

            // 등록1 , 현황2
            if(ch==1){ //등록할 수 있게 해줘야 한다.
                scan.nextLine();
                System.out.print("전화번호: ");   String phone = scan.nextLine();
                System.out.print("인원 수: ");    int count = scan.nextInt();
                // 생성해둔 객체 메소드 호출 , 인자로 전달
                boolean waiting = wc.addWaiting( phone , count );
                if(waiting == true){
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                }else{
                    System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");
                }
            }else if(ch==2){ //현황 볼 수 있게 해줘야 한다.
                System.out.println("-------------- 대기 현황 --------------");
                Waiting[] waiting = wc.getWaitingList();
                for(int i = 0 ; i <= waiting.length-1 ; i++){
                    if(waiting[i]!=null){
                        System.out.println("전화번호: "+waiting[i].phone+" , 인원 수: "+waiting[i].count);
                        System.out.println("--------------------------------------");
                    }
                }//for end
            }//if elseif end
        }//for end


    }//main end
}//class end
