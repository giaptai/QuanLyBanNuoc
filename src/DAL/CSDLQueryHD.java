
package DAL;

import DTO.chitiethoadon;
import DTO.hoadondao;
import DTO.sanphamdao;
import java.util.ArrayList;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Arrays;

public class CSDLQueryHD {
    DecimalFormat df = new DecimalFormat("###,###,###");
    public static ArrayList<hoadondao> XuatHoaDonDao(){
        ArrayList<hoadondao> hdList=new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_hoadon");
            while (rs.next()) {
                hoadondao hdtemp = new hoadondao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6));
                hdList.add(hdtemp);
            }
        } catch (SQLException e) {
            return hdList;
        } 
        return hdList;
    }
    
    public static boolean ThemHD(hoadondao hd,  ArrayList<chitiethoadon> chitiett){
        ArrayList<chitiethoadon> arrtemp=chitiett;
        Connection conn, conn2;
        PreparedStatement pst, pst1 = null;
        try{
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            pst = conn.prepareStatement("INSERT INTO tb_hoadon VALUES (?,?,?,?,?,?)");
            pst.setString(1,hd.getMahd());
            pst.setString(2,hd.getNgayhd());
            pst.setString(3,hd.getNoidunghd());
            pst.setInt(4,hd.getGiahd());
            pst.setString(5,hd.getMaNVdh());
            pst.setString(6,hd.getTenNVdh());
            pst.executeUpdate();
            
            conn2 = DriverManager.getConnection(server.databse, server.username, server.password);
            for(int i=0; i < arrtemp.size(); i++){
                pst1 = conn2.prepareStatement("INSERT INTO tb_chitiethoadon VALUES (?,?,?,?)");
                pst1.setString(1,arrtemp.get(i).getChitiethdid());
                pst1.setString(2,arrtemp.get(i).getMaspid());
                pst1.setInt(3,arrtemp.get(i).getSoluongchitiet());
                pst1.setInt(4,arrtemp.get(i).getGiachitiet());
                pst1.executeUpdate();
            }
            return true;
        }catch(SQLException e){
            return false;
        }
    }

    public static ArrayList<hoadondao> TimHoaDonDao(String tkhd, String tktennvhd){
        ArrayList<hoadondao> hdList=new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_hoadon WHERE maHD LIKE '%"+tkhd+"%' AND tenNV LIKE '%"+tktennvhd+"%'");
            while (rs.next()) {
                hoadondao hdtemp = new hoadondao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6));
                hdList.add(hdtemp);
            }
        } catch (SQLException e) {
            return null;
        } 
        return hdList;
    }
    
    public static ArrayList<hoadondao> Phantrangls(int pt){
        ArrayList<hoadondao> hdList=new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_hoadon LIMIT "+pt+",5");
            while (rs.next()) {
                hoadondao hdtemp = new hoadondao(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6));
                hdList.add(hdtemp);
            }
        } catch (SQLException e) {
        } 
       return hdList;
    }
    
    public static int Demsodong(){
        Connection conn = null;
        Statement st = null;
        int rowhoadon=0;
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = st.executeQuery("SELECT * FROM tb_hoadon");
            rs.last();// trả về dòng cuối cùng
            rowhoadon=rs.getRow();// trả về dòng hiện tại
            rs.beforeFirst();
        } catch (SQLException e) {
        } 
       return rowhoadon;
    }
    
    public String display(String mahd){
        Connection conn = null;
        Statement st = null;
        ArrayList<String[]> ssss=new ArrayList<>();
        String sq = "";
        String sq1 = "";
        int tongtong=0;
        String result="";
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT \n" +
                                            "`tb_hoadon`.`maHD`, \n" +
                                            "`tb_hoadon`.`ngayHD`, \n" +
                                            "`tb_hoadon`.`tenNV`, \n" +
                                            "`tb_sanpham`.`tenSP`, \n" +
                                            "`tb_chitiethoadon`.`chitietsoluongSP`, \n" +
                                            "`tb_sanpham`.`giaSP`\n" +
                                            "FROM `tb_chitiethoadon`, `tb_hoadon`, `tb_sanpham`\n" +
                                            "WHERE `tb_sanpham`.`maSP`=`tb_chitiethoadon`.`maSP` AND\n" +
                                            "`tb_hoadon`.`maHD`=`tb_chitiethoadon`.`maHDchitiet` AND\n" +
                                            "`tb_chitiethoadon`.`maHDchitiet`="+mahd+"");
            while (rs.next()) {
                String[] ttt = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),String.valueOf(rs.getInt(5)), String.valueOf(rs.getInt(6))};
                ssss.add(ttt);
            }
        } catch (SQLException e) {
        }
        for(int i=0; i<1; i++){
            sq=String.format("Mã hóa đơn:%s\nNgày mua:%s\nTên nhân viên:%s\n", ssss.get(i)[0],ssss.get(i)[1],ssss.get(i)[2]);
        }
        for(int i=0; i<ssss.size(); i++){
             sq1+=String.format("%s%10sx%15s\n", ssss.get(i)[3],ssss.get(i)[4],ssss.get(i)[5]);
             tongtong+=Integer.parseInt(ssss.get(i)[4])*Integer.parseInt(ssss.get(i)[5]);
        }
       result=sq+"\n"+sq1+"\nTổng tiền: "+df.format(tongtong);
       return result;
    }
//    public static void  main (String[] args){
//        chitiethoadon ctt=new chitiethoadon("000003", "27455", 1, 10000);
//        chitiethoadon ctt2=new chitiethoadon("000003", "62744", 1, 10000);
//        ArrayList<chitiethoadon> arr=new ArrayList<>();
//        arr.add(ctt);
//        arr.add(ctt2);
//        hoadondao hdtemp = new hoadondao("000003", "2021-05-08", "aaa", 20000, "23331234","Phạm Ngọc Quang");
//        boolean sss=ThemHD(hdtemp, arr);
//        System.out.println(arr.size());
//        System.out.print(sss);
//        CSDLQueryHD sss=new CSDLQueryHD();        
//      System.out.print(sss.display());  
//    }
}
