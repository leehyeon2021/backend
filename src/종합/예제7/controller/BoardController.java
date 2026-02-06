package 종합.예제7.controller;

import 종합.예제7.model.dao.BoardDao;
import 종합.예제7.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {
    private BoardController(){}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){return instance;}

    private BoardDao bd = BoardDao.getInstance();

    //(기능 축소로 인해 중개 역할밖에 안 함...)

    // 1. 게시물 등록 controller
    public boolean write( String bcontent , String bwriter ){
        boolean result = bd.write( bcontent , bwriter );
        return result;
    }

    // 2. 게시글 전체 조회 controller
    public ArrayList<BoardDto> findAll( ){
        ArrayList< BoardDto > result = bd.findAll();
        return result;
    }

    // 3. 게시물 수정 controller
    public boolean update( int bno , String bcontent){
        boolean result = bd.update( bno , bcontent );
        return result;
    }

    // 4. 게시물 삭제 controller
    public boolean delete( int bno ){
        boolean result = bd.delete( bno );
        return result;
    }

}// class end
