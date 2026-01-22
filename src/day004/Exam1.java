package day004;

// 반복문

import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {

        // [1] 1부터 5까지 출력하시오
        System.out.println( 1 ); System.out.println( 2 ); System.out.println( 3 );
        System.out.println( 4 ); System.out.println( 5 );
        // vs. 초기값: 1 , 조건문: 5까지, 증감식: 1씩 증가
        for(int i = 0 ; i <= 5; i++){System.out.println(i);}

        // [2] 구구단 (2 ~ 9단)
        // 단: 초기값: 2 , 조건문: 9까지 , 증감식: 1씩 증가
        for(int 단 = 2 ; 단 <= 9 ; 단++){System.out.println(단);}
        // 곱: 초기값: 1 , 조건문: 9까지 , 증감식: 1씩 증가
        for(int 곱 = 1 ; 곱 <= 9 ; 곱++){System.out.println(곱);}
        // 곱마다 단 vs. 단마다 곱 ??
            // 구매목록[식별번호=pno] 출력하고-> 제품목록[pno/pname]하기
            // 제품목록[pno/pname] 출력하고-> 구매목록[식별번호=pno]하기
        for(int 단 = 2 ; 단<= 9 ; 단++){
            for(int 곱 = 1 ; 곱<=9; 곱++){
                System.out.printf("%d X %d = %d\n", 단 , 곱 , 단*곱);
            }
        }

        // [3] break: 가장 가까운 반복문/switch 탈출  ,  continue: 가장 가까운 반복문(증강식) 이동;
        for(int i = 1 ; i <= 5 ; i++){
            if(i == 3){break;}
            System.out.println( i );
        } // 1 2
        for(int i = 1 ; i <=5 ; i++){
            if(i==3){continue;}
            System.out.println(i);
        } // 1 2 4 5

        // [4] 무한루프: 조건문이 true 상수로 계속 되는 반복문    // 사용처: 옛날 전광판(요즘에는웹으로관리해서x)
        //for( ; ; ){System.out.println("무한루프");} // 무한루프 끄려면 빨간 네모 중지 버튼 누르면 된다.
        while(true){
            System.out.println("무한입력");
            Scanner scan = new Scanner(System.in);
            String data = scan.next();
            if( data.equals("q")){break;} // 무한루프 종료 방법: 입력받은 것이 q가 되면 종료.
        }


    }
}
