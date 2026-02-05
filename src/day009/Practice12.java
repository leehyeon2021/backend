package day009;

public class Practice12 {
    public static void main(String[] args) {

        // [1] 기본 상속
        Student student = new Student();
        student.name = "학생이름1";
        student.studentID = 1;
        System.out.println("student.name + student.studentID = " + student.name + student.studentID);

        // [2] 메소드 오버라이딩
        Cat cat = new Cat();
        cat.makeSound();

        // [3] 생성자 호출 순서
        Computer computer = new Computer();
            // 1) 부모 클래스 생성자 실행 , 2) 자식 클래스 생성자 실행
            // 교수님: 자식이 태어날 때 부모도 태어난다

        // [4] 다형성: 자동 타입 반환
        Figure figure = new Triangle();
            // 하위 클래스 객체 생성 시 상위 클래스도 생성된다.
            // 교수님: Triangle 클래스는 figure로 부터 상속 받았기 때문이다.

        // [5] 다형성과 오버라이딩
        Shape shape = new Circle();
        shape.draw(); // 원을 그립니다.
            // 오버라이딩

        // [6] instanceof 강제타입변환
        Vehicle vehicle = new Bus();
        if( vehicle instanceof  Bus){
            System.out.println("(bus 타입이 맞습니다.)");
            ((Bus) vehicle).checkFare();
        }else{System.out.println("bus 타입이 아닙니다.");}

        // [7] 다형성을 활용한 객체
        Beverage[] beverage = {new Coke(), new Coffee()};
        for(int i = 0 ; i<beverage.length ; i++ ){
            beverage[i].drink();
        } // 콜라를 마십니다 -> 커피를 마십니다.

        // [8] 다형성을 활용한 매개변수
        Sword sword = new Sword();
        Gun gun = new Gun();
        Character character = new Character();
        character.use( sword ); // 검으로 공격합니다.
        character.use( gun );   // 총으로 공격합니다.

        // [9] 필드와 메소드의 오버라이딩 차이
        SuperClass obj = new SubClass();
        System.out.println(obj.name);   // SuperClass 타입의 name 불러옴 (멤버변수!!)
        obj.method();                   // 오버라이딩 된 SubClass의 method() 실행됨

        // [10] 다중 상속 관계
        Laptop laptop = new Laptop();
        System.out.println( laptop instanceof Electronic); // 들어있음
        System.out.println( laptop instanceof Device);     // 들어있음

    }// main end
}// class end

/*[실습] 제출용 /

/*[문제 1] 기본 상속
1. name(문자열) 멤버 변수를 가진 Person 클래스를 만드세요.
2. Person 클래스를 상속받는 Student 클래스를 만드세요. Student 클래스에는 studentId(정수) 멤버 변수를 추가하세요.
3. main 함수에서 Student 객체를 생성하고, 상속받은 name과 자신의 studentId에 값을 저장한 뒤 모두 출력하세요.*/
class Person{
    String name;
}
class Student extends Person{
    int studentID;
}

/*[문제 2] 메소드 오버라이딩 (Method Overriding)
1. "동물이 소리를 냅니다."를 출력하는 makeSound() 메소드를 가진 Animal 클래스를 만드세요.
2. Animal을 상속받고, makeSound() 메소드를 재정의하여 "고양이가 야옹하고 웁니다."를 출력하는 Cat 클래스를 만드세요.
3. main 함수에서 Cat 객체를 생성하고 makeSound() 메소드를 호출하여, 재정의된 내용이 출력되는지 확인하세요.*/
class Animal{
    void makeSound(){
        System.out.println("동물이 소리를 냅니다.");
    }
}
class Cat extends Animal{
    void makeSound(){
        System.out.println("고양이가 야옹하고 웁니다.");
    }
}

/*[문제 3] 생성자 호출 순서
1. 생성자에서 "부모 클래스 생성자 실행"을 출력하는 Machine 클래스를 만드세요.
2. Machine을 상속받고, 생성자에서 "자식 클래스 생성자 실행"을 출력하는 Computer 클래스를 만드세요.
3. main 함수에서 Computer 객체를 생성할 때, 콘솔에 출력되는 생성자 호출 순서를 확인하세요.*/
class Machine{
    public Machine() {
        System.out.println("부모 클래스 생성자 실행");
    }
}
class Computer extends Machine{
    Computer(){
        System.out.println("자식 클래스 생성자 실행");
    }
}

/*[문제 4] 다형성: 자동 타입 변환 (Upcasting)
1. Figure 클래스를 만드세요.
2. Figure를 상속받는 Triangle 클래스를 만드세요.
3. main 함수에서 Triangle 객체를 생성하여 Figure 타입의 변수에 저장하는 코드를 작성하고, 이것이 가능한 이유를 주석으로 설명하세요.*/
class Figure{}
class Triangle extends Figure{}

