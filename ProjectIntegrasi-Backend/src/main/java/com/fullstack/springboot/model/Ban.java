package com.fullstack.springboot.model;

public class Ban {
    private String idBan;
    private String merkBan;
    private String jenisBan;
    private double hargaSatuan;

    public Ban(String idBan, String merkBan, String jenisBan, double hargaSatuan) {
        this.idBan = idBan;
        this.merkBan = merkBan;
        this.jenisBan = jenisBan;
        this.hargaSatuan = hargaSatuan;
    }

    public String getIdBan() {
        return idBan;
    }

    public void setIdBan(String idBan) {
        this.idBan = idBan;
    }

    public String getMerkBan() {
        return merkBan;
    }

    public void setMerkBan(String merkBan) {
        this.merkBan = merkBan;
    }

    public String getJenisBan() {
        return jenisBan;
    }

    public void setJenisBan(String jenisBan) {
        this.jenisBan = jenisBan;
    }

    public double getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }
}
