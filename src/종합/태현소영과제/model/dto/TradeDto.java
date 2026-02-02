package 종합.태현소영과제.model.dto;

public class TradeDto {
    // 1. 멤버변수
    String id;
    String pw;
    String name;
    String pn;
    int no;

    // 2. 생성자
    public TradeDto(){}
    public TradeDto(int no, String id, String pw, String name, String pn) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.pn = pn;
        this.no = no;
    }

    // 3. 메소드
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPn() {
        return pn;
    }
    public void setPn(String pn) {
        this.pn = pn;
    }

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "TradeDto{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", pn='" + pn + '\'' +
                ", no=" + no +
                '}';
    }
}
