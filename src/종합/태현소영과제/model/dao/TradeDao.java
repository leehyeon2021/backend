package 종합.태현소영과제.model.dao;

import 종합.태현소영과제.model.dto.TradeDto;
import java.util.ArrayList;

public class TradeDao {

    // 싱글톤
    // 1. 잠그기
    private TradeDao(){}
    // 2. 상수 , 인스턴스
    private static final TradeDao instance = new TradeDao();
    // 3. 인스턴스 반환
    public static TradeDao getInstance(){
        return instance;
    }

    // 저장소 생성
    private static final ArrayList<TradeDto> tradeList = new ArrayList<>();
    // 번호 자동 부여
    private static int currentNo = 1;

    // 회원가입 - 입력 받은 아이디, 비밀번호, 닉네임, 연락처 저장
    public boolean signUp( String id , String pw , String name , String pn ){
        TradeDto tradeDto = new TradeDto( currentNo , id , pw , name , pn );

        boolean result = tradeList.contains(id);

        if(!result){
            tradeList.add(tradeDto);
            currentNo++;
            return true;
        }else{
            return false;
        }

    }

    // 로그인

    // 아이디 찾기

    // 비밀번호 찾기
//    public String pwFinder(String id , String name , String pn){
//
//    }

}
