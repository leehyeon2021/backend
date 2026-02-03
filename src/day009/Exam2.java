package day009;

// 상속2
    // 코딩 주소 바로가기 : ctrl + 클릭

public class Exam2 {
    public static void main(String[] args) {

        // 1. 자바의 모든 클래스는 Object 클래스로부터 상속 받는다.
        System.out.println("==== [1] ===="); // 그냥 구분 용도
        A a = new A(); // -> 총 객체: 2개. A 하나 + Object 하나.
                       // A + Object(슈퍼클래스)(자바는 Object라는 최상위 클래스에서 자동으로 상속받음.)

        // 2. 자바의 모든 상속관계에서는 객체 생성시 부모 객체 먼저 생성한다.
        System.out.println("==== [2] ====");
        B b = new B(); // -> 총 객체: 3개. B <- A <- Object

        // 3. 타입 변환시 업/다운 캐스팅만 가능하다.
        System.out.println("==== [3] ====");
        C c = new C(); // -> 총 객체: 3개. C <- A <- Object. (B 없음. -> 형제들까리 타입변환 안 되는 이유: 메모리적으로도 차이가 있기 때문!!)

        // 4. 자식 객체가 생성되면 부모 객체도 같이 생성된다.
        System.out.println("==== [4] ====");
        D d = new D(); // -> 총 객체: 4개. D <- B <- A <- Object
        E e = new E(); // -> 총 객체: 4개. E <- C <- A <- Object

        // 즉: 자바는 상속(물려주는)관계를 메모리(저장소)로 표현한다.

        // 5. 자동 타입 변환
        A a2 = b;
        Object o2 = a2; // b -> a -> Object. Object가 최상위이기 때문에 모든 객체는 Object에 들어갈 수 있음.
        //B b2 = c; // c객체가 생성될 때 b는 생성되지 않는다.

        // 6. 강제 타입 변환
        B b2 = (B)a2; // a2의 태생은 b객체이므로 가능하다.
        //C c2 = (C)a2; // 오류 발생. a2의 태생은 c객체이므로 b가 태어날 때 c는 생성되지 않았다.

        // 7. 타입 확인 , 객체 instanceof 클래스명(==타입명)
        System.out.println(a instanceof Object); // true
            // 1. 객체가 생성될 때 생성물 Object가 생성되었는지 확인.
        //System.out.println(a instanceof C); // false
            // 2. 객체가 생성될 때 C가 생성되었는지 확인
        System.out.println(a instanceof A); // true
        System.out.println(b instanceof D); // false

        // 즉: 해당 객체가 생성될 때 부모객체는 생성되지만 자식객체는 생성 안 된다.
        // 업캐스팅은 되지만 자식들 밑으로는 **다운 캐스팅이 안 된느 전제조건**

    }//main end
}//class end

class A{
    A(){System.out.println("A 객체 생성");}
}

class B extends A{
    B(){System.out.println("B 객체 생성");}
}

class C extends A{
    C(){System.out.println("C 객체 생성");}
}

class D extends B{
    D(){System.out.println("D 객체 생성");}
}
class E extends C{
    E(){System.out.println("E 객체 생성");}
}