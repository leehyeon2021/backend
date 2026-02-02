package 종합.회원제중고거래시스템.controller;

import 종합.회원제중고거래시스템.model.dao.MemberDao;

public class MemberController {
    private MemberController(){}
    private static final MemberController instance = new MemberController();
    public static MemberController getInstance(){
        return instance;
    }

    private MemberDao mc = MemberDao.getInstance();

    // [1] 회원가입 메소드
    public boolean signUp(String mid , String mpw , String mname, String mphone){
        // [*] controller - 유효성 검사 (아이디 중복 검사 , 데이터의 길이 검사 등등)

        // ⭐ 중간중간 확인용 콘솔 찍기 - 단축키: soutm , soutp. view에서 우선 index() 만들고 AppStart에서 실행
        // System.out.println("MemberController.signUp"); -> soutm
        // System.out.println("mid = " + mid + ", mpw = " + mpw + ", mname = " + mname + ", mphone = " + mphone); -> soutp
        //System.out.println("MemberController.signUp"); return true;// 중간 확인. 최종 완성 후 제거 예정.

        boolean result = mc.signUp( mid , mpw , mname , mphone);
        return result;
    }

    // [2] 로그인 메소드
//    public boolean login(String mid , String mpw){
//        System.out.println("MemberController.login");
//        System.out.println("mid = " + mid + ", mpw = " + mpw);
//        boolean result = pc.login(mid , mpw);
//        return result;
//    }
    // 로그인 성공한 회원번호 저장. 0이면 비로그인 , 3이면 3번 회원 로그인 중.
    private int loinSession = 0;    //세션Session이란?: 일정한 저장소 구역.
    public int getLoinSession(){ // 로그인중인 회원번호는 mc의 로그인메소드(loginSession)에 있다! 이걸 반환하는 함수를 하나 만들어주기.
        return loinSession;
    }
    public boolean login(String mid , String mpw){
        System.out.println("MemberController.login");
        System.out.println("mid = " + mid + ", mpw = " + mpw);
        int result = mc.login(mid , mpw);
        if(result>0){
            loinSession = result;   // '세션(걍변수임) 부여'
            return true;
        }
        return false;
    }

    // [3] 로그아웃 메소드 (인가 정보를 뺏어오는 것)
    public boolean logout(){
        // 로그인 상태를 0(비로그인)으로 변경. -> '세션 초기화'
        loinSession = 0;
        return true; // 로그아웃되면 true.
    }
}
