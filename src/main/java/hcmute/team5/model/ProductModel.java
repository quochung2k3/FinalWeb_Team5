package hcmute.team5.model;

public class ProductModel extends AbstractModel {
    private String maSp;
    private String tenSp;
    private String maLoaisp;
    private String image;
    private String maNcc;
    private int gia;
    private String trangThai;
    private String desCription;
    private String maChiNhanh;
    public String getMaSP() {
        return maSp;
    }

    public void setMaSP(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSP() {
        return tenSp;
    }

    public void setTenSP(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getMaLoaiSP() {
        return maLoaisp;
    }

    public void setMaLoaiSP(String maLoaiSp) {
        this.maLoaisp = maLoaiSp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getMaNcc(){return maNcc;}
    public void setMaNcc(String maNcc){this.maNcc = maNcc;}
    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getDescription() {
        return desCription;
    }
    public void setDescription(String desCription) {
        this.desCription = desCription;
    }

}
