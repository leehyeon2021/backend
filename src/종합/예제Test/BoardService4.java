package 종합.예제Test;

/*
    ⭐ 확인할 것 (부주의함을 주의할 것.....) ⭐
    1] 다른 파일에 오류 있을 때
        - 면 실행 안 됨
    2] 다른 파일에서 사용한 함수명과 같은 함수명을 사용할 때
*/

import java.util.Scanner;

public class BoardService4 {
    public static void main(String[] args) {
        // 객체 생성
        BoardController bc = new BoardController();

        // for문
        for( ; ; ){
            // 메뉴 보여주기
            System.out.println("\n======== My Community =======");
            System.out.println("1. 게시물 쓰기  | 2. 게시물 출력");
            System.out.println("==============================");

            Scanner scan = new Scanner(System.in);
            System.out.print("선택> ");
            int ch = scan.nextInt();

            if(ch==1){// 기능1 게시물 쓰기
                scan.nextLine();
                System.out.print("작성자: "); String writer = scan.nextLine();
                System.out.print("내용: "); String content = scan.nextLine();
                // ⭐호출 = 객체.메소드();
                boolean result = bc.doPost( content , writer );
                if(result==true){
                    System.out.println("[안내] 등록 성공");
                }else{
                    System.out.println("[경고] 등록 실패");
                }
            }else if(ch==2){// 기능2 게시물 출력
                Board[] boards = bc.doGet();
                for(int i = 0 ; i <= boards.length-1 ; i++){
                    if(boards[i]!=null){
                        System.out.println("작성자: "+boards[i].writer);
                        System.out.println("내용: "+boards[i].content);
                        System.out.println("-------------------------");
                    }
                }
            }

        } // for end


    }
}
