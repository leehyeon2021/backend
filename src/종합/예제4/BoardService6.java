package 종합.예제4;

import java.util.Scanner;

// - 실행클래스: 입출력 담당
    // 프론트. (html css js 같은 걸로 하면. view가 됨)
        // +) 디자인 패턴: 프론트의 뷰, 백엔드의 컨트롤러. 뷰는 입출력, 컨트롤러는 입출력하면 안 됨.
public class BoardService6 {

    // -- 최초 실행 함수 = main

    public static void main(String[] args) {
        BoardController bc = new BoardController();                            // 여기에 하나 만들어주면 됨. (멤버변수 - 객체 하나당 멤버변수 하나)
        // [1] 반복문
        for(;;){
            System.out.println("======= My Commnuty =======");
            System.out.println("1. 게시물 쓰기 2. 게시물 출력");
            System.out.println("============================");

            System.out.print("선택> ");
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();

            if(ch==1){
                scan.nextLine();
                System.out.print("내용: "); String content = scan.nextLine();
                System.out.print("작성자: "); String writer = scan.nextLine();

                // BoardController의 저장 기능 호출하여 저장 결과 받기
                        // BoardController bc = new BoardController();        // 이 객체에서 저장된 배열이랑
                boolean result = bc.doPost( content , writer );
                if(result == true){System.out.println("[안내] 저장 성공");}
                else{System.out.println("[경고] 저장 실패");}

            }else if(ch==2){

                // BoardController의 조회 기능 호출하여 조회 결과 받기
                        // BoardController bc = new BoardController();        // 이 객체에서 저장된 배열이랑 다르다. 이러면 저장이 따로 됨. 반복할 필요도 없기 때문에 반복문 밖에 둬야 한다.
                Board[] boards = bc.doGet();
                for( int i = 0 ; i <= boards.length-1 ; i++){
                    if(boards[i] != null){
                        System.out.println("작성자: "+boards[i].writer);
                        System.out.println("내용: "+boards[i].content);
                        System.out.println("-------------------------");
                    }
                }
            }
        }//for end


    } // main end
} // class end
