package DTO;

/**
 *
 * @author TAIGIAP
 */
public class sanphamdao {
    private String masp;
    private String tensp;
    private String anhsp;
    private int soluongsp;
    private String tinhtrangsp;
    private int giasp;
    
    public sanphamdao (){}

    public sanphamdao(String masp, String tensp, String anhsp, int soluongsp, String tinhtrangsp, int giasp) {
        this.masp = masp;
        this.tensp = tensp;
        this.anhsp = anhsp;
        this.soluongsp = soluongsp;
        this.tinhtrangsp = tinhtrangsp;
        this.giasp = giasp;
    }


    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getAnhsp() {
        return anhsp;
    }

    public void setAnhsp(String anhsp) {
        this.anhsp = anhsp;
    }

    public int getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(int soluongsp) {
        this.soluongsp = soluongsp;
    }
    
    public String getTinhtrangsp() {
        return tinhtrangsp;
    }

    public void setTinhtrangsp(String tinhtrangsp) {
        this.tinhtrangsp = tinhtrangsp;
    }

    public int getGiasp() {
        return giasp;
    }

    public void setGiasp(int giasp) {
        this.giasp = giasp;
    }

    @Override
    public String toString() {
        return "sanphamdao{" + "masp=" + masp + ", tensp=" + tensp + ", anhsp=" + anhsp + ", soluongsp=" + soluongsp + ", tinhtrangsp=" + tinhtrangsp + ", giasp=" + giasp + '}';
    }

}
