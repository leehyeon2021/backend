package day007;

public class Phone {

    // 클래스는 세 가지의 멤버를 갖는다. (멤버변수, 생성자, 메소드)

    // 1. 멤버변수(속성)
    String model;
    String color;
    int price;

    // 2. 생성자
        // 1. 클래스명과 동일하게 생성자명 작성!
    Phone(){} // -> 기본 생성자: 매개 변수 없는 생성자
        // 2. () 안에 매개변수 정의한다.
        // 3. 메소드와 다른 점은 반환타입이 없다는 것!
    Phone( String model , String color) {
        this.model = model;
        this.color = color;
    }
        // 4.
    Phone( String model , String color , int price ){
        this.model = model;
        this.color = color;
        this.price = (int)(price * 0.8); //20%할인
    }
    //Phone( String model2 , String color2 , int price2 ){}
    // 이렇게 매개변수 명이 다르다고 오버로드 허용되는 건 아님. 매개변수는 신경 안 씀. 매개변수의 개수,타입,순서만!

    // 3. 메소드(멤버함수)

}
