package 종합.과제3.model.dao;

import 종합.과제3.model.dto.MemberDto;
import java.util.ArrayList;

public class MemberDao {
    private MemberDao(){}
    private static final MemberDao instance = new MemberDao();
    public static MemberDao getInstance(){
        return instance;
    }

    private static ArrayList<MemberDto> memberList = new ArrayList<>();
    private int currentMno = 2;

    // 회원가입
    public boolean signUp(String mname , String mid , String mpw){
        String qname="일반 회원";
        MemberDto memberDto = new MemberDto(currentMno, mname, mid, mpw, qname);
        boolean result = memberList.add(memberDto);
        if(result){currentMno++;}
        return result;
    }
    private static final MemberDto admin = new  MemberDto(1, "admin", "admin", "admin",  "관리자");
    private static MemberDto getadmin(){
        memberList.add(admin);
        return admin;
    }

    // 로그인
    public int logIn(String mid , String mpw){
        for(int i=0;i<memberList.size();i++){
            MemberDto members = memberList.get(i);
            if(members.getMid().equals(mid)&&members.getMpw().equals(mpw)){
                return members.getMno();
            }//if end
        }//for end
        return 0;
    }// logIn end


    // 관리자 계정 - 비밀번호를 입력하여 관리자 페이지로 이동.
    public boolean admin(String pw){
        if(pw.equals(getadmin().getMpw())){
            return true;
        }
        return false;
    }

}
