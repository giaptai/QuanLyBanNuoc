package DAL;

import java.sql.*;
import java.util.ArrayList;
import DTO.sanphamdao;

/**
 *
 * @author GIAPTAI
 */
public class CSDLQueryDao {
    public static ArrayList<sanphamdao> XuatSanPhamDao() {
        ArrayList<sanphamdao> daoList = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_sanpham ");//ORDER BY tinhtrangSP, tenSP ASC
            while (rs.next()) {
                sanphamdao cbtemp = new sanphamdao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
                daoList.add(cbtemp);
            }
        } catch (SQLException e) {
            return daoList;
        } 
        return daoList;
    }
    public static boolean ThemSP(sanphamdao dao) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            pst = conn.prepareStatement("INSERT INTO tb_sanpham VALUES (?,?,?,?,?,?)");
            pst.setString(1, dao.getMasp());
            pst.setString(2, dao.getTensp());
            pst.setString(3, dao.getAnhsp());
            pst.setInt(4, dao.getSoluongsp());
            pst.setString(5, dao.getTinhtrangsp());
            pst.setInt(6, dao.getGiasp());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static boolean SuaSP(sanphamdao dao) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            pst = conn.prepareStatement("UPDATE tb_sanpham SET tenSP=?,"
                                        + "anhSP=?, soluongSP=?, tinhtrangSP=?, giaSP=? WHERE maSP=?");
            pst.setString(1, dao.getTensp());
            pst.setString(2, dao.getAnhsp());
            pst.setInt(3, dao.getSoluongsp());
            pst.setString(4, dao.getTinhtrangsp());
            pst.setInt(5, dao.getGiasp());
            pst.setString(6, dao.getMasp());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
 
    public static boolean XoaSP(sanphamdao dao) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            pst = conn.prepareStatement("DELETE FROM tb_sanpham WHERE maSP=?");
            pst.setString(1, dao.getMasp());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static boolean CapnhatSP(String dao, int slmua) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            pst = conn.prepareStatement("UPDATE tb_sanpham SET soluongSP=soluongSP-?, tinhtrangSP=IF( soluongSP = 0, 'Hết Hàng', tinhtrangSP) WHERE tenSP=?");
            pst.setInt(1, slmua);
            pst.setString(2, dao);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public static ArrayList<sanphamdao> timkiemSP(String tspdao, String masp, String ttsp){
        ArrayList<sanphamdao> daoList = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        String s2 = null, s3 = null, s4 = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.createStatement();
            //////////////////////////
            ResultSet rs = st.executeQuery("SELECT * FROM tb_sanpham WHERE tenSP LIKE '%"+ tspdao +"%' AND maSP LIKE '%"+masp+"%'AND tinhtrangSP LIKE '%"+ttsp+"%'");
            while (rs.next()) {
                sanphamdao cbtemp = new sanphamdao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
                daoList.add(cbtemp);
            }
        } catch (SQLException e) {
            return null;
        } 
        return daoList;
    }
    
        public static ArrayList<sanphamdao> TimkiemMenu(String tk){
        ArrayList<sanphamdao> spMenu=new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_sanpham WHERE tenSP LIKE '%"+tk+"%'");
            while (rs.next()) {
                sanphamdao cbtemp = new sanphamdao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6));
                spMenu.add(cbtemp);
            }
        } catch (SQLException e) {
            return null;
        } 
        return spMenu;
    }
    
}
