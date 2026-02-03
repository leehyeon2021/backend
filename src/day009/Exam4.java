package day009;

public class Exam4 {
    public static void main(String[] args) {
        // 1. Car 객체 생성
        Car myCar = new Car(); // tire가 null
        myCar.tire = new Tire(); // tire가 null이 아님
        myCar.run(); // [일반] 타이어가 회전

        // 2-1. 타이어 교체
        myCar.tire = new HankookTire(); // 멤버변수에 Htire 객체 대입.
        myCar.run(); // [한국] 타이어가 회전(업그레이드)

        // 2-2. 타이어 교체
        myCar.tire = new KumhoTire();
        myCar.run(); // [금호] 타이어가 회전(업그레이드)
            // !! Tire 타입의 멤버변수는 Tire객체, Htire객체, Ktire객체를 모두 대입 받을 수 있다. (부모 멤버변수니까?)
                // -> 상속 관계라서. 자동타입변환됨. 자식 타입은 부모 타입으로 자동 변환!
        System.out.println( myCar.tire instanceof Tire ); // true
        System.out.println( myCar.tire instanceof KumhoTire ); // true
        System.out.println( myCar.tire instanceof HankookTire ); // false
                // -> KumhoTire 객체가 생성될 때 KumhoTire , Tire 총 2 개 생성.
                // 하위 타입의 객체를 생성하면 상위 타입의 객체도 같이 생성된다.
                // 즉: KumhoTire 객체가 생성될 때 HankookTire 객체는 생성되지 않는다. (형제 관계라서.)
    }
}

class Car{
    Tire tire;
    void run(){
        this.tire.roll();
    };
}

class Tire{
    void roll(){
        System.out.println("[일반] 타이어가 회전");
    }
}

class HankookTire extends Tire{
    void roll(){
        System.out.println("[한국] 타이어가 회전(업그레이드)");
    }
}

class KumhoTire extends Tire{
    void roll(){
        System.out.println("[금호] 타이어가 회전(업그레이드)");
    }
}