/*[문제 5] 다형성과 오버라이딩
1."도형을 그립니다."를 출력하는 draw() 메소드를 가진 Shape 클래스를 만드세요.
2.Shape을 상속받고, draw() 메소드를 재정의하여 "원을 그립니다."를 출력하는 Circle 클래스를 만드세요.
3.main 함수에서 Shape shape = new Circle(); 코드를 작성한 뒤, shape.draw()를 호출했을 때 어떤 결과가 나오는지 확인하고 그 이유를 주석으로 설명하세요.*/
class Shape{
    void draw(){
        System.out.println("도형을 그립니다.");
    }
}
class Circle extends Shape{
    void draw() {
        System.out.println("원을 그립니다.");
    }
}

/*[문제 6] instanceof와 강제 타입 변환 (Downcasting)
1. Vehicle 클래스와 이를 상속받는 Bus 클래스를 만드세요. Bus 클래스에만 checkFare() 메소드("요금을 확인합니다.")를 추가하세요.
2. main 함수에서 Vehicle vehicle = new Bus(); 코드를 작성하세요.
3. if문과 instanceof 연산자를 사용하여 vehicle 변수가 Bus 타입인지 확인하세요.
4. 만약 Bus 타입이 맞다면, Bus 타입으로 강제 변환한 뒤 checkFare() 메소드를 호출하세요.*/
class Vehicle{}
class Bus extends Vehicle{
    void checkFare(){
        System.out.println("요금을 확인합니다.");
    }
}

/*[문제 7] 다형성을 활용한 객체 배열
1. "음료를 마십니다."를 출력하는 drink() 메소드를 가진 Beverage 클래스를 만드세요.
2. Beverage를 상속받는 Coke와 Coffee 클래스를 만들고, 각 클래스에서 drink() 메소드를 오버라이딩하여 "콜라를 마십니다.", "커피를 마십니다."를 출력하도록 하세요.
3. main 함수에서 Beverage 타입의 배열을 생성하고, 그 안에 Coke 객체와 Coffee 객체를 저장하세요.
4. 반복문을 사용하여 배열의 모든 요소를 꺼내 drink() 메소드를 호출하고, 각기 다른 결과가 출력되는 것을 확인하세요.*/
class Beverage{
    void drink(){
        System.out.println("음료를 마십니다.");
    }
}
class Coke extends Beverage{
    void drink(){
        System.out.println("콜라를 마십니다.");
    }
}
class Coffee extends Beverage{
    void drink(){
        System.out.println("커피를 마십니다.");
    }
}

/*[문제 8] 다형성을 활용한 매개변수
1. Weapon 클래스와 이를 상속받는 Sword, Gun 클래스를 만드세요. 각 클래스는 "무기로 공격합니다.", "검으로 공격합니다.", "총으로 공격합니다."를 출력하는 attack() 메소드를 가집니다. (오버라이딩 활용)
2. Weapon 타입의 매개변수를 받아 그 객체의 attack() 메소드를 호출하는 Character 클래스와 use(Weapon weapon) 메소드를 만드세요.
3. main 함수에서 Sword 객체와 Gun 객체를 생성한 뒤, 이 객체들을 Character의 use() 메소드에 인자로 전달하여 각기 다른 결과가 출력되는 것을 확인하세요.*/
class Weapon{
    void attack(){
        System.out.println("무기로 공격합니다.");
    }
}
class Sword extends Weapon{
    void attack(){
        System.out.println("검으로 공격합니다.");
    }
}
class Gun extends Weapon{
    void attack(){
        System.out.println("총으로 공격합니다.");
    }
}
class Character{
    Weapon weapon = new Weapon();
    public Weapon use ( Weapon weapon ){
        weapon.attack(); return weapon;
    }
}

/*[문제 9] 필드와 메소드의 오버라이딩 차이
1. String name = "상위"; 필드와 method() 메소드("상위 메소드" 출력)를 가진 SuperClass를 만드세요.
2. SuperClass를 상속받고, String name = "하위"; 필드와 method() 메소드("하위 메소드" 출력)를 가진 SubClass를 만드세요.
3. SuperClass obj = new SubClass(); 로 객체를 생성한 뒤, obj.name과 obj.method()를 각각 호출했을 때의 결과를 확인하고, 왜 다른 결과가 나오는지 주석으로 설명하세요.*/
class SuperClass{
    String name = "상위";
    void method(){
        System.out.println("상위 메소드");
    }
}
class SubClass extends SuperClass{
    String name = "하위";
    void method(){
        System.out.println("하위 메소드");
    }
}

/*[문제 10] 다중 상속 관계
1. Device 클래스를 만드세요.
2. Device를 상속받는 Electronic 클래스를 만드세요.
3. Electronic을 상속받는 Laptop 클래스를 만드세요.
4. main 함수에서 Laptop 객체를 생성한 뒤, 이 객체가 Electronic 타입과 Device 타입으로도 형 변환이 가능한지 instanceof 연산자로 확인하고 결과를 출력하세요.*/
class Device{}
class Electronic extends Device{}
class Laptop extends Electronic{}