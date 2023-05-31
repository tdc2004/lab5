package com.chinhtd.lab5;

public class DanhSach {
    private String coSo;
    private String name;
    private String diaChi;

    public DanhSach(String coSo, String name, String diaChi) {
        this.coSo = coSo;
        this.name = name;
        this.diaChi = diaChi;
    }

    public String getCoSo() {
        return coSo;
    }

    public void setCoSo(String coSo) {
        this.coSo = coSo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
