package Bai1.Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bai1.ConnectDB;
import Bai1.model.LoaiSP;
import Bai1.model.SanPham;

public class ProductController {
	public List<SanPham> getListSPFromDB() {
		try {
			// connnect to database
			Connection conn = ConnectDB.getConnection();
			// get data from table 'sanpham'
			String sql = "SELECT id, TenSP, NhaSanXuat, MaLoaiSP FROM sanpham";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			List<SanPham> listSP = new ArrayList<SanPham>();
			while (rs.next()) {
				SanPham sanpham = new SanPham(rs.getInt("id"), rs.getString("TenSP"), rs.getString("NhaSanXuat"),
						rs.getInt("MaLoaiSP"));
				listSP.add(sanpham);
			}

			return listSP;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public List<LoaiSP> getListLoaiSPFromDB() {
		try {
			// connnect to database
			Connection conn = ConnectDB.getConnection();
			// get data from table 'loaisanpham'
			String sql = "SELECT id, TenLoaiSP FROM loaisanpham";
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			List<LoaiSP> listLoaiSP = new ArrayList<LoaiSP>();
			while (rs.next()) {
				LoaiSP loaisp = new LoaiSP(rs.getInt("id"), rs.getString("TenLoaiSP"));
				listLoaiSP.add(loaisp);
			}

			return listLoaiSP;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	 public void createNewCategoryProduct(LoaiSP loai) {
	        String sqlCreateLoaiSP = "INSERT INTO loaisanpham VALUES(?, ?)";
	        try {

	            Connection connection = ConnectDB.getConnection();

	            PreparedStatement preparedStatement1 = connection.prepareStatement(sqlCreateLoaiSP);
	            preparedStatement1.setInt(1, loai.getMaSP());
	            preparedStatement1.setString(2, loai.getTenLoaiSP());

	            preparedStatement1.execute();
	           
	            preparedStatement1.close();
	          
	            connection.close();
	           

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	            
	        }
	    }
}
