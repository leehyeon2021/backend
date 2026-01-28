package day007.package1;

public class A {

    public int 공개변수;
    private int 비공개변수;
    int 일반변수;   // default

    public void 메소드(){  // ---> 같은 클래스에서는 접근제한자의 의미가 없다.
        System.out.println("공개변수 = " + 공개변수); //ok
        System.out.println("비공개변수 = " + 비공개변수); //ok
        System.out.println("일반변수 = " + 일반변수);
    }
    private void 비공개메소드(){
        System.out.println("A.비공개메소드");
    }
}
