package day006;

public class Calculator {
    /* 클래스 안에 들어가는 거
    1) 속성 = 멤버변수
    2) 기능 = 메소드 = 멤버함수
           (1) 매개변수 X , 반환값 O */
    double getPi(){
    // double은 반환타입: return 값에 타입
    // getPi 메소드명: 아무거나하기(카멜표기법권장)
    // (): 매개변수 없는 상태
    // {}: 함수 실행시 처리할 명령어/코드
        return 3.14159; // double 타입
        // return: 함수 반환값
    }

        // (2) 매개변수 X , 반환값 X
    void powerOn(){
        System.out.println("전원을 켭니다.");
        return; // 생략 가능
    }
        // (3) 매개변수 O , 반환값 X = void
    void printSum( int x , int y){
        //soutp -> System.out.println("x = " + x + ", y = " + y);
        System.out.println( x + y );
    }

        // (4) 매개변수 O , 반환값 O
    int add( int x , int y ){
        System.out.println("더하기 합니다.");
        return x + y; // int + int = int
    }

    // +) 동일한 클래스 내 메소드 호출
    void print(){
        printSum(10, 2);    // 이렇게 바로 호출하면 된다.
    }

    // 객체가 필요한 이유
    void 밥먹기(){};

}
