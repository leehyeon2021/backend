package 종합.과제3.controller;

import 종합.과제3.model.dao.MemberDao;

public class MemberController {
    private MemberController(){}
    private static final MemberController instance = new MemberController();
    public static MemberController getInstance(){
        return instance;
    }
    private MemberDao md = MemberDao.getInstance();

    // 회원가입
    public boolean signUp( String mname , String mid , String mpw){
        boolean result = md.signUp(mname, mid , mpw);
        return result;
    }

    // 로그인
    private int loginSession = 0;
    public int getLoginSession(){
        return loginSession;
    }
    public boolean logIn(String mid , String mpw){
        int result = md.logIn( mid , mpw );
        if(result>0){
            loginSession = result;
            return true;
        }
        return false;
    }

    // 로그아웃
    public boolean logOut(){
        loginSession = 0;
        return true;
    }

}
