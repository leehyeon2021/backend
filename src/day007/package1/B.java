package day007.package1;

public class B {

    public void 메소드(){
        // ---> 다른 클래스에서 접근제한자 의미가 있는지
        A a = new A();
        System.out.println("a.공개변수 = " + a.공개변수); //ok
        //System.out.println("a.비공개변수 = " + a.비공개변수); 불가능.
        System.out.println("a.일반변수 = " + a.일반변수);
        //같은 패키지 않에 있어서 일반 변수가 에러 안 나고 제대로 불러와진다.

        a.메소드(); // ok
        //a.비공개메소드(); -> error



    }

}
