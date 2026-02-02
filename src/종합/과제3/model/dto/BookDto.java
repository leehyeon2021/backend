package 종합.과제3.model.dto;


public class BookDto {
    private int bno;
    private String bname;
    private String bw;
    private String bp;
    private int mno;

    public BookDto(){}
    public BookDto(int bno, String bname, String bw, String bp, int mno) {
        this.bno = bno;
        this.bname = bname;
        this.bw = bw;
        this.bp = bp;
        this.mno = mno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBw() {
        return bw;
    }

    public void setBw(String bw) {
        this.bw = bw;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bno=" + bno +
                ", bname='" + bname + '\'' +
                ", bw='" + bw + '\'' +
                ", bp='" + bp + '\'' +
                ", mno=" + mno +
                '}';
    }
}
