package day005;

import java.util.Scanner;

public class Practice7 {
    public static void main(String[] args) {

        /*[실습] * 제출용 */

        /*[문제 1] Book 클래스를 만드세요. 이 클래스는 title(문자열), author(문자열), price(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Book 객체 2개를 생성하세요.
        2. 첫 번째 객체에는 "이것이 자바다", "신용권", 30000을, 두 번째 객체에는 "자바의 정석", "남궁성", 28000을 각각 저장하세요.
        3. 두 객체의 모든 정보를 각각 출력하세요.*/
        // [1] 클래스명은 첫 글자를 무조건 대문자로 만든다.
        // 1. 클래스 정의/선언 만들기
        // 2. 정의한 클래스로 객체를 선언한다.
        Book book1 = new Book();    // 객체1. 주로 변수명은 소문자로 시작한다.
                    // import??(나중에 배운대) 이미 만들어진 것을 참조하지 않도록 잘 확인하기~~
            book1.title = "이것이 자바다"; book1.author = "신용권"; book1.price = 30000; // 3. 객체변수명.속성명 = 새로운값
        Book book2 = new Book();    // 객체2
            book2.title = "자바의 정석"; book2.author = "남궁성"; book2.price = 20000;
        // 4. 객체변수명.속성명
        System.out.println(book1.title + book1.author + book1.price);
        System.out.println(book2.title + book2.author + book2.price);

        /*[문제 2] Pet 클래스를 만드세요. name(문자열), species(문자열, 품종), age(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Pet 객체 2개를 생성하세요.
        2. 첫 번째 객체에는 "초코", "푸들", 3을, 두 번째 객체에는 "나비", "코리안숏헤어", 5를 각각 저장하세요.
        3. "이름: [이름], 종류: [품종], 나이: [나이]살" 형식으로 각 반려동물의 프로필을 출력하세요.*/
        // [2] 객체 생성시 멤버변수에 초기값이 없으면 기본값 들어간다.
            // -> 정수: 0 , 실수: 0.0 , 논리: false , 문자열/객체 = null
        Pet pet1 = new Pet(); // 객체1
            pet1.name = "초고"; pet1.species = "푸들"; pet1.age = 3;
        Pet pet2 = new Pet(); // 객체2
            pet2.name = "나비"; pet2.species = "코리안숏헤어"; pet2.age = 5;
        System.out.printf("이름: %s , 품종: %s, 나이: %d살\n", pet1.name, pet1.species, pet1.age);
        System.out.printf("이름: %s , 품종: %s, 나이: %d살\n", pet2.name, pet2.species, pet2.age);

        /*[문제 3] Rectangle 클래스를 만드세요. width(정수)와 height(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Rectangle 객체를 하나 생성하고, width에 10, height에 5를 저장하세요.
        2. 해당 객체의 width와 height 값을 곱하여 "사각형의 넓이: [넓이]"를 출력하세요.*/
        // [3] 멤버변수 간의 연산/계산 가능1
        Rectangle rect1 = new Rectangle(); // 객체 생성
        rect1.width = 10; rect1.height = 5; // 객체 내 멤버변수 수정
        System.out.println("rect1.height = " + rect1.height * rect1.width);

        /*[문제 4] BankAccount 클래스를 만드세요. accountNumber(문자열), ownerName(문자열), balance(정수, 잔액) 멤버 변수를 가집니다.
        1. main 함수에서 BankAccount 객체를 하나 생성하고, 계좌번호는 "111-222-3333", 예금주는 "유재석", 초기 잔액은 10000으로 저장하세요.
        2. balance에 5000을 더하여 입금 상황을 구현하고, "입금 후 잔액: [잔액]"을 출력하세요.
        3. 다시 balance에서 3000을 빼서 출금 상황을 구현하고, "출금 후 잔액: [잔액]"을 출력하세요.*/
        // [4] 멤버변수 간의 연산/계산 가능2
        BankAccount account1 = new BankAccount();
        account1.accountNumber = "111-222-3333"; account1.ownerName = "유재석"; account1.balance = 10000; // 객체 내 멤버변수에 값 대입
        account1.balance = account1.balance+5000; // == account1.balance += 5000;
        System.out.println("account1.balance = " + account1.balance);
        account1.balance -= 3000;
        System.out.println("account1.balance = " + account1.balance);

        /*[문제 5] Product 클래스를 만드세요. name(문자열)과 price(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Product 객체 2개를 생성하고, 각각 "새우깡", 1500과 "콜라", 2000 정보를 저장하세요.
        2. if문을 사용하여 두 객체의 price를 비교하고, 더 비싼 상품의 이름을 출력하세요.*/
        Product pro1 = new Product();
        pro1.name = "새우깡"; pro1.price = 1500;
        Product pro2 = new Product();
        pro2.name = "콜라";  pro2.price = 2000;
        if(pro1.price > pro2.price){System.out.println(pro1);}
        else{System.out.println(pro2);}

        /*[문제 6] Member 클래스를 만드세요. id(문자열)와 isLogin(boolean) 멤버 변수를 가집니다.
        1. main 함수에서 Member 객체를 하나 생성하고, 아이디는 "admin", isLogin은 false로 초기화하세요.
        2. "로그인 전 상태: [isLogin 값]"을 출력하세요.
        3. 객체의 isLogin 값을 true로 변경하여 로그인 상황을 구현하세요.
        4. "로그인 후 상태: [isLogin 값]"을 출력하세요.*/
        Member mem1 = new Member();
        mem1.id = "admin"; mem1.isLogin = false;
        System.out.println("로그인 전 상태: " + mem1.isLogin);
        mem1.isLogin = true;
        System.out.println("로그인 후 상태: " + mem1.isLogin);

        /*[문제 7] Television 클래스를 만드세요. channel(정수)과 volume(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Television 객체를 생성하고, channel은 7, volume은 20으로 초기화하세요.
        2. 객체의 channel 값을 11로 변경하고, volume 값은 2 감소시킨 뒤, 변경된 채널과 볼륨을 출력하세요.*/
        Television tel1 = new Television();
        tel1.channel = 7; tel1.volume = 20;
        tel1.channel = 11; tel1.volume-=2;
        System.out.println("tel1.channel , tel1.volume = " + tel1.channel + tel1.volume);

        /*[문제 8] Player 클래스를 만드세요. name(문자열), power(정수), speed(정수) 멤버 변수를 가집니다.
        1. main 함수에서 Player 객체 2개를 생성하세요.
        2. 첫 번째 객체에는 "손흥민", 90, 95를, 두 번째 객체에는 "이강인", 85, 92를 각각 저장하세요.
        3. 두 객체의 power와 speed의 합을 각각 계산하고, 합이 더 높은 선수의 이름을 출력하세요.*/
        Player p1 = new Player();
        p1.name="손흥민"; p1.power=90; p1.speed=95;    int sum1 = p1.power+p1.speed;
        Player p2 = new Player();
        p2.name="이강인"; p2.power=85; p2.speed=92;    int sum2 = p2.power+p2.speed;
        if(sum1>sum2){System.out.println(p1.name);}
        else{System.out.println(p2.name);}

        /*[문제 9] MenuItem 클래스를 만드세요. name(문자열), price(정수), isSignature(boolean, 대표메뉴 여부) 멤버 변수를 가집니다.
        1. main 함수에서 MenuItem 객체 3개를 생성하고, 첫 번째는 "김치찌개", 8000, true, 두 번째는 "된장찌개", 8000, false, 세 번째는 "계란찜", 3000, false로 저장하세요.
        2. if문을 사용하여 isSignature가 true인 메뉴 객체를 찾아, "[대표메뉴] [메뉴이름] : [가격]원" 형식으로 출력하세요.*/
        MenuItem mi1 = new MenuItem();
        mi1.name = "김치찌개"; mi1.price = 8000; mi1.isSignature = true;
        MenuItem mi2 = new MenuItem();
        mi2.name = "된장찌개"; mi2.price = 8000; mi2.isSignature = false;
        MenuItem mi3 = new MenuItem();
        mi3.name = "계란찜"; mi3.price = 3000; mi3.isSignature = false;
        if(mi1.isSignature == true){System.out.println(mi1.name + mi1.price);}
        if(mi2.isSignature == true){System.out.println(mi2.name + mi2.price);}
        if(mi3.isSignature == true){System.out.println(mi3.name + mi3.price);}

        /*[문제 10] UserProfile 클래스를 만드세요. name(문자열), age(정수), mbti(문자열) 멤버 변수를 가집니다.
        1. main 함수에서 UserProfile 객체를 하나 생성하세요.
        2. Scanner를 사용하여 사용자로부터 이름, 나이, MBTI를 순서대로 입력받으세요.
        3. 입력받은 값들을 생성된 객체의 각 멤버 변수에 저장하세요.
        3. 모든 정보가 저장된 객체의 멤버 변수들을 가져와 "--- 프로필 ---", "이름: [이름]", "나이: [나이]", "MBTI: [MBTI]" 형식으로 출력하세요.*/
        UserProfile user1 = new UserProfile();
        Scanner scan = new Scanner(System.in);
        System.out.print("이름: "); //user1.name = scan.next();
        String name = scan.next(); user1.name = name; // 객체명.속성명 = 변수명;
        System.out.print("나이: "); user1.age = scan.nextInt();
        System.out.print("MBTI: "); user1.mbti = scan.next();
        System.out.printf("--- 프로필 ---\n이름: %s\n나이: %d\nMBTI: %s\n", user1.name , user1.age , user1.mbti);

    } // main end
} // class end