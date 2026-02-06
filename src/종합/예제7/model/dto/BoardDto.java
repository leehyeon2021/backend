package 종합.예제7.model.dto;

// 레코드 하나(행 하나)에 DTO 하나. 자료는 고유값이기 때문에 싱글톤을 사용하지 않는다. 여러 자료 - 싱글아님ㅎㅎ
// view , controller , dao는 고유하지 않아서 굳이 여러개일 필요가 없다. 싱글!

public class BoardDto {
    /* 데이터베이스(표)의 속성(열) 참고 (속성명)
    bno int unsigned auto_increment,
    constraint primary key(bno) ,
    bcontent longtext not null ,
    bwriter varchar(30) not null ,
    bdate datetime default now()*/
    // 멤버변수: 데이터베이스의 속성명과 일치시키기. +) 기능에 따라 추가 커스텀 필요.
    private int bno;
    private String bcontent;
    private String bwriter;
    private String bdate;

    // 기본생성자  ,전체매개변수생성자
    public BoardDto(){}
    public BoardDto(int bno, String bcontent, String bwriter, String bdate) {
        this.bno = bno;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = bdate;
    }
    // 추가로 생성자 만들어도 된대...... ON NO! 왜 고생한겨
    public BoardDto(String bcontent, String bwriter) {
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    public int getBno() {
        return bno;
    }
    public void setBno(int bno) {
        this.bno = bno;
    }
    public String getBcontent() {
        return bcontent;
    }
    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }
    public String getBwriter() {
        return bwriter;
    }
    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }
    public String getBdate() {
        return bdate;
    }
    public void setBdate(String bdate) {
        this.bdate = bdate;
    }
    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                ", bdate='" + bdate + '\'' +
                '}';
    }
}
