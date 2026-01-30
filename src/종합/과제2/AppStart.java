package 종합.과제2;

// 프로그램 시작 담당

import 종합.과제2.view.WaitingView;

public class AppStart {
    // View를 직접 new하지 않고 싱글톤으로 접근
    public static void main(String[] args) {
        WaitingView.getInstance().indexView();

    }
}
