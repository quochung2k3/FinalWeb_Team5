package hcmute.team5.model;

public class PayModel extends AbstractModel {
    private String MaNV;
    private String MaKH;
    private String MaVC;
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

    public String getMaVC() {
        return MaVC;
    }

    public void setMaVC(String maVC) {
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
