package hcmute.team5.model;

public class ProductModel extends AbstractModel {
    private String MaSP;
    private String TenSP;
    private String MaLoaiSP;
    private float Gia;
    private String TrangThai;

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getMaLoaiSP() {
        return MaLoaiSP;
    }

    public void setMaLoaiSP(String maLoaiSP) {
        MaLoaiSP = maLoaiSP;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float gia) {
        Gia = gia;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }
}
