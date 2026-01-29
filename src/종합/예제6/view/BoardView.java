package 종합.예제6.view;

import 종합.예제6.controller.BoardController;

public class BoardView {

    // 싱글톤 만들기
    // [1] 잠그기
    private BoardView(){}
    // [2] 상수 만들기
    private static final BoardView instance = new BoardView();
    // [3] 싱글톤
    public static BoardView getInstance(){
        return instance;
    }

    // MVC 패턴 흐름에 따라 controller 싱글톤 호출 (View -> Controller)
    private BoardController bc = BoardController.getInstance(); // new BoardController하면 새로운 애가 탄생... 안 돼! getter로 데려오자(호출)!

}
