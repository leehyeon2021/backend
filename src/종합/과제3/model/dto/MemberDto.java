package 종합.과제3.model.dto;

public class MemberDto {
    private int mno;
    private String mname;
    private String mid;
    private String mpw;

    private String qname;

    public MemberDto(){}
    public MemberDto(int mno, String mname, String mid, String mpw, String qname) {
        this.mno = mno;
        this.mname = mname;
        this.mid = mid;
        this.mpw = mpw;
        this.qname = qname;
    }

    public int getMno() {return mno;}
    public void setMno(int mno) {this.mno = mno;}
    public String getMname() {return mname;}
    public void setMname(String mname) {this.mname = mname;}
    public String getMid() {return mid;}
    public void setMid(String mid) {this.mid = mid;}
    public String getMpw() {return mpw;}
    public void setMpw(String mpw) {this.mpw = mpw;}

    public String getQname() {return qname;}
    public void setQname(String qname) {this.qname = qname;}

    @Override
    public String toString() {
        return "MemberDto{" +
                "mno=" + mno +
                ", mname='" + mname + '\'' +
                ", mid='" + mid + '\'' +
                ", mpw='" + mpw + '\'' +
                ", qname='" + qname + '\'' +
                '}';
    }
}
