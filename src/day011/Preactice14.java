package day011;

public class Preactice14 {

    public static void main(String[] args) {
        // 1. ArithmeticException
        try{
            int result = 10 / 0;
        }catch (ArithmeticException a){
            System.out.println("0으로 나눌 수 없습니다.");
        }
        // 2. NumberFormatException
        try{
            String notANumber = "오류";
            int value = Integer.parseInt(notANumber);
        }catch (NumberFormatException e){
            System.out.println("잘못된 숫자 형식입니다.");
        }
        // 3. ArrayIndexOutOfBoundsException
        try{
            String[] fruits = {"사과", "바나나"};
            System.out.println(fruits[2]);
        }catch (ArrayIndexOutOfBoundsException a){
            System.out.println("잘못된 인덱스에 접근했습니다.");
        }
        // 4. NullPointerException
        try{
            String text = null;
            System.out.println("글자 수: "+text.toUpperCase());
        }catch (NullPointerException a){
            System.out.println("객체가 초기화되지 않았습니다.");
        }
        // 5. finally
        try{
            System.out.println("데이터베이스 연결을 시작합니다.");
        }finally {
            System.out.println("데이터베이스 연결을 종료합니다.");
        }
        // 6. 다중 catch
        try{
            String text = null;
            text.length();
            int result = 5/0;
        }catch (NullPointerException e){
            System.out.println("예외1: " + e);
        }catch (ArithmeticException e1){
            System.out.println("예외2: " + e1);
        }
        // 7.
        try {
            pauseOneSecond();
        }catch (InterruptedException e){
            System.out.println("1초간 프로그램 일시정지 못 함");
        }
        // 8. Exception
        try{
            int[] arr = new int[2];
            System.out.println(arr[5]);
        }catch (Exception e){
            System.out.println("알 수 없는 오류가 발생했습니다.");
        }

    }// main end

    // 7. throws
    static void pauseOneSecond() throws InterruptedException{
        Thread.sleep(1000); // 스레드(작동).슬립(쿨쿨) == 멈춤😴
    }

}// class end



/*[실습] 제출용 */
/*[문제 1] ArithmeticException 처리
1. 두 정수를 나누는 코드를 작성하세요.
2. try-catch 문을 사용하여, 0으로 나눌 때 발생하는 ArithmeticException을 잡으세요.
3. catch 블록에서는 "0으로 나눌 수 없습니다." 라는 메시지를 출력하세요.
필요 코드:int result = 10 / 0; */

/*[문제 2] NumberFormatException 처리
1. try-catch 문을 사용하여, 아래 코드 실행 시 발생하는 NumberFormatException을 처리하세요.
2. catch 블록에서는 "잘못된 숫자 형식입니다." 라는 메시지를 출력하세요.
필요 코드:
String notANumber = "오류";
int value = Integer.parseInt(notANumber); */

/*[문제 3] ArrayIndexOutOfBoundsException 처리
1. try-catch 문을 사용하여, 아래 코드 실행 시 발생하는 ArrayIndexOutOfBoundsException을 처리하세요.
2. catch 블록에서는 "잘못된 인덱스에 접근했습니다." 라는 메시지를 출력하세요.
필요 코드:
String[] fruits = {"사과", "바나나"};
System.out.println(fruits[2]); */

/*[문제 4] NullPointerException 처리
1. try-catch 문을 사용하여, 아래 코드 실행 시 발생하는 NullPointerException을 처리하세요.
2. catch 블록에서는 "객체가 초기화되지 않았습니다." 라는 메시지를 출력하세요.
필요 코드:
String text = null;
System.out.println("글자 수: " + text.toUpperCase()); */


/*[문제 5] finally 블록으로 리소스 정리하기
1. "데이터베이스 연결을 시작합니다."를 출력하는 코드를 try 블록에 작성하세요.
2. finally 블록을 사용하여, 예외 발생 여부와 상관없이 항상 "데이터베이스 연결을 종료합니다."가 출력되도록 만드세요. */


/*[문제 6] 다중 catch 블록
1. 하나의 try 블록 안에서 NullPointerException 또는 ArithmeticException이 발생할 수 있도록 코드를 작성하세요.
2. catch 블록을 두 개 사용하여, 각 예외를 개별적으로 처리하고 어떤 예외가 발생했는지 메시지를 출력하세요.
필요 코드
String text = null;
text.length();
int result = 5 / 0; */

/*[문제 7] throws로 예외 떠넘기기
Thread.sleep(1000); 코드를 포함하는 static void pauseOneSecond() 메소드를 만드세요.
이 메소드는 try-catch 대신 throws InterruptedException를 사용하여 예외를 떠넘기도록 선언하세요.
main 함수에서 pauseOneSecond() 메소드를 호출하고, try-catch를 사용하여 떠넘겨진 예외를 처리하세요.
필요 코드
Thread.sleep(1000); // 1초간 프로그램 일시정지
*/


/*[문제 8] Exception 클래스로 모든 예외 처리
1. try 블록 안에 ArrayIndexOutOfBoundsException을 유발하는 코드를 작성하세요.
2. catch 블록을 단 하나만 사용하여, 모든 예외의 부모 클래스인 Exception 타입으로 예외를 처리하세요.
3. catch 블록에서는 "알 수 없는 오류가 발생했습니다." 라고 출력하세요.
필요코드
int[] arr = new int[2];
System.out.println(arr[5]); */