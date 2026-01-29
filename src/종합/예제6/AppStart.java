package 종합.예제6;

// 말 그대로 시작해주는 곳. 실행은 항상 main함수가 있는 곳에서 실행!!

import 종합.예제6.view.BoardView;

public class AppStart {
    public static void main(String[] args) {

        // 최초로 실행할 화면 view 요청한다.
        BoardView.getInstance().indexView();

    }// main end
}// class end
