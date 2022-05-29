package DTO;

public class chitiethoadon {
    private String chitiethdid;
    private String maspid;
    private int soluongchitiet;
    private int giachitiet;

    public chitiethoadon(String chitiethdid, String maspid, int soluongchitiet, int giachitiet) {
        this.chitiethdid = chitiethdid;
        this.maspid = maspid;
        this.soluongchitiet = soluongchitiet;
        this.giachitiet = giachitiet;
    }

    public String getChitiethdid() {
        return chitiethdid;
    }

    public void setChitiethdid(String chitiethdid) {
        this.chitiethdid = chitiethdid;
    }

    public String getMaspid() {
        return maspid;
    }

    public void setMaspid(String maspid) {
        this.maspid = maspid;
    }

    public int getSoluongchitiet() {
        return soluongchitiet;
    }

    public void setSoluongchitiet(int soluongchitiet) {
        this.soluongchitiet = soluongchitiet;
    }

    public int getGiachitiet() {
        return giachitiet;
    }

    public void setGiachitiet(int giachitiet) {
        this.giachitiet = giachitiet;
    }

    @Override
    public String toString() {
        return "chitiethoadon{" + "chitiethdid=" + chitiethdid + ", maspid=" + maspid + ", soluongchitiet=" + soluongchitiet + ", giachitiet=" + giachitiet + '}';
    }

 
}
