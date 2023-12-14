package hcmute.team5.model;

public class SupplierModel extends ProductModel {
    private String maNcc;
    private String tenNcc;

    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    public String getMaNcc() {
        return maNcc;
    }

    public String getTenNcc() {
        return tenNcc;
    }

    public void setTenNcc(String tenNcc) {
        this.tenNcc = tenNcc;
    }
}
