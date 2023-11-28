package hcmute.team5.model;

import java.sql.Timestamp;

public class StaffModel extends AbstractModel {
    private String MaNV;
    private String Ten;
    private Timestamp NgaySinh;
    private String DiaChi;
    private int sdt;
    private String MaChiNhanh;
    private String LoaiNhanVien;
    private float LuongCoBan;
    private float LuongTheoSoSanPham;

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public Timestamp getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Timestamp ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getMaChiNhanh() {
        return MaChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        MaChiNhanh = maChiNhanh;
    }

    public String getLoaiNhanVien() {
        return LoaiNhanVien;
    }

    public void setLoaiNhanVien(String loaiNhanVien) {
        LoaiNhanVien = loaiNhanVien;
    }

    public float getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(float luongCoBan) {
        LuongCoBan = luongCoBan;
    }

    public float getLuongTheoSoSanPham() {
        return LuongTheoSoSanPham;
    }

    public void setLuongTheoSoSanPham(float luongTheoSoSanPham) {
        LuongTheoSoSanPham = luongTheoSoSanPham;
    }
}
