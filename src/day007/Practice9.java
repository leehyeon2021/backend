package day007;

public class Practice9 {
    public static void main(String[] args) {
        /*[실습] * 제출용 */

        /*[문제 1] Book 클래스를 만드세요. (title, author, price 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
        1. Book 클래스에 title, author, price를 매개변수로 받아 멤버 변수를 초기화하는 생성자를 만드세요.
        2. main 함수에서 이 생성자를 사용하여,
           ("이것이 자바다", "신용권", 30000) 정보와 ("자바의 정석", "남궁성", 28000) 정보를 가진 Book 객체 2개를 생성하고, 각 객체의 정보를 출력하세요.*/
        Book b1 = new Book("이것이 자바다", "신용권", 30000);
        Book b2 = new Book("자바의 정석", "남궁성", 28000);
        System.out.println(b1.title + b1.author + b1.price);
        System.out.println(b2.title + b2.author + b2.price);

        /*[문제 2] Rectangle 클래스를 만드세요. (width, height 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
        1. width와 height를 매개변수로 받아 초기화하는 생성자를 만드세요.
        2. 사각형의 넓이(width * height)를 계산하여 반환하는 getArea() 메소드를 만드세요.
        3. main 함수에서 (10, 5) 값을 가진 Rectangle 객체를 생성하고, getArea() 메소드를 호출하여 "사각형의 넓이: [넓이]"를 출력하세요.*/
        Rectangle r1 = new Rectangle(10 , 5);
        System.out.println(r1.getArea());

        /*[문제 3] BankAccount 클래스를 만드세요. (accountNumber, ownerName, balance 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
        1. 세 멤버 변수를 모두 초기화하는 생성자를 만드세요.
        2. 입금(deposit)과 출금(withdraw) 기능을 하는 메소드를 각각 만드세요.
        3. main 함수에서 ("111-222-3333", "유재석", 10000) 정보로 객체를 생성한 뒤, 5000원을 입금하고 3000원을 출금한 후의 최종 잔액을 출력하세요.*/
        BankAccount b3 = new BankAccount("111-222-3333", "유재석", 10000);
        b3.deposit(5000); b3.deposit(3000);
        System.out.println("잔액: "+b3.balance+" 원");

        /*[문제 4] Goods 클래스를 만드세요. (name, price 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
        1. Goods 클래스에 생성자를 두 개 만드세요(오버로딩).
        2. 기본 생성자: name은 "미정", price는 0으로 초기화
        3. 매개변수가 있는 생성자: name과 price를 매개변수로 받아 초기화
        4. main 함수에서 기본 생성자로 객체 하나, 매개변수가 있는 생성자로 ("콜라", 2000) 정보를 가진 객체 하나를 각각 생성하고, 두 객체의 정보를 모두 출력하세요.*/
        Gods g4 = new Gods();
        Gods g5 = new Gods("콜라", 2000);
        System.out.printf("기본: %s , %d 원\n" , g4.name, g4.price);
        System.out.printf("콜라: %s , %d 원\n",  g5.name, g5.price);

        /*[문제 5] Member 클래스를 만드세요. (id, isLogin 멤버 변수) *멤버변수의 타입은 적절하게 선택하시오.
        1. Member 클래스에 기본 생성자를 만들고, 이 생성자 안에서 id는 "guest", isLogin은 false로 초기화되도록 하세요.
        2. main 함수에서 new Member()로 객체를 생성하고, 초기화된 id와 isLogin 값을 출력하여 확인하세요.*/
        Member m5 = new Member();
        System.out.println("id: "+m5.id + ", isLogin: " + m5.inLogin);

    }//main end
}//class end

//[1]
class Book {
    // 멤버변수 = 속성
    String title;
    String author;
    int price;
    // 생성자 = 객체 초기화/만들때/생성할때 사용되는 메소드
    Book( String title , String author , int price){
        this.title = title;
        this.author = author;
        this.price = price;
    } // 클래스 내 오른쪽 마우스오른쪽 (빈공간)클릭 -> 생성 -> 생성자 -> 매개변수선택(복수) -> 확인
}

//[2]
class Rectangle{
    int width;
    int height;

    Rectangle( int width , int height){
        this.width = width;
        this.height = height;
    }

    int getArea(){
        return width * height;
    }

}

//[3]
class BankAccount{
    String accountNumber;
    String ownerName;
    int balance;
    BankAccount(String accountNumber , String ownerName , int balance){
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    int deposit( int deposit ){
        return balance += deposit;
    }
    int withdraw( int withdraw){
        if(balance!=0){
            balance-=withdraw;
            return balance;
        }   return balance;
    }

}

// [4]
class Gods{
    String name;
    int price;

    Gods(){
        this.name = "미정";
        this.price = 0;
    }

    Gods( String name , int price){
        this.name = name;
        this.price = price;
    }
}

// [5]
class Member{
    String id;
    boolean inLogin;

    Member(){
        this.id = "guest";
        this.inLogin = false;
    }
}