package 종합.태현소영과제.controller;

import 종합.태현소영과제.model.dao.TradeDao;

public class TradeController {

    // 싱글톤
    // 1. 잠그기
    private TradeController(){}
    // 2. 상수 만들기. 인스턴스.
    private static final TradeController instance = new TradeController();
    // 3. 인스턴스 반환
    public static TradeController getInstance() {
        return instance;
    }

    // [*] dao 싱글톤 호출
    private TradeDao td = TradeDao.getInstance();

    // 회원가입 - 입력 받은 아이디, 비밀번호, 닉네임, 연락처 저장 등록제어
    public boolean signUp( String id , String pw , String name , String pn ){
        boolean saveResult = td.signUp(id , pw , name , pn);
        return saveResult;
    }

    // 로그인

    // 아이디 찾기

    // 비밀번호 찾기 - 아이디, 닉네임, 연락처가 일치하면


}
