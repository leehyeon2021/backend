package 종합.과제3.view;

import 종합.과제3.controller.MemberController;

import java.util.Scanner;

public class MemberView {
    private MemberView(){}
    private static final MemberView instance = new MemberView();
    public static MemberView getInstance(){
        return instance;
    }

    private MemberController mc = MemberController.getInstance();
    private BookView bv = BookView.getInstance();

    Scanner scan = new Scanner(System.in);

    // 메인 화면
    public void index(){
        for (;;){
            System.out.println("==== 도서 도서관에 오신 것을 환영합니다. ====");
            System.out.println("  회원가입 (1)    |    로그인 (2)");
            System.out.println("---------------------------------------");
            System.out.print("숫자 입력> "); int ch = scan.nextInt();
            System.out.println("---------------------------------------");
            if(ch==1){signUp();}
            else if(ch==2){logIn();}
        }
    }//index end

    // 회원가입
    public void signUp(){
        System.out.print("이름: ");       String mname = scan.next();
        System.out.print("아이디: ");      String mid = scan.next();
        System.out.print("비밀번호: ");     String mpw = scan.next();
        boolean result = mc.signUp(mname , mid , mpw);
        if(result){System.out.println("\n"+mname+" 님 회원가입 성공. 메인 화면으로 돌아갑니다.\n");}
        else{System.out.println("\n회원가입 실패. 메인 화면으로 돌아갑니다.\n");}
    }

    // 로그인
    public void logIn(){
        System.out.print("아이디: "); String mid = scan.next();
        System.out.print("비밀번호: "); String mpw = scan.next();
        boolean result = mc.logIn(mid , mpw);
        if(result){System.out.println("\n로그인 성공. 도서관에 오신 것을 환영합니다.\n"); bv.index();}
        else{System.out.println("\n로그인 실패. 아이디와 비밀번호를 확인하세요.\n");}
    }




}//c end
