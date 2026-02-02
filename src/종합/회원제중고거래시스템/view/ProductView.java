package 종합.회원제중고거래시스템.view;

import 종합.회원제중고거래시스템.controller.MemberController;
import 종합.회원제중고거래시스템.controller.ProductController;
import 종합.회원제중고거래시스템.model.dao.ProductDao;
import 종합.회원제중고거래시스템.model.dto.ProductDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductView {
    private ProductView(){}
    private static final ProductView instance = new ProductView();
    public static ProductView getInstance(){
        return instance;
    }

    private ProductController pc = ProductController.getInstance();
    private MemberController mc = MemberController.getInstance();

    private Scanner scan = new Scanner(System.in);

    // [*] 제품 메인 페이지
    public void index(){
        for(;;){
            System.out.println("1. 제품등록 2. 제품전체조회 3. 로그아웃 선택> ");   int ch = scan.nextInt();
            if(ch==1){ add();}
            else if(ch==2){findAll();}
            else if(ch==3){
                mc.logout();
                System.out.println("로그아웃");
                break; // ⭐ break;하면? -> 원래 있던 곳(MemberView의 pv.index())으로 돌아가게 된다. 다시 회원가입/로그인 창 나옴.
            }

        }//for end
    }//index end

    // [1] 제품 등록 페이지
    public void add(){
        System.out.print("제품명: ");      String pname = scan.next();
        System.out.print("제품가격: ");    int pprice = scan.nextInt();
        System.out.print("제품설명: ");     String pcomment = scan.next();
        boolean result = pc.add(pname , pprice , pcomment);
        if(result){System.out.println("제품 등록 성공");}
        else{System.out.println("제품 등록 실패");}
    }

    // [2] 제품 전체 조회
    public void findAll(){
        ArrayList<ProductDto> productDtos = pc.findAll(); //pc.findAll()넣기 전에 임시로 null을 넣어놨음.
        for( int i = 0 ; i<=productDtos.size()-1 ; i++){
            ProductDto productDto = productDtos.get(i);
            System.out.printf("제품번호: %d | %s | %d | 판매자: %s\n",
                    productDto.getPno(), productDto.getPname(), productDto.getPprice(),
                    productDto.getMname());
            //임시로 판매자 대신 회원번호 .getMno를 했다가, dto에 mname을 만들어서 판매자 이름 넣을 수 있게 됨.

        } // for end
    }

}// c end
