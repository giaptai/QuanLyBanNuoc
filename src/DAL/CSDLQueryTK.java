package DAL;

import java.sql.*;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class CSDLQueryTK {
     public static JFreeChart ThongKeDoanhThu() {
        ArrayList<Integer> tongdt = new ArrayList<>();
        ArrayList<String> ngaydt = new ArrayList<>();
        Connection conn = null;
        PreparedStatement st = null;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createLineChart("THỐNG KÊ DOANH THU", "Ngày-Tháng", "VNĐ", dataset, PlotOrientation.VERTICAL, true, true, false);
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.prepareStatement("SELECT ngayHD, SUM(tonggiaHD) FROM tb_hoadon GROUP BY ngayHD");
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                ngaydt.add(rs.getString(1));
                tongdt.add(rs.getInt(2));
            }
            for(int i=0;i<ngaydt.size(); i++){
                dataset.addValue(tongdt.get(i), "VNĐ", ngaydt.get(i));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi,lỗi thống kê 1");
        }
        return chart;
    }
     
    public static JFreeChart ThongKeHoaDonNV() {
        ArrayList<String> tennv = new ArrayList<>();
        ArrayList<Integer> sohd = new ArrayList<>();
        Connection conn = null;
        PreparedStatement st = null;
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        JFreeChart chart1 = ChartFactory.createBarChart("THỐNG KÊ SỐ ĐƠN CỦA TỪNG NHÂN VIÊN", "Họ và Tên", "Số đơn", dataset1, PlotOrientation.VERTICAL, true, true, false);
        try {
            conn = DriverManager.getConnection(server.databse, server.username, server.password);
            st = conn.prepareStatement("SELECT tenNV, COUNT(maHD) FROM tb_hoadon GROUP BY tenNV");
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                tennv.add(rs.getString(1));
                sohd.add(rs.getInt(2));
            }
            for(int i=0;i<tennv.size(); i++){
                dataset1.addValue(sohd.get(i), "Số lượng", tennv.get(i));
//                System.out.println(sohd.get(i)+"   "+ tennv.get(i));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi, lỗi thống kê 2");
        }
        return chart1;
    }
//    public static void main(String[] args){
//        ThongKeHoaDonNV();
//    }
}
