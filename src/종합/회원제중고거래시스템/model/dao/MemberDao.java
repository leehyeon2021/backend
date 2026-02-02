package 종합.회원제중고거래시스템.model.dao;

import 종합.회원제중고거래시스템.model.dto.MemberDto;

import java.util.ArrayList;

public class MemberDao {
    private MemberDao(){}
    private static final MemberDao instance = new MemberDao();
    public static MemberDao getInstance(){
        return instance;
    }

    private ArrayList<MemberDto> members = new ArrayList<>();
    // 자동 회원번호를 부여하기 위한 최신 회원번호
    private int currentMno = 1;


    // [1] 회원가입
    public boolean signUp(String mid , String mpw , String mname , String mphone){
        // 1. 객체(dto) 생성한다.
        MemberDto memberDto = new MemberDto(currentMno , mid , mpw , mname , mphone);
        // 2. 회원객체를 리스트에 저장한다.
        boolean result = members.add(memberDto);
        if( result ){currentMno++;}
        // 3. 저장 성공시 true 반환.
        return result;
    }

    /*
    저장된 아이디와비밀번호와 입력한 정보가 동일한지 비교하고
    맞다면 로그인처리(로그인상태기억/저장 ) , 아니면 로그인실패
    로그인이란? 아이디와 비밀번호가 일치하면 ( 인증 과정 )
    인가 란 ? 인증(로그인) 성공 하면 징표(토큰) 발급 과정( 인가 )
    토큰은 Controller 에 저장한다.
     */

    // [2] 로그인
//    public boolean login(String mid , String mpw){
//        System.out.println("MemberDao.login");
//        System.out.println("mid = " + mid + ", mpw = " + mpw);
//        for( int i = 0 ; i <= members.size()-1; i++){ // 1. 리스트 (배열) 0부터 마지막 인덱스까지
//            // 2. i번째 회원객체를 꺼낸다.
//            MemberDto memberDto = members.get(i);
//            // 3. 만약에 i번째 회원객체 내 아이디와 비밀번호가 입력받은 아이디/비밀번호와 같다면
//            if(memberDto.getMid().equals(mid)&&memberDto.getMpw().equals(mpw)){
//                // 4. 로그인 성공
//                return true;
//            }// if end
//        }// for end
//        // 5. 반복문 중에 동일한 정보가 없다면 로그인 실패
//        return false;
//    }// login end
    public int login(String mid , String mpw){
        System.out.println("MemberDao.login");
        System.out.println("mid = " + mid + ", mpw = " + mpw);
        for( int i = 0 ; i <= members.size()-1; i++){ // 1. 리스트 (배열) 0부터 마지막 인덱스까지 반복한다.
            // 2. i번째 회원객체를 꺼낸다.
            MemberDto memberDto = members.get(i);
            // 3. 만약에 i번째 회원객체 내 아이디와 비밀번호가 입력받은 아이디/비밀번호와 같다면
            if(memberDto.getMid().equals(mid)&&memberDto.getMpw().equals(mpw)){
                // 4. 로그인 성공하면 회원번호 반환
                return memberDto.getMno();
            }// if end
        }// for end
        // 5. 반복문 중에 동일한 정보가 없다면 로그인 실패 0
        return 0;
    }// login end

    //https://docs.google.com/spreadsheets/d/1XpbIxZuGjroICxLkADi3LhpAKKPSzjgplYjSrSqEvNk/edit?gid=2108243744#gid=2108243744
    // [3] 회원 번호로 닉네임 조회하는 기능
    public String findMname( int nmo ){
        for(int i = 0 ; i<=members.size()-1; i++){
            if(members.get(i).getMno() == nmo ){    // 만약에 i번째 회원번호가 조회할 회원번호와 같다면
                return members.get(i).getMname();   // 찾은 회원번호 반환
            }
        }
        // 없으면 null 반환.
        return null;
    }


}
