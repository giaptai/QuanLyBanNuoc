
package DTO;

public class hoadondao {
    private String mahd;
    private String ngayhd;
    private String noidunghd;
    private int giahd;
    private String maNVdh;
    private String tenNVdh;

    public hoadondao() {
    }

    public hoadondao(String mahd, String ngayhd, String noidunghd, int giahd, String maNVdh, String tenNVdh) {
        this.mahd = mahd;
        this.ngayhd = ngayhd;
        this.noidunghd = noidunghd;
        this.giahd = giahd;
        this.maNVdh = maNVdh;
        this.tenNVdh = tenNVdh;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getNgayhd() {
        return ngayhd;
    }

    public void setNgayhd(String ngayhd) {
        this.ngayhd = ngayhd;
    }

    public String getNoidunghd() {
        return noidunghd;
    }

    public void setNoidunghd(String noidunghd) {
        this.noidunghd = noidunghd;
    }

    public int getGiahd() {
        return giahd;
    }

    public void setGiahd(int giahd) {
        this.giahd = giahd;
    }

    public String getMaNVdh() {
        return maNVdh;
    }

    public void setMaNVdh(String maNVdh) {
        this.maNVdh = maNVdh;
    }

    public String getTenNVdh() {
        return tenNVdh;
    }

    public void setTenNVdh(String tenNVdh) {
        this.tenNVdh = tenNVdh;
    }

    @Override
    public String toString() {
        return "hoadondao{" + "mahd=" + mahd + ", ngayhd=" + ngayhd + ", noidunghd=" + noidunghd + ", giahd=" + giahd + ", maNVdh=" + maNVdh + ", tenNVdh=" + tenNVdh + '}';
    }

}
