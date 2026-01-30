package 종합.과제2.model.dto;

// 대기 팀 1건의 정보를 저장하는 데이터 객체

public class WaitingDto {

    // 싱글톤 없음

    // 1. 멤버변수
    private int no;
    private String phone;
    private int count;

    // 2. 생성자 (기본+전체)
    public WaitingDto(){}
    public WaitingDto(int no, String phone, int count) {
        this.no = no;
        this.phone = phone;
        this.count = count;
    }

    // 3. 메소드 (getter/setter , toString()오버라이딩 )
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "WaitingDto{" +
                "no=" + no +
                ", phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
}
