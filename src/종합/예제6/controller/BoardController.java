package 종합.예제6.controller;

import 종합.예제6.model.dao.BoardDao;

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
}
