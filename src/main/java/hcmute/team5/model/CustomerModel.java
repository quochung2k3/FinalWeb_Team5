package hcmute.team5.model;

import java.sql.Timestamp;

public class CustomerModel {
    private String maKh;
    private String ten;
    private String ngaySinh;
    private String sdt;
    private String username;
    private float tongTienDaMua;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public float getTongTienDaMua() {
        return tongTienDaMua;
    }

    public void setTongTienDaMua(float tongTienDaMua) {
        this.tongTienDaMua = tongTienDaMua;
    }
}