package 종합.회원제중고거래시스템.view;

import 종합.회원제중고거래시스템.controller.MemberController;
import 종합.회원제중고거래시스템.controller.ProductController;

import java.util.Scanner;

public class MemberView {
    private MemberView(){}
    private static final MemberView instance = new MemberView();
    public static MemberView getInstance(){
        return instance;
    }

    private MemberController mc = MemberController.getInstance();
    private ProductView pv = ProductView.getInstance();

    Scanner scan = new Scanner(System.in);
    public void index(){
        for( ; ; ){
            System.out.print("1. 회원가입 2. 로그인 선택> ");
            int ch = scan.nextInt();
            if(ch==1){signup();}
            else if((ch == 2)){login();}
        }
    }

    // [1] 회원가입 페이지
    public void signup(){
        System.out.print("아이디: ");      String id = scan.next();
        System.out.print("비밀번호: ");      String pw = scan.next();
        System.out.print("닉네임: ");      String nickName = scan.next();
        System.out.print("연락처: ");      String phone = scan.next();
        boolean result = mc.signUp( id , pw , nickName , phone);
        //boolean result = true; 중간확인용이었음.
        if(result){System.out.println("회원가입 성공");}
        else{System.out.println("회원가입 실패");}
    }

    // [2] 로그인 페이지
    public void login(){
        System.out.print("아이디: ");  String mid = scan.next();
        System.out.print("비밀번호: ");  String mpw = scan.next();
        boolean result = mc.login(mid , mpw);
        if(result){
            System.out.println("로그인 성공");
            // 로그인 성공시 제품 index 페이지 실행.
            pv.index();
        }
        else{System.out.println("로그인 실패");}
    }
}
