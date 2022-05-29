package DAL;

import java.sql.*;
import java.util.ArrayList;
import DTO.nhanviendao;

public class CSDLQueryNV {
    public static String idNV;
    public static String tenNV;
    
    public static ArrayList<nhanviendao> XuatNV() {
        ArrayList<nhanviendao> nvList = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_nhanvien");
            while (rs.next()) {
                nhanviendao nvtemp = new nhanviendao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6));
                nvList.add(nvtemp);
            }
        } catch (SQLException e) {
            return nvList;
        } 
        return nvList;
    }
    
    public static boolean Dangnhap(String manv){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
         try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            pst = conn.prepareStatement("SELECT * FROM tb_nhanvien WHERE cmnd_cccd=?");
            pst.setString(1, manv);
            rs=pst.executeQuery();
            if (rs.next()) {
                idNV=rs.getString("cmnd_cccd");
                tenNV=rs.getString("tenNV");
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }
    
    public static boolean ThemNV(nhanviendao nvdao) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            pst = conn.prepareStatement("INSERT INTO tb_nhanvien VALUES (?,?,?,?,?,?)");
            pst.setString(1, nvdao.getIdnv());
            pst.setString(2, nvdao.getTennv());
            pst.setString(3, nvdao.getDiachinv());
            pst.setString(4, nvdao.getNgaysinhnv());
            pst.setString(5, nvdao.getAnhnv());
            pst.setString(6, nvdao.getSdtnv());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public static boolean SuaNV(nhanviendao nvdao) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            pst = conn.prepareStatement("UPDATE tb_nhanvien SET tenNV=?,"
                                        + "diachiNV=?, ngaysinhNV=?, anhNV=?, sdtNV=? WHERE cmnd_cccd=?");
            pst.setString(1, nvdao.getTennv());
            pst.setString(2, nvdao.getDiachinv());
            pst.setString(3, nvdao.getNgaysinhnv());
            pst.setString(4, nvdao.getAnhnv());
            pst.setString(5, nvdao.getSdtnv());
            pst.setString(6, nvdao.getIdnv());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public static boolean XoaNV(nhanviendao dao) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            pst = conn.prepareStatement("DELETE FROM tb_nhanvien WHERE cmnd_cccd=?");
            pst.setString(1, dao.getIdnv());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public static ArrayList<nhanviendao> TimkiemNV(String idnv, String tennv) {
        ArrayList<nhanviendao> nvList = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_nhanvien WHERE cmnd_cccd LIKE '%"+idnv+"%' AND tenNV LIKE '%"+tennv+"%'");
            while (rs.next()) {
                nhanviendao nvtemp = new nhanviendao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6));
                nvList.add(nvtemp);
            }
        } catch (SQLException e) {
            return nvList;
        } 
        return nvList;
    }
}
