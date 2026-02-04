package day010;

public class Exam2 {
    public static void main(String[] args) {

        // 1. 인터페이스는 객체 생성 불가능. --> 생성자가 없기 때문이다.
            //new 키보드(); <- 안 됨. 인터페이스 타입은 생성자가 없다.
        // 2. 인터페이스 타입에 변수 선언함
        키보드 myKeyBoard;
            // myKeyBoard.aKey(); <- 안 됨. 추상메소드는 실행이 안 된다. 구현을 안 했기 때문.
        // 3. 추상메소드 구현하기 = 클래스에서 오버라이딩
        // 4. 구현(객)체 : 해당 인터페이스를 구현한 클래스로 객체를 생성한다.
        myKeyBoard = new 격투게임(); // <-- 키보드에 격투게임 연결
        myKeyBoard.aKey(); // [공격]
        myKeyBoard.aKey(); // [공격]
        myKeyBoard.bKey( 3 , 2 ); // [방어]
        System.out.println("============= 게임교체 =============");
        // 5. 다형성 - 게임 교체. 키보드에 게임 연결을 하나밖에 안 됨. 키보드 하나임.
        myKeyBoard = new 축구게임(); // <-- 키보드에 축구게임 연결
        myKeyBoard.aKey(); // [슈팅]
        myKeyBoard.aKey(); // [슈팅]
        myKeyBoard.bKey( 3 , 2 ); // [태클]

        // 6. 구현체 없이 자체적으로 구현 == 익명(이름없는) 구현체
        // `new 인터페이스명(){ 오버라이딩 };` <- 원래는 구현체가 없어서 안 되는데 자체적으로 {};오버라이딩해서 익명 구현체 만듦. 커스텀하기!
        myKeyBoard = new 키보드(){
            @Override public void aKey(){
                System.out.println("[이벤트] 커스텀 중..."); //아무거나쓴거임
            }

            @Override public int bKey( int x , int y ){
                System.out.println("[이벤트] 커스텀 완료!"); //아무거나쓴거임
                return x+y;
            }
        }; //세미클론 마무리.
        myKeyBoard.aKey();
        myKeyBoard.bKey( 1 ,2 );
            // 게임에서 이벤트 관리할 때 많이 사용한다. 움직임 등.

        // 인터페이스: 서로 다른 기능을 실행하게끔 해주는 것.
            // 서로 다른 객체가 통합해야하는 경우?? -> 설계 단계에서 찾기 힘듦. 포트폴리오에 인터페이스 상속 이런 거 넣으면 좋대
            // 실무에서는 상속보다는 구현이 더 많이 사용될 수 있대...

    } // main end
} // class end

class 격투게임 implements 키보드{
    // implements 이란? 해당 인터페이스 내 추상메소드 구현한다.
    @Override public void aKey(){System.out.println("[공격]");}
    @Override public int bKey( int x , int y ){
        System.out.println("[방어]");
        return x+y;
    }
}

class 축구게임 implements 키보드{
    // 구현체는 오버라이딩이 필수이다.
    @Override public void aKey(){System.out.println("[슈팅]");}
    @Override public int bKey( int x , int y ){
        System.out.println("[태클]");
        return x+y;
    }
}