package hcmute.team5.model;

import java.sql.Timestamp;

public class VoucherModel extends AbstractModel {
    private String MaVC;
    private String TenVC;
    private float PhanTramGiam;
    private Timestamp NgayBatDau;
    private Timestamp NgayKetThuc;
    private int SoLuong;

    public String getMaVC() {
        return MaVC;
    }

    public void setMaVC(String maVC) {
        MaVC = maVC;
    }

    public String getTenVC() {
        return TenVC;
    }

    public void setTenVC(String tenVC) {
        TenVC = tenVC;
    }

    public float getPhanTramGiam() {
        return PhanTramGiam;
    }

    public void setPhanTramGiam(float phanTramGiam) {
        PhanTramGiam = phanTramGiam;
    }

    public Timestamp getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Timestamp ngayBatDau) {
        NgayBatDau = ngayBatDau;
    }

    public Timestamp getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Timestamp ngayKetThuc) {
        NgayKetThuc = ngayKetThuc;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
