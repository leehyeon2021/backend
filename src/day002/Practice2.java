package day002;

import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        /*[실습] * 제출용 */
        /*문제 1: a 와 b 두 변수의 합을 long 타입의 변수에 저장하여 그 결과를 출력하시오.
        선언 코드 :
        byte a = 10;
        int b = 200;
        출력 예시:
        결과: 210 */
        byte a = 10;
        int b = 200;
        long sum = a+b;     // byte + int = int -> (자동 타입 변환) -> int가 long으로 자동타입변환.
        System.out.println(sum);

        /*문제 2: 실수 3.141592를 double 타입 변수에 저장한 뒤, 이 변수를 int 타입으로 강제 변환하여 정수 부분만 출력하시오.
        선언 코드 :
        double z = 3.141592;
        출력 예시:
        원본 double 값: 3.141592
        변환된 int 값: 3 */
        double z = 3.141592;
        int z1 = (int)z;
        System.out.println( z1 ); // 소수점 다 잘림

        /*문제 3: Scanner를 이용해 사용자의 키를 double 타입(예: 178.5)으로 입력받은 후, 이 값을 int 타입으로 강제 변환하여 "당신의 키는 약 OOOcm 이군요." 라고 정수 부분만 출력하시오.
        입력 예시:
        키를 입력하세요: 178.5
        출력 예시:
        당신의 키는 약 178cm 이군요. */
        Scanner scan = new Scanner(System.in);  // 입력 객체
        System.out.print("키를 입력하세요: "); double 키 = scan.nextDouble(); // (int)scan.nextDouble() 해도 된다.
        System.out.println("당신의 키는 약: " + (int)키 + "cm 입니다.");   // 출력할 때 타입변환해도 된다.

        /*문제 4: Scanner를 이용해 서로 다른 3개의 정수를 입력받아, 이 값들의 합을 3으로 나눈 평균을 구하시오.
        단, 결과는 소수점이 포함되도록 출력되어야 한다.
        입력 예시:
        첫 번째 정수 입력: 11
        두 번째 정수 입력: 21
        세 번째 정수 입력: 21
        출력 예시:
        평균 결과: 17.666666666666668 */
        System.out.print("정수1: ");      int 정수1 = scan.nextInt();
        System.out.print("정수2: ");      int 정수2 = scan.nextInt();
        System.out.print("정수3: ");      int 정수3 = scan.nextInt();
        double 평균 = ( 정수1 + 정수2 + 정수3 ) / 3.0 ; // int 로 하면 소수점이 날아간다!!
        // int + int + int / int = int로 나옴.  ,   int + int + int / double = double 나옴.  => 가장 큰 수를 따라가기 때문??.
            // 그래서 /3 이 아니라 /3.0 을 해야 한다.
        System.out.println("평균 = " + 평균);  // soutv: 가장 가까운 변수 출력 자동완성. v는 value.

    }
}
