
package DTO;

public class nhanviendao {
    private String idnv;
    private String tennv;
    private String diachinv;
    private String ngaysinhnv;
    private String anhnv;
    private String sdtnv;

    public nhanviendao() {
    }

    public nhanviendao(String idnv, String tennv, String diachinv, String ngaysinhnv, String anhnv, String sdtnv) {
        this.idnv = idnv;
        this.tennv = tennv;
        this.diachinv = diachinv;
        this.ngaysinhnv = ngaysinhnv;
        this.anhnv = anhnv;
        this.sdtnv = sdtnv;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getDiachinv() {
        return diachinv;
    }

    public void setDiachinv(String diachinv) {
        this.diachinv = diachinv;
    }

    public String getNgaysinhnv() {
        return ngaysinhnv;
    }

    public void setNgaysinhnv(String ngaysinhnv) {
        this.ngaysinhnv = ngaysinhnv;
    }

    public String getAnhnv() {
        return anhnv;
    }

    public void setAnhnv(String anhnv) {
        this.anhnv = anhnv;
    }

    public String getSdtnv() {
        return sdtnv;
    }

    public void setSdtnv(String sdtnv) {
        this.sdtnv = sdtnv;
    }

    @Override
    public String toString() {
        return "nhanviendao{" + "idnv=" + idnv + ", tennv=" + tennv + ", diachinv=" + diachinv + ", ngaysinhnv=" + ngaysinhnv + ", anhnv=" + anhnv + ", sdtnv=" + sdtnv + '}';
    }

}
