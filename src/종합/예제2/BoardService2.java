package 종합.예제2;

import java.util.Scanner;

public class BoardService2 {
    public static void main(String[] args) {
        // [1] 메모리 설계: 데이터 최대 100개 저장
            // 1) 2개 정보를 가진 게시물이 3개이면 변수는 총 6개 갖는다.
            // 2) 2개 정보를 가진 게시물이 100개이면 변수는 총 200개 갖는다. --> 관리가 어렵기에 배열을 사용한다.
        String[] contents = new String[100];    // 제목 100개 , 각 요소는 객체타입이므로 null 값을 갖는다.
        String[] writers = new String[100];     // 작성자 100개 , { null , null , null ~~ }

        // [2] 반복문 - 무한루프
        for( ; ; ){
            // 메뉴 보여주기
            System.out.println("======= My community =======");
            System.out.println("1. 게시물 쓰기  2. 게시물 출력");
            System.out.println("============================");
            System.out.print("선택> ");
            // 입력 받기
            Scanner scan = new Scanner(System.in);
            int input = scan.nextInt();
            if(input == 1){     // 제어문/코드의 흐름(경우의 수) 판단한다.
                scan.nextLine();
                System.out.print("내용: "); String content = scan.nextLine(); // 입력 받고
                System.out.print("작성자: "); String writer = scan.nextLine();
                boolean save = false; // 저장했다 true , 저장못했다 false;
                for(int index = 0; index < contents.length; index++) {
                    if (contents[index] == null && writers[index] == null) {  // index번째 요소값이 비어있으면
                        contents[index] = content; writers[index] = writer; // 입력받은 값들을 index번째에 대입한다.
                        save = true;
                        break;
                    }
                }
                if (save == true) { System.out.println("[안내] 글쓰기 성공"); }
                else { System.out.println("[경고] 게시물을 등록할 공간이 부족합니다."); }

            } else if (input ==2) {
                    for( int i = 0; i < contents.length; i++){
                        if(contents[i] != null && writers[i] != null) {
                            System.out.printf("작성자: %s, 내용: %s \n" , contents[i], writers[i]);
                        }
                    }
                }

        }

    } // main end
}
