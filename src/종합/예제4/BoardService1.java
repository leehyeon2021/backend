//package 종합.예제4;
//import java.util.Scanner;
//// 입출력
//public class BoardService1 {
//    public static void main(String[] args) {
//
//        BoardController bc = new BoardController();
//
//        // 무한루프
//        for( ; ; ){
//            System.out.println("======== My Community ========");
//            System.out.println("1. 게시물쓰기  |  2. 게시물 출력");
//            System.out.println("===============================");
//            System.out.print("선택> ");
//            Scanner scan = new Scanner(System.in);
//            int ch = scan.nextInt();
//            if(ch == 1) {
//                System.out.print("내용: ");
//                String content = scan.nextLine();
//                System.out.print("작성자: ");
//                String writer = scan.nextLine();
//                boolean result = bc.doPost(content, writer);
//                if (result == true) {
//                    System.out.println("[안내] 저장 성공");
//                } else {
//                    System.out.println("[경고] 등록 실패");
//                }
//            }//if end
//            else if(ch==2){
//                Board1[] boards1 = bc.doGet1();
//                for( int i = 0 ; i<=boards1.length-1; i++){
//                    if(boards1[i]!=null){
//                        System.out.println("작성자: " + boards1[i].writer);
//                        System.out.println("내용: " + boards1[i].content);
//                        System.out.println("-------------------------");
//                    }
//                }
//
//            }
//        }// for end
//
//
//
//    }
//}
