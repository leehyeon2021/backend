package 종합.과제3.model.dao;

import 종합.과제3.model.dto.MemberDto;
import java.util.ArrayList;

public class MemberDao {
    private MemberDao(){}
    private static final MemberDao instance = new MemberDao();
    public static MemberDao getInstance(){
        return instance;
    }

    private ArrayList<MemberDto> memberList = new ArrayList<>();
    private int currentMno = 1;

    // 회원가입
    public boolean signUp(String mname , String mid , String mpw){
        String qname="일반 회원";
        if(mname.equals("admin")&&mid.equals("admin")&&mpw.equals("admin")){currentMno=0; qname="관리자";}
        MemberDto memberDto = new MemberDto(currentMno, mname, mid, mpw, qname);
        boolean result = memberList.add(memberDto);
        if(result){currentMno++;}
        return result;
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

}
