package 종합.예제7;

// etc의 mysql-connector-j-9.6.0 <- 원래는 라이브러리추가 해야하는데 day011에서 한 번 해서 이제 안 해도 됨 (원래는 프로젝트마다 해야 하는데 이미 프로젝트에 있어서 괜찮다.)

import 종합.예제7.view.BoardView;

public class Appstart {
    public static void main(String[] args) {
        // 최초로 보여줄 view 메소드
        BoardView.getInstance().index();
    }// main end

}// class end
