package 종합.예제5;

// 유지보수를 위해 파일 나누기
    // Board : 데이터 모델, 캡슐화 적용
    // BoardController : 로직담당, static 기반 관리
    // BoardService : 실행, 화면 담당

public class BoardController {

    // [1] private: 외부접근 차단 , static: 우선할당(객체없이) , final(수정금지)
            // final: 인덱스 안에 있는 요소들은 수정 가능하다. (가방 수정은 불가하나 가방 내용물은 수정 가능하다.)
    private static final Board[] boards = new Board[100];

    // [2] 기능1: 저장 기능
    public static boolean doPost(String content , String writer){
        // 1. 생성자를 이용한 객체 생성
        Board board = new Board( content , writer);
        // 2.
        for( Board element : boards){ //향상된 for문. // (int i = 0 ; i <= boards.length-1 ; i++)
            if(element == null){
                element = board;
                return true; // 성공시 true
            }//if end

        }//for end
        return false; // 실패시 false
    } // boolean: 1byte(1bit). 용량이 작아서 더 빠르게 처리되기 때문에 사용.

    // [3] 기능2: 조회 기능 , boards가 리턴값이므로 반환타입은 boards의 타입인 Board[]
    public static Board[] doGet(){
        return boards;
    }
}
