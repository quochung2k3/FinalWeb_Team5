package hcmute.team5.model;

import java.sql.Timestamp;

public class CustomerModel {
    private String maKh;
    private String ten;
    private String ngaySinh;
    private String sdt;
    private float tongTienDaMua;

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