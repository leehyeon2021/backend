package day007;

public class Practice10 {
    public static void main(String[] args) {
        /*[실습] 제출용 /
        /*[문제 1] Member 클래스를 만드세요.
        1. 이 클래스는 private 접근 제한자를 가진 id(문자열) 멤버 변수를 가집니다.
        2. private으로 선언된 id 필드의 값을 저장하고, 반환할 수 있도록 public 접근 제한자를 가진 setId()와 getId() 메소드(Getter/Setter)를 만드세요.
        3. main 함수에서 Member 객체를 생성하고, setId()로 아이디를 "admin"으로 설정한 뒤, getId()로 설정된 아이디를 가져와 출력하세요.*/
        Member1 m1 = new Member1();
        m1.setId("admin");
        System.out.println("id: "+m1.getId());

        /*[문제 2] Score 클래스를 만드세요.
        1. private 접근 제한자를 가진 score(정수) 멤버 변수를 가집니다.
        2. 점수를 설정하는 setScore(int score) 메소드를 정의하세요.
        3. 이 메소드는 매개변수로 받은 점수가 0 이상 100 이하일 경우에만 멤버 변수 score에 값을 저장하고, 범위를 벗어나면 "유효하지 않은 점수입니다."라고 출력해야 합니다.
        4. main 함수에서 Score 객체를 생성하고, setScore(85)와 setScore(120)를 각각 호출하여 결과가 올바르게 나오는지 확인하세요.*/
        Score s2 = new Score();
        System.out.println("85: "+s2.setScore(85));
        System.out.println("120: "+s2.setScore(120));

        /*[문제 3] BankAccount 클래스를 만드세요.
        1. private 접근 제한자를 가진 accountNumber(문자열) 멤버 변수를 가집니다.
        2. 객체를 생성할 때만 계좌번호를 설정할 수 있도록, accountNumber를 초기화하는 생성자를 만드세요.
        3. 계좌번호를 외부에서 읽을 수만 있도록 public 접근 제한자를 가진 getAccountNumber() 메소드(Getter)만 정의하세요. (Setter는 만들지 않습니다.)
        4. main 함수에서 "123-456"을 계좌번호로 가진 객체를 생성하고, getAccountNumber()로 계좌번호를 출력하여 확인하세요.*/
        BankAccount1 b3 = new BankAccount1("123-456");
        System.out.println("계좌번호: "+b3.getAccountNumber());
        //System.out.println(b3.accountNumber); 안 됨 우왕

        /*[문제 4] CircleCalculator 클래스를 만드세요.
        1. 이 클래스 안에, 원주율(PI)을 저장할 final double PI = 3.14159; 상수를 선언하세요.
        2. 반지름(정수)을 매개변수로 받아, 원의 넓이(반지름 반지름 PI)를 계산하여 출력하는 printCircleArea 메소드를 정의하세요.
        3. main 함수에서 CircleCalculator 객체를 생성하고, 반지름이 5인 원의 넓이를 출력하세요.*/
        CircleCalculator c4 = new CircleCalculator();
        System.out.println("원의 넓이: "+c4.printCircleArea(5));

        /*[문제 5] TicketMachine 클래스를 만드세요.
        1. 이 클래스 안에, 발권된 총 티켓 수를 저장할 static int totalTickets = 0; 정적 변수를 선언하세요.
        2. 티켓을 한 장 발권하는 issueTicket() 인스턴스 메소드를 만드세요. 이 메소드는 호출될 때마다 totalTickets를 1씩 증가시키고, "티켓 1장을 발권했습니다."라고 출력합니다.
        3. 현재까지 발권된 총 티켓 수를 출력하는 static void printTotalTickets() 정적 메소드를 만드세요.
        4. main 함수에서 TicketMachine 객체 3개(machine1, machine2, machine3)를 생성하세요.
        5. machine1으로 티켓 2장, machine2로 티켓 1장을 발권한 뒤, TicketMachine.printTotalTickets()를 호출하여 총 발권 수가 올바르게 나오는지 확인하세요.*/
        TicketMachine machine1 = new TicketMachine(); machine1.issueTicket(); machine1.issueTicket();
        TicketMachine machine2 = new TicketMachine(); machine2.issueTicket();
        TicketMachine machine3 = new TicketMachine();
        TicketMachine.printTotalTickets();

        /*[문제 6] 게임의 고정 설정 값을 관리하는 GameConfig 클래스를 만드세요.
        1. 이 클래스 안에, 어디서든 접근 가능하며 절대 변하지 않는 다음 상수들을 public static final로 선언하세요.
        최대 레벨 MAX_LEVEL = 99
        최대 HP MAX_HP = 10000
        게임 이름 GAME_TITLE = "My RPG"
        2. main 함수에서 객체를 생성하지 않고 GameConfig.GAME_TITLE 과 같이 클래스 이름으로 직접 접근하여 모든 설정 값을 출력하세요.*/
        System.out.println(GameConfig.MAX_LEVEL);
        System.out.println(GameConfig.MAX_HP);      // 클래스 이름으로 직접 접근
        System.out.println(GameConfig.GAME_TITLE);


    }//main end
}//class end

// [1]
class Member1{
    private String id;
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
}

// [2]
class Score{
    private int score;
    public String setScore(int score){
        if(score>=0&&score<=100){
            this.score = score;
        }else{
            return "유효하지 않은 점수입니다.";
        }
        return "점수가 저장되었습니다.";
    }//setScore
}//Score

// [3]
class BankAccount1{
    private String accountNumber;
    BankAccount1(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
}

// [4]
class CircleCalculator{
    final double PI = 3.14159;
    double printCircleArea(int radius){
        return radius*radius*PI;
    }
}

// [5]
class TicketMachine{
    static int totalTickets = 0;
    String issueTicket(){
        totalTickets+=1;
        return "티켓 1장을 발권했습니다.";
    }
    static void printTotalTickets(){
        System.out.println(totalTickets);
    }
}

// [6]
class GameConfig{
    public static final Short MAX_LEVEL = 99;
    public static final int MAX_HP = 10000;
    public static final String GAME_TITLE = "My RPG";
}









