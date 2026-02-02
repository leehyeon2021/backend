package 종합.회원제중고거래시스템.model.dto;

public class ProductDto {
    private int pno;
    private String pname;
    private int pprice;
    private String pcomment;
    private int mno;


    // +) 조회 시 필요한 '판매자' 미리 만들어두면 좋음. (판매자 이름 나와야 하는데 mno(번호)가 나오게 되니까!)
    // [1] ProductDto에서 판매자닉네임 추가하기.
    private String mname;

    public String getMname() {return mname;}
    public void setMname(String mname) {
        this.mname = mname;
    }

    public ProductDto(){}
    public ProductDto(int pno, String pname, int pprice, String pcomment, int mno) {
        this.pno = pno;
        this.pname = pname;
        this.pprice = pprice;
        this.pcomment = pcomment;
        this.mno = mno;
    }
    public int getPno() {
        return pno;
    }
    public void setPno(int pno) {
        this.pno = pno;
    }
    public String getPname() {
        return pname;
    }
    public void setPname(String pname){this.pname = pname;}
    public int getPprice() {
        return pprice;
    }
    public void setPprice(int pprice) {this.pprice = pprice;}
    public String getPcomment() {
        return pcomment;
    }
    public void setPcomment(String pcomment) {
        this.pcomment = pcomment;
    }
    public int getMno() {
        return mno;
    }
    public void setMno(int mno) {this.mno = mno;}

    @Override
    public String toString() {
        return "ProductDto{" +
                "pno=" + pno +
                ", pname='" + pname + '\'' +
                ", pprice=" + pprice +
                ", pcomment='" + pcomment + '\'' +
                ", mno=" + mno +
                '}';
    }
}
