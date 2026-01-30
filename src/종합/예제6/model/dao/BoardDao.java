package 종합.예제6.model.dao;

import 종합.예제6.model.dto.BoardDto;
import java.util.ArrayList;

public class BoardDao {

    // 싱글톤 만들기
    // [1] 잠그기
    private BoardDao(){}
    // [2] 상수 만들기
    private static final BoardDao instance = new BoardDao();
    // [3] 싱글톤 반환
    public static BoardDao getInstance(){
        return instance;
    }

    // 데이터베이스 역할을 하는 ArrayList <- 추후에 삭제 예정. 나중엔 진짜 데이터베이스로. 이번엔 DB를 ArrayList로 대체. // 보기 좋게 상수로 만듦(뭔소린지아직모르겠음ㅠㅠ)
    private static final ArrayList<BoardDto> boardDB = new ArrayList<>(); // boardDB는 BoardDto를 여러 개 가지고 있다. //앞에서는 boardDB가 아니라 boards로 했음. 앞서 했던 예제랑 같은 거.
    // 전역변수에 최신 게시물번호 저장 < 식별키 생성 목적 : 추후에 삭제 예정 >
    private static int currentNO = 1;

    // 1] ** 등록 처리: Controller가 dao에게 content와 writer에게 전달하여 등록 요청한다. **
    public boolean doPost(String content , String writer){
        // 1) 매개변수에 따른 객체 생성 + 게시물번호 자동생성(DB가 자동으로 만들어주기 때문에 나중엔 안 함. 20번째줄에작성함👆)
        BoardDto boardDto = new BoardDto( currentNO , content , writer);
        // 2) 반복문 필요없이 그냥 .add( 새로운값 )로 저장. / 추가하면 true 실패하면 false 반환하는 기능/함수/매소드
        boolean saveResult = boardDB.add( boardDto );
            currentNO++; // 다음 저장할 게시물의 번호를 1증가한다.
        // 3) 저장 성공 여부를 controller에게 반환한다.
        return saveResult;
    }
    // 2] 전체 조회 처리: controller가 dao에게 모든 게시물들을 요청한다.
    public ArrayList< BoardDto > doGet( ){
        return boardDB; // 개별 조회 1개 반환타입: BoardDto vs. 전체 조회 N개 반환타입 ArrayList<BoardDto>
    }

    // DAO가 전체를 반환!
}
