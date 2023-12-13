package hcmute.team5.model;

import java.sql.Timestamp;

public class BillModel extends ProductModel {
    private String MaHD;
    private int maChiNhanh;
    private Timestamp NgayIn;
    private String MaKH;
    private float TongTien;
    private float TienDaNhan;
    private float TienThoi;

    @Override
    public int getMaChiNhanh() {
        return maChiNhanh;
    }

    @Override
    public void setMaChiNhanh(int maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public Timestamp getNgayIn() {
        return NgayIn;
    }

    public void setNgayIn(Timestamp ngayIn) {
        NgayIn = ngayIn;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float tongTien) {
        TongTien = tongTien;
    }

    public float getTienDaNhan() {
        return TienDaNhan;
    }

    public void setTienDaNhan(float tienDaNhan) {
        TienDaNhan = tienDaNhan;
    }

    public float getTienThoi() {
        return TienThoi;
    }

    public void setTienThoi(float tienThoi) {
        TienThoi = tienThoi;
    }
}
