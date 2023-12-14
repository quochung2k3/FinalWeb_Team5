package hcmute.team5.model;

public class VoucherModel extends AbstractModel {
    private int MaVC;
    private String TenVC;
    private float PhanTramGiam;
    private String NgayBatDau;
    private String NgayKetThuc;
    private int SoLuong;

    public int getMaVC() {
        return MaVC;
    }

    public void setMaVC(int maVC) {
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

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        NgayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        NgayKetThuc = ngayKetThuc;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }
}
