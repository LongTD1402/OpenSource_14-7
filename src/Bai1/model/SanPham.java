package Bai1.model;

public class SanPham {
	
	private int maSP;
	private String tenSP;
	private String nhaSanXuat;
	private int maLoaiSP;
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getNhaSanXuat() {
		return nhaSanXuat;
	}
	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}
	public int getMaLoaiSP() {
		return maLoaiSP;
	}
	public void setMaLoaiSP(int maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}
	public SanPham() {
		super();
		
	}
	public SanPham(int maSP, String tenSP, String nhaSanXuat, int maLoaiSP) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.nhaSanXuat = nhaSanXuat;
		this.maLoaiSP = maLoaiSP;
	}
	
	
}
