package day007;

public class Exam3 {

    public static void main(String[] args){
        /*
        1. 멤버변수가 private이면 다른 클래스 접근 불가능*/
        User user = new User();
        /*
        user.name = "유재석";
        System.out.println("user.name ="+user.name);
        // vs.
        setter 이용한 멤버변수 접근(저장)*/
        user.setName("유재석");/*
        getter 이용한 멤버변수 접근(호출)*/
        System.out.println(user.getName());

     // 2. toString
        System.out.println(user);

    }
}


class User{
    // 1. 멤버변수
    private String name;
    private int age;
    // 2. 생성자
    // 3. 메소드
    // * 과녜적으로 private 멤버변수에 대해 간접접근
    // getter 메소드: 호환용
    //    - public void get멤버변수명(){ return 멤버변수명; }
    public String getName(){
        return this.name;
    }
    // setter 메소드: 저장용
    //    - public void set멤버변수명( 타입 매개변수 ){ this.멤버변수명 = 매개변수; }
    public void setName(String name) { //private으로 하면 다른 클래스에서 사용 안 됨...
        this.name = name;
    }
    // 자동: 클래스나 마우스로 오른쪽클릭 -> 생성 -> <setter 및 goeter
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    /* toString() 메소드
    - 모든 클래스가 자동으로 갖고 있는 메소드를 하나
    객체의 주소(위치)값 출력
    자동: 클래스 내 마우스오른쪽클릭 -> 생성 -> toString    */
    // 자동으로 생성하면 아래처럼 나온다.
    @Override // 오버라이드: 기존 메소드를 커스텀/재정의
    public String toString() {
        // * 객체의 주소값 대신에 출력하고 싶은 것
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}//class end