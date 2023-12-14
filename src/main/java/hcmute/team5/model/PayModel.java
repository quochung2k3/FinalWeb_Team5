package hcmute.team5.model;

public class PayModel extends VoucherModel {
    private String MaNV;
    private String MaKH;
    private int MaVC;
    private String MaHD;
    private String TrangThai;

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    @Override
    public int getMaVC() {
        return MaVC;
    }

    @Override
    public void setMaVC(int maVC) {
        MaVC = maVC;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String maHD) {
        MaHD = maHD;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
