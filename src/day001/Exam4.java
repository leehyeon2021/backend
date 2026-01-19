package day001;

import java.util.Scanner;

public class Exam4 { // class s
    public static void main(String[] args) { // main s

        // [1] 입력 객체
        // 대문자S 스캐너Scanner 클래스: 입력받은 자료들을 **특정한 타입**으로 변환
        // new: 새로운 객체 생성할 때 사용되는 키워드
            // new Scanner: Scanner 객체를 만들겠다.
        // (System.in): ()소괄호는 생성자. 시스템 입력 객체를 Scanner 객체에게 전달한다.
        // * 시스템 입력 객체를 Scanner 객체에 대입하여 Scanner 객체 생성.
        // * Scanner 변수명 = new Scanner( System.in ); 형태 고정?
        Scanner 입력변수 = new Scanner( System.in ); //그냥 시스템인 사용보단 스캐너 해서 타입변환하는 게 편할 거라는 데 뭔소린지모르겟어!!

        // [2] 입력함수
        // 1. 변수명.next(); : 입력받은 자료들을 문자열(String)로 반환. 띄어쓰기 불가능.
        System.out.print("1. next(): "); // 입력 전 가이드
        String str1 = 입력변수.next(); // console에서 키보드로부터 입력받고 enter 입력시 입력종료.
        System.out.println( str1 ); // 입력받은 자료 출력
        // 2. 변수명.nextLine(); : 입력받은 자료를 문자열(String)로 반환. 띄어쓰기 포함.
            // 주의할 점: 띄어쓰기를 포함하다보니 앞전에 next()와 충돌하여 하나의 next로 인식된다.
            // 해결방법: nextLine() 사용할 때 앞전에 next()가 존재하면 임의의 nextLine()을 하나 더 작성한다.
        입력변수.nextLine(); // !! 의미 없는 임의의 nextLine(). 앞전의(20행) next()와 같은 next로 인식됨.
        System.out.print("2. nextLine(): ");
        String str2 = 입력변수.nextLine();
        System.out.println( str2 );
        // 3. 변수명.nextByte(); : 입력받은 자료를 바이트로 반환, -128~+127 이외 자료이면 오류 발생.
        System.out.print("3. nextByte(): ");
        byte b1 = 입력변수.nextByte();
        System.out.println( b1 );
        // 4. 변수명.nextShort(); : 입력받은 자료를 쇼트로 반환. +-3만 정도 이외의 자료이면 오류 발생.
        System.out.print("4. nextShort()");
        short s1 = 입력변수.nextShort();
        System.out.println( s1 );
        // 5. 변수명.nextInt(); : 입력받은 자료를 인트로 반환. +-21억 정도 이외의 자료이면 오류 발생.
        System.out.print("5. nextInt(): ");
        int i1 = 입력변수.nextInt();
        System.out.println( i1 );
        // 6. 변수명.nextLong(); : 입력받은 자료를 롱으로 반환. +-21억 이상.
        System.out.print("6. nextLong(): ");
        long l1 = 입력변수.nextLong();
        System.out.println( l1 );
        // 7. 변수명.nextFloat(); :  입력받은 자료를 실수로 반환
        System.out.print("7. nextFloat(): ");
        float f1 = 입력변수.nextFloat();
        System.out.println( f1 );
        // 8. 변수명.nextDouble(); : 입력받은 자료를 실수로 반환
        System.out.print("8. nextDouble(): ");
        double d1 = 입력변수.nextDouble();
        System.out.println( d1 );
        // 9. 변수명.nextBoolean(); : 입력받은 자료를 불리언으로 반환.
        System.out.println("9. nextBoolean(): ");
        boolean b2 = 입력변수.nextBoolean();
        System.out.println( b2 );
        // 10. 변수명.next().charAt(0); : 입력받은 자료에서 첫 번째 글자 반환. char 문자 스캔은 없다.
        System.out.print("10. next().charAt(0): ");
        char c1 = 입력변수.next().charAt(0);
        System.out.println( c1 );


    } // main e
} // class e
