package 종합.예제4;

// - 게시물 기능 담당
    // 백엔드 - 게시물 데이터 기능
        // +) 디자인 패턴: 프론트의 뷰, 백엔드의 컨트롤러. 뷰는 입출력, 컨트롤러는 입출력하면 안 됨.
public class BoardController {

    // 속성: 멤버변수 - 객체 하나당 멤버변수 하나
    Board[] boards = new Board[100]; // boards의 타입은 Board

    // 기능: 메소드
    // [1] 게시물 등록 메소드
    boolean doPost(String content, String writer){

        // 1. 객체 생성
        Board board = new Board();

        // 2. 매개변수로 받은 값을 객체에 대입
        board.content = content;   board.writer = writer;

        for(int i = 0 ; i <= boards.length -1 ; i++){
            // 3. 만약에 i번째 요소가 비어있으면
            if(boards[i]==null){
                boards[i] = board; // 배열에 새로운 객체 저장
                return true; // 함수종료. true 반환했으므로 리턴 타입은 boolean.
            }
        } // for end
        return false; // for문 끝났음에도 저장 못했으면 false 반환으로 종료.
    } //doPost end

    // [2] 게시물 조회 메소드
    Board[] doGet() {
        return boards; // boards를 반환했으므로 리턴타입은 boards , 변수의 타입은 Board[]
    }


} // class end
