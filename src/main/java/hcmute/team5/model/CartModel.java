package hcmute.team5.model;

public class CartModel extends ProductModel {
    private String username;
    private int maSanPham;
    private int soLuong;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
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
