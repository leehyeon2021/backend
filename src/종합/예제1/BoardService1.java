package 종합.예제1;

import java.util.Scanner;

public class BoardService1 {
    // 자바는 무조건 클래스 단위로 작성한다.
    public static void main(String[] args) {
        // 자바는 무조건 main함수 부터 코드 실행흐름 시작된다.

        // [1] 메모리 설계: 데이터 6개 저장 -> 변수 6개 사용. (배열/객체 학습 전이라서.)
        String content1 = null;     // String 문자열 타입/클래스
        String writer1 = null;      // 초기값을 null 저장 (자료가 비어있음을 뜻한다.)
        String content2 = null;     String writer2 = null;
        String content3 = null;     String writer3 = null;

        // [2] 반복문 - 무한루프
        for( ; ; ){

            // [3] 출력문 print , 출력문 + 줄바꿈 println
            System.out.println("======= My community =======");
            System.out.println("1. 게시물 쓰기  2. 게시물 출력");
            System.out.println("============================");
            System.out.print("선택> ");

            // [4] 입력객체, Scanner 변수명 = new Scanner(System.in);
            Scanner scan = new Scanner(System.in);
            int ch = scan.nextInt();

            // [5] 제어문, 코드 흐름 제어( 논리적인 사고, 경우의 수 등 )
            if( ch == 1 ){ // 입력받은 값이 1: 게시물 쓰기
                scan.nextLine(); // .nextLine() 앞에 다른 next 존재하면 하나로 인식된다. 그래서 앞에 의미 없는 거 하나 붙여주기.
                System.out.print("내용: ");       String 내용 = scan.nextLine(); // 입력받기
                System.out.print("작성자: ");      String 작성자 = scan.nextLine();
                // 처리 (저장)
                if(content1 == null && writer1 == null){ // 첫 게시물이 비어있으면
                    content1 = 내용; writer1 = 작성자; // 변수를 수정
                    System.out.println("[안내] 글쓰기 성공"); // 출력
                }else if(content2 == null && writer2 == null){  // 다수 조건에 따른 하나의 결과(출력하나함)라서 else if
                    content2 = 내용; writer2 = 작성자;
                    System.out.println("[안내] 글쓰기 성공"); // 출력
                }else if(content3 == null && writer3 == null) {
                    content3 = 내용; writer3 = 작성자;
                    System.out.println("[안내] 글쓰기 성공"); // 출력
                }else{
                    System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                }
            } // if end
            else if( ch == 2 ){ // 입력받은 값이 2: 게시물 출력
                if(content1 != null && writer1 != null) { // 만약에 첫 번째 게시물이 비어있지 않으면 출력
                    System.out.printf("작성자: %s , 내용: %s \n", content1 , writer1);
                }
                if(content2 != null && writer2 != null) {   // 다수 조건에 따른 다수 출력이라 if
                    System.out.printf("작성자: %s , 내용: %s \n", content2 , writer2);
                }
                if(content3 != null && writer3 != null) {
                    System.out.printf("작성자: %s , 내용: %s \n", content3 , writer3);
                }
            } // else if end

        } // for end


    } // main end
} // class end
