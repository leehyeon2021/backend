package 종합.예제5;

public class Board {

    // 1. 멤버변수
    private String content;     // private : 현재 클래스에서만 접근 허용
    private String writer;

    // 2. 생성자 : 클래스 내부 빈 공간을 오른쪽클릭->생성->생성자
    // 생성자1(기본생성자) : 사용 여부를 떠나 빈 생성자를 하나 만든다.
    public Board(){}
    // 생성자2(전체 매개변수 생성자)
    public Board(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // 3. 메소드
    // getter and setter : 클래스 내부 빈 공간을 오른쪽클릭->생성-> getter 및 setter
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }

    // toString() : 클래스 내부 빈 공간을 오른쪽클릭->생성-> toString()
    @Override
    public String toString() {
        return "Board{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

    // 거의 다 클래스 내부 빈 공간을 오른쪽클릭->생성으로 자동 생성함.
        // -> 우리는 설계만 잘 하면 된다. -> 이게 데이터 모델링... 로직. (기능은 빼서 Controller에.)
}

