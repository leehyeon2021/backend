package day009;

// 상속3

public class Exam3 {
    public static void main(String[] args) {

        // 1. 상위 객체
        상위클래스 obj1 = new 상위클래스();
        obj1.show();
        //obj1.show2(); // 자식의 멤버변수/메소드 사용 불가.

        // 2. 하위 객체
        하위클래스 obj2 = new 하위클래스();
        obj2.show(); // 부모 메소드 대신 오버라이딩 된 것이 실행된다. (오버라이딩이 최우선으로 실행된다!)
        obj2.show2(); // 본인 거 본인이 실행하니까 가능.

        // 3. 타입 변환 : 자식 -> 부모 타입 변환.
        상위클래스 obj3 = obj2;
        obj3.show(); // 😧 상위클래스의 show()가 아니라 오버라이딩이 우선으로 사용되어 하위클래스의 show가 사용된다. (신기하구만)
                     // 부모와 자식 간의 메소드가 동일하면 오버라이딩 우선.

        // 4. 부모와 자식 간 멤버변수 간에서 공유 가능. (누가물어보면-> 왜? 자식이 태어날 때 부모도 태어나고 부모의 멤버변수도 생성된 공유 가능.)
        System.out.println( obj2.value1 );
        System.out.println( obj2.value3 );

    }//main end
}//class end

class 상위클래스{ // 슈퍼클래스
    // 멤버변수
    int value1 = 10;
    int value2 = 20;
    // 생성자
    상위클래스(){System.out.println("상위클래스 생성");}
    // 메소드 - 하위클래스가 못 쓰게 하고 싶다면 private이나 final 사용하면 된다.
    void show(){System.out.println("상위클래스 메소드 실행");}
}

class 하위클래스 extends 상위클래스{
    // 상위클래스의 모든 것 다 사용 가능.
    // 멤버변수
    int value3 = 30;
    int value4 = 40;
    // 생성자
    하위클래스(){System.out.println("하위클래스 생성");}
    // 메소드
    @Override    //<- 오버로딩: 생략 가능. 부모로 부터 물려 받은 메소드를 재정의한다.
    void show(){ // 상위클래스 메소드 선언부가 일치하면 '오버라이딩' (선언부가 똑같을 때 재정의)
        // 오버라이딩 하면 최우선으로 메소드가 실행된다.
        System.out.println("하위클래스 메소드 실행(재정의)");
    }
    // 오버라이딩 vs. 오버로딩
    void show( int a ){} // 오버로딩: 똑같은 이름에 매개변수를 다르게 만드는 것.

    void show2(){
        System.out.println("하위클래스 메소드 실행2");
        System.out.println( this.value3 ); // 30. this: 현재 객체라는 뜻
        System.out.println( super.value1 ); // 10.  super: 상위 객체(에게 물려받은 거)라는 뜻
        // 부모와 자식 간의 멤버변수명이 동일할 때는 this, super를 사용해서 구분 한다.
    }

    // <- 파란 동그라미 아이콘. 화살표 보면 상위/하위 알 수 있나봄
}