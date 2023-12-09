package hcmute.team5.model;

public class ProductModel extends AbstractModel {
    private String masp;
    private String tensp;
    private String maloaisp;
    private String image;
    private String mancc;
    private float gia;
    private String machinhanh;
    private String trangthai;
    private String description;

    public String getMaSP() {
        return masp;
    }
    public void setMaSP(String maSP) {
        masp = maSP;
    }

    public String getTenSP() {
        return tensp;
    }
    public void setTenSP(String tenSP) {
        tensp = tenSP;
    }

    public String getMaLoaiSP() {
        return maloaisp;
    }
    public void setMaLoaiSP(String maLoaiSP) {
        maloaisp = maLoaiSP;
    }

    public float getGia() {
        return gia;
    }
    public void setGia(float gia) {
        this.gia = gia;
    }

    public String gettrangThai() {
        return trangthai;
    }
    public void setTrangThai(String trangThai) {
        trangthai = trangThai;
    }

    public String getMachinhanh() {return machinhanh;}
    public void setMachinhanh(String maChiNhanh){machinhanh = maChiNhanh;}

    public String getMancc(){return  mancc;}
    public void setMancc(String maNcc){mancc = maNcc;}
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



    
}
