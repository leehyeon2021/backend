package 종합.회원제중고거래시스템.model.dto;

public class MemberDto {
    // 1. 멤버변수 = 속성 = 테이블 샘플 참고
    private int mno;
    private String mid;
    private String mpw;
    private String mname;
    private String mphon;
    // 2. 생성자: 기본 생성자와 전체 생성자는 관례적으로 생성
    public MemberDto(){}
    public MemberDto(int mno, String mid, String mpw, String mname, String mphon) {
        this.mno = mno;
        this.mid = mid;
        this.mpw = mpw;
        this.mname = mname;
        this.mphon = mphon;
    }
    // 3. getter/setter
    public int getMno() {
        return mno;
    }
    public void setMno(int mno) {
        this.mno = mno;
    }
    public String getMid() {
        return mid;
    }
    public void setMid(String mid) {
        this.mid = mid;
    }
    public String getMpw() {
        return mpw;
    }
    public void setMpw(String mpw) {
        this.mpw = mpw;
    }
    public String getMname() {
        return mname;
    }
    public void setMname(String mname) {
        this.mname = mname;
    }
    public String getMphon() {
        return mphon;
    }
    public void setMphon(String mphon) {
        this.mphon = mphon;
    }
    @Override
    public String toString() {
        return "MemberDto{" +
                "mno=" + mno +
                ", mid='" + mid + '\'' +
                ", mpw='" + mpw + '\'' +
                ", mname='" + mname + '\'' +
                ", mphon='" + mphon + '\'' +
                '}';
    }
}
