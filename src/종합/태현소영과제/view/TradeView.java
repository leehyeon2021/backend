package 종합.태현소영과제.view;

import 종합.태현소영과제.controller.TradeController;

import java.util.Scanner;

public class TradeView {

    // 싱글톤
    // 1. 잠그기
    private TradeView(){}
    // 2. 상수 , 인스턴스
    private static final TradeView instance = new TradeView();
    // 3. 인스턴스 반환
    public static TradeView getInstance(){
        return instance;
    }

    // [*] controller 싱글톤 호출
    private TradeController tc = TradeController.getInstance();

    // 스캐너
    Scanner scan = new Scanner(System.in);

    // 회원가입 - 입력 받은 아이디, 비밀번호, 닉네임, 연락처 저장
    public void signUp(){
        System.out.print("아이디: ");      String id = scan.nextLine();
        System.out.print("비밀번호: ");     String pw = scan.nextLine();
        System.out.print("닉네임: ");      String name = scan.nextLine();
        System.out.print("연락처: ");      String pn = scan.nextLine();
        boolean result = tc.signUp( id , pw , name , pn);
        if( result ){System.out.println("[안내] 회원가입이 완료되었습니다.");}
        else{System.out.println("[가입 실패] 이미 존재하는 아이디입니다.");}
    }

    // 로그인

    // 아이디 찾기

    // 비밀번호 찾기


}
