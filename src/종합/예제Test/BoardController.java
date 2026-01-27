package 종합.예제Test;

public class BoardController {
    Board[] boards = new Board[100];

    // 게시물 등록 메소드
    boolean doPost( String content , String writer ){
        Board board = new Board(); //호출
        board.content = content;
        board.writer = writer;
        for( int i = 0; i<= boards.length-1 ; i++){
            if(boards[i]==null){
                boards[i] = board;
                return true;
            }
        }
        return false;
    }

    // 게시물 조회 메소드
    Board[] doGet(){
        return boards;
    }

}
class Board{
    String content;
    String writer;
}