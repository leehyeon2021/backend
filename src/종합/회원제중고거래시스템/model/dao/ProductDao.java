package 종합.회원제중고거래시스템.model.dao;

import 종합.회원제중고거래시스템.model.dto.ProductDto;
import java.util.ArrayList;

public class ProductDao {
    private ProductDao(){}
    private static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance(){
        return instance;
    }

    private ArrayList<ProductDto> productDtos = new ArrayList<>();
    private int currentPno = 1;

    // [1] 제품 등록. loginMno(판매자 회원번호. ==로그인중 회원번호)
    public boolean add(String pname , int pprice , String pcomment , int loginMno){ //loginMno는 판매자 회원번호.
        // 1. 제품 객체
        ProductDto productDto = new ProductDto(currentPno, pname , pprice , pcomment, loginMno);
        // 2. 리스트에 제품 객체 저장
        boolean result = productDtos.add(productDto);
        // 3. 제품 등록 성공시 제품번호 1 증가한다.
        if(result){currentPno++;}
        // 4. 성공 여부 반환
        return result;
    }

    // [2] 제품 전체 조회
    public ArrayList<ProductDto> findAll(){
        return productDtos;
    }

}
