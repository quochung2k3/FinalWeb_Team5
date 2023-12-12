package hcmute.team5.model;

public class CartModel extends ProductModel {
    private String username;
    private String maSanPham;
    private int soLuong;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    @Override
    public int getSoLuong() {
        return soLuong;
    }

    @Override
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
