package 종합.예제4;
// 데이터 처리
public class BoardController1 {
    Board1[] boards1 = new Board1[100];

    boolean doPost(String content , String writer){
        Board1 board1 = new Board1();
        board1.content = content;
        board1.writer = writer;

        for( int i = 0 ; i <= boards1.length-1 ; i++){
            if(boards1[i]==null){
                boards1[i] = board1;
                return true;
            }
        } return false;
    }

}

class Board1{
    String content;
    String writer;
}