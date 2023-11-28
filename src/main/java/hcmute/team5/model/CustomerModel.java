package hcmute.team5.model;

import java.sql.Timestamp;

public class CustomerModel extends AbstractModel {
    private String MaKH;
    private String Ten;
    private Timestamp NgaySinh;
    private String SDT;
    private Float TongTienDaMua;

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        MaKH = maKH;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public Timestamp getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Timestamp ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Float getTongTienDaMua() {
        return TongTienDaMua;
    }

    public void setTongTienDaMua(Float tongTienDaMua) {
        TongTienDaMua = tongTienDaMua;
    }
}
