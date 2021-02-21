package com.fullstack.springboot.model;

public class Jasa {
    private String idJasa;
    private String jenisJasa;
    private double hargaSatuan;
    private int lamaPengerjaan;

    public Jasa(){}

    public Jasa(String idJasa, String jenisJasa, double hargaSatuan, int lamaPengerjaan) {
        this.idJasa = idJasa;
        this.jenisJasa = jenisJasa;
        this.hargaSatuan = hargaSatuan;
        this.lamaPengerjaan = lamaPengerjaan;
    }

    public String getIdJasa() {
        return idJasa;
    }

    public void setIdJasa(String idJasa) {
        this.idJasa = idJasa;
    }

    public String getJenisJasa() {
        return jenisJasa;
    }

    public void setJenisJasa(String jenisJasa) {
        this.jenisJasa = jenisJasa;
    }

    public double getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(double hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public int getLamaPengerjaan() {
        return lamaPengerjaan;
    }

    public void setLamaPengerjaan(int lamaPengerjaan) {
        this.lamaPengerjaan = lamaPengerjaan;
    }
}
