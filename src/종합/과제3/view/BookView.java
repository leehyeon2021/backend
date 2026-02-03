package 종합.과제3.view;

import 종합.과제3.controller.BookController;
import 종합.과제3.controller.MemberController;
import 종합.과제3.model.dto.BookDto;
import 종합.과제3.model.dto.MemberDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BookView {
    private BookView(){}
    private static final BookView instance = new BookView();
    public static BookView getInstance(){
        return instance;
    }

    private BookController bc = BookController.getInstance();
    private MemberController mc = MemberController.getInstance();

    Scanner scan = new Scanner(System.in);

    // 관리자 페이지
    public void index(){
        // 일반 회원과 관리자를 구분할 수 있으면 좋겠는데!!
        for (;;){
            System.out.println("======== 원하는 기능을 선택하세요. ========");
            System.out.println("  도서 조회(1)  |  대출(2)  |  반납(3)\n  로그아웃(4)  |  [주의] 관리자 페이지(5)");
            System.out.println("---------------------------------------");
            System.out.print("숫자 입력> "); int ch = scan.nextInt();
            System.out.println("---------------------------------------");
            if(ch==1){findAll();}
            else if(ch==2){}
            else if(ch==3){}
            else if(ch==4){mc.logOut();System.out.println("로그아웃 되셨습니다.");break;}
            else if(ch==5){add();}
            else {System.out.println("숫자를 확인하십시오.");}
        }
    }// index end

    // 1. 전체 도서 조회
    public void findAll(){
        ArrayList<BookDto> books = bc.findAll();
        for(int i=0;i<books.size();i++){
            BookDto bookDto = books.get(i);
            System.out.printf("제목: %s, 작가: %s, 출판사: %s\n", bookDto.getBname(), bookDto.getBw(),bookDto.getBp());
        }
    }

    // 5. 관리자 회원 페이지
    public void add(){
        System.out.println("관리자 비밀번호를 입력하시오.");
        System.out.print("비밀번호: "); String pw = scan.next();
        boolean result = mc.admin(pw);
        if(result){
            System.out.println("\n======== [관리자 페이지] ========");
            System.out.println("등록할 도서 정보를 입력하시오.");
            System.out.print("제목:");    String bname = scan.next();
            System.out.print("작가:");    String bw = scan.next();
            System.out.print("출판사:");    String bp = scan.next();
             boolean result1 = bc.add(bname, bw, bp, 1); //mno는 추후에 관리자가 많을 시에 사용. 관리자 각자의 번호가 들어가면 됨. 관리자list랑 회원list 나눠야하나??ㅠㅠ
                if(result1){System.out.println("도서 등록이 완료되었습니다.");}
                else{{System.out.println("도서 등록 실패.");}
                }
        }
        else {System.out.println("관리자 비밀번호를 확인하시오.");}

    }
}
