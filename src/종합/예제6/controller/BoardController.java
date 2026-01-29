package 종합.예제6.controller;

import 종합.예제6.model.dao.BoardDao;
import 종합.예제6.model.dto.BoardDto;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BoardController {

    // 싱글톤 만들기
    // [1] 잠그기
    private BoardController(){}
    // [2] 상수 만들기
    private static final BoardController instance = new BoardController();
    // [3] 싱글톤
    public static BoardController getInstance(){
        return instance;
    }

    // MVC 패턴 흐름에 따라 DAO 싱글톤 호출 (Controller -> DAO)
    private BoardDao bd = BoardDao.getInstance();

    // 1] **등록 제어: view에게 입력받은 content, writer 받아서 dao에게 요청 후 결과를 view에게 전달**
    public boolean doPost( String content , String writer ){
        // 다양한 유효성검사(있는지 없는지) / 자료의 타입 확인 등등을 여기서 해야 했음 (지금은 안 함)
        // 1) DAO에게 content와 writer를 전달하고 결과 받기
        boolean saveResult = bd.doPost( content , writer );
        // 2) DAO에게 받은 결과를 View에게 전달
        return saveResult;
    }
    // 2] 전체 조회 처리: view에게 모든 게시물들을 요청 받아 dao에게 재요청하여 결과를 view에게 전달한다.
    public ArrayList< BoardDto > doGet(){
        // 추후에는 정렬, 검색, 유효성검사 함. 지금은 단순 조회라서 중간 역할만 함.
        ArrayList<BoardDto> result = bd.doGet();
        return result;
        // vs. return bd.doGet(); ->result에 저장할지 안 할지 차이. 선택사항.

    }
}
