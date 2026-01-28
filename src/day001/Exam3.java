package day001; // 패키지(폴더)

/* 출력과 입력 */

public class Exam3 { // class s

    // m + enter: 코드의 흐름을 읽어주는 main함수 선언. 자체실행되는 언어는 main함수를 가진다. (실행해주는 애)
    public static void main(String[] args) { // main start

        // [1] sout: System.out.printIn(); 자동완성됨. 줄바꿈 포함.
        // System: 클래스이면서 시스템(현재컴퓨터) 관련 기능(함수)를 제공한다.
        // out: 출력에 관련된 기능(함수)를 갖는 객체를 반환한다.
        // print: 출력함수. print 사용하려고 out이랑 System이랑 호출한 것.
        System.out.println("자바안녕1"); // console.log() 같은 것.

        // [2] System.out.print();: 자료 출력
        System.out.print("자바안녕2"); // 줄바꿈 없음

        // [3] System.out.printf(): 자료 출력 + 형식문자
        System.out.printf("%s", "자바안녕3"); // f는 포맷.

        /*
        [3] printf(format 형식)
        - %s: 문자열 , %d: 정수 , %c: 문자 , %f: 실수
            - % 뒤로 적용

        1. %자릿수d: 자릿수만큼 자리 차지. 만일 비어있으면 공백, 오른쪽 정렬.
        2. %-자릿수d: 자릿수만큼 자리 차지. 만일 비어있으면 공백, 왼쪽 정렬.
        3. %0자릿수d: 자릿수만큼 자리 차지. 만일 비어있으면 0으로 채운다.
        4. 전체자릿수.소수점자릿수f : 소수점 두 번째 자리에서 자름.

        (활용처가 적어서 외우지 말라고 하심)
        */
        // 자바에서는 백틱`, ${ } 불가능하다.
        String name = "유재석"; int age = 10;
            // 문자열과 변수 연결 할 때 +더하기(연결)연산자 연결한다.
        System.out.println("저는 " + name + "이고 나이는: " + age + "입니다.");

        // 위는 불편하니, 아래처럼 변수 도는 수식이 들어가는 자리에 형식문자로 대체한다.
        System.out.printf("저는 %s 이고 나이는 %d 입니다.\n", name, age);
        // 1. %자릿수d: 자릿수만큼 자리 차지. 만일 비어있으면 공백, 오른쪽 정렬.
        System.out.printf("저는 %s 이고 나이는 %6d 입니다.\n", name, age);
        // 2. %-자릿수d: 자릿수만큼 자리 차지. 만일 비어있으면 공백, 왼쪽 정렬.
        System.out.printf("저는 %s 이고 나이는 %-6d 입니다.\n", name, age);
        // 3. %0자릿수d: 자릿수만큼 자리 차지. 만일 비어있으면 0으로 채운다.
        System.out.printf("저는 %s 이고 나이는 %06d 입니다.\n", name, age);
        // 4. 전체자릿수.소수점자릿수f : 소수점 두 번째 자리에서 자름.
        System.out.printf("저는 %s 이고 키는 %5.2f 입니다.\n", name, 177.2345);

        // [5] 이스케이프/제어 문자
        // "\n": 줄바꿈처리
        System.out.println("안녕1\n안녕2");
        // "\n": 줄바꿈처리
        System.out.println("안녕1\t안녕2");
        // "\n": 줄바꿈처리
        System.out.println("안녕1\"안녕2");
        // "\n": 줄바꿈처리
        System.out.println("안녕1\'안녕2");
        // "\n": 줄바꿈처리
        System.out.println("안녕1\\안녕2");


    } // main end

} // class end
