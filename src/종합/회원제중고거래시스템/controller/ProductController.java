package 종합.회원제중고거래시스템.controller;

import 종합.회원제중고거래시스템.model.dao.MemberDao;
import 종합.회원제중고거래시스템.model.dao.ProductDao;
import 종합.회원제중고거래시스템.model.dto.ProductDto;

import java.util.ArrayList;

public class ProductController {
    private ProductController(){}
    private static final ProductController instance = new ProductController();
    public static ProductController getInstance(){
        return instance;
    }

    private ProductDao pd = ProductDao.getInstance();

    // [1] 제품등록
//    public boolean add(String pname , int pprice , String pcomment){
//        System.out.println("ProductController.add");
//        System.out.println("pname = " + pname + ", pprice = " + pprice + ", pcomment = " + pcomment);
//        boolean result = true;
//        return result;
//    }
    // [1-1] 제품등록에 회원번호 불러오기
    // 로그인중인 회원번호는 mc의 로그인메소드(loginSession)에 있다! 이걸 반환하는 함수를 하나 만들어주고 오기. .getloginSesstion()
    public boolean add(String pname , int pprice , String pcomment){
        System.out.println("ProductController.add");
        System.out.println("pname = " + pname + ", pprice = " + pprice + ", pcomment = " + pcomment);
        // ++ 로그인 중인 회원번호 가져오기(다른 controller에서 저장중)
        int loginMno = MemberController.getInstance().getLoinSession();
        boolean result = pd.add(pname , pprice, pcomment, loginMno);
        return result;
    }

    // [2] 제품 전체 조회
    public ArrayList<ProductDto> findAll(){
        ArrayList<ProductDto> result = pd.findAll();
        // * 조회된 제품 목록에서 제품을 등록한 회원 번호로 닉네임 찾기.
        for( int i = 0 ; i<=result.size()-1; i++){
            ProductDto productDto = result.get(i);
            // * 회원번호를 MemberDao에게 전달하여 닉네임 반환받기
            String mname = MemberDao.getInstance().findMname( productDto.getMno() );
            productDto.setMname( mname );
        }
        return result;
    }

}//controller end
