package Bai1;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Bai1.Control.ProductController;
import Bai1.model.LoaiSP;
import Bai1.model.SanPham;

public class Main extends JFrame {
	public static Scanner scanner = new Scanner(System.in);
	public static ProductController productController = new ProductController();
	private JTable sanpham;
	private DefaultTableModel model;
	public Main() {
		sanpham = new JTable();
		sanpham.setPreferredSize(new Dimension(500, 500));
		this.add(new JScrollPane(sanpham));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		loadDataIntoJTable();
	}
	private void loadDataIntoJTable() {// đưa column name và data row lên JTable
		model = new DefaultTableModel();
		Vector column = new Vector();// Set Column Title
		column.add("Ma SP");
		column.add("Ten SP");
		column.add("Nha san xuat");
		column.add("Ma loai SP");
		model.setColumnIdentifiers(column);
		List<SanPham> list = productController.getListSPFromDB();
		for (int i = 0; i < list.size(); i++) {
			SanPham sp = (SanPham) list.get(i);
			Vector row = new Vector();
			row.add(sp.getMaSP());
			row.add(sp.getTenSP());
			row.add(sp.getNhaSanXuat());
			row.add(sp.getMaLoaiSP());
			model.addRow(row);
		}
		sanpham.setModel(model);
	}

	public static void main(String[] args) {
		List<SanPham> listSP = productController.getListSPFromDB();
		List<LoaiSP> listLoaiSp = productController.getListLoaiSPFromDB();
		int choice;

		while (true) {
			System.out.println("1. Hiện thị danh sách sản phẩm.");
			System.out.println("2. Thêm loaij sản phẩm.");
			System.out.println("0. Thoát.");

			System.out.print("Nhập lựa chọn: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.printf("|%-5s | %-20s | %-20s | %-5s |%n", "Ma SP", "Ten SP", "Nha san xuat", "Ma loai SP");
				displayListProduct(listSP);
				new Main();
				break;
			case 2:
				int maLoaiSP;
				String tenLoaiSP;

				System.out.print("Nhập mã loại sản phẩm: ");
				maLoaiSP = scanner.nextInt();

				System.out.print("Nhập tên loai sản phẩm: ");
				scanner.nextLine();
				tenLoaiSP = scanner.nextLine();

				LoaiSP loaisp = new LoaiSP(maLoaiSP, tenLoaiSP);
				listLoaiSp.add(loaisp);
				try {
					productController.createNewCategoryProduct(loaisp);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				System.out.println("Thêm thành công");
				break;
			case 0:
				System.exit(0);
				break;
			}
		}

	}

	public static void displayListProduct(List<SanPham> list) {
		for (SanPham sanPham : list) {
			System.out.printf("|%-5s | %-20s | %-20s | %-5s |%n", sanPham.getMaSP(), sanPham.getTenSP(),
					sanPham.getNhaSanXuat(), sanPham.getMaLoaiSP());
		}
	}
}
