package 종합.과제2.view;

// 사용자 메뉴 출력, 입력 처리, Controller 호출 및 결과 출력

import 종합.과제2.controller.WaitingController;
import 종합.과제2.model.dto.WaitingDto;
import java.util.ArrayList;
import java.util.Scanner;

public class WaitingView {

    // 싱글톤
    // 1. 잠그기
    private WaitingView(){};
    // 2. 상수 , 인스턴스.
    private static final WaitingView instance = new WaitingView();
    // 3. 싱글톤 반환
    public static WaitingView getInstance(){
        return instance;
    }

    // Controller 호출
    private WaitingController wc = WaitingController.getInstance();

    // 스캐너
    Scanner scan = new Scanner(System.in);

    // 메인 메뉴
    public void indexView() {
        for(; ;){
            System.out.println("\n=============== 맛집 대기 시스템 ==============");
            System.out.println("1. 대기 등록  |  2. 대기 현황");
            System.out.println("============================================");
            System.out.print("선택> ");
            int ch = scan.nextInt();
            if (ch == 1) { // 대기 등록
                writeList();
            } else if (ch == 2) { // 현황 목록 출력
                printList();
            }
        }//for end
    }

    // 대기 등록 함수 - 전화번호 인원수 영구 저장
    public void writeList(){
        scan.nextLine();
        System.out.print("전화번호: ");     String phone = scan.nextLine();
        System.out.print("인원수: ");       int count = scan.nextInt();
        boolean result = wc.addWaiting(phone , count);
        if(result){System.out.println("[안내] 대기 등록 완료");}
        else{System.out.println("[안내] 대기 등록 실패");}
    }
    // 출력 함수 - 전체 목록 반환
    public void printList(){
        ArrayList<WaitingDto> waitingList = wc.getWaitingList();
        System.out.println("\n================= 대기 현황 =================");
        for( WaitingDto list : waitingList ){
            System.out.printf("대기 번호: %d번 | 연락처: %s | 인원: %d명\n", list.getNo(), list.getPhone(), list.getCount());
            System.out.println("===========================================");
        }

    }
}
