package com.fullstack.springboot.model;

public class TransaksiDetail {
    private String idDetail;
    private String idBan;
    private double hargaSatuanBan;
    private String idJasa;
    private double hargaSatuanJasa;
    private int qty;
    private double hargaTotalBan;
    private double hargaTotalJasa;


    public TransaksiDetail(String idDetail, String idBan, double hargaSatuanBan, String idJasa, double hargaSatuanJasa, int qty, double hargaTotalBan, double hargaTotalJasa) {
        this.idDetail = idDetail;
        this.idBan = idBan;
        this.hargaSatuanBan = hargaSatuanBan;
        this.idJasa = idJasa;
        this.hargaSatuanJasa = hargaSatuanJasa;
        this.qty = qty;
        this.hargaTotalBan = hargaTotalBan;
        this.hargaTotalJasa = hargaTotalJasa;
    }

    public String getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(String idDetail) {
        this.idDetail = idDetail;
    }

    public String getIdBan() {
        return idBan;
    }

    public void setIdBan(String idBan) {
        this.idBan = idBan;
    }

    public double getHargaSatuanBan() {
        return hargaSatuanBan;
    }

    public void setHargaSatuanBan(double hargaSatuanBan) {
        this.hargaSatuanBan = hargaSatuanBan;
    }

    public String getIdJasa() {
        return idJasa;
    }

    public void setIdJasa(String idJasa) {
        this.idJasa = idJasa;
    }

    public double getHargaSatuanJasa() {
        return hargaSatuanJasa;
    }

    public void setHargaSatuanJasa(double hargaSatuanJasa) {
        this.hargaSatuanJasa = hargaSatuanJasa;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getHargaTotalBan() {
        return hargaTotalBan;
    }

    public void setHargaTotalBan(double hargaTotalBan) {
        this.hargaTotalBan = hargaTotalBan;
    }

    public double getHargaTotalJasa() {
        return hargaTotalJasa;
    }

    public void setHargaTotalJasa(double hargaTotalJasa) {
        this.hargaTotalJasa = hargaTotalJasa;
    }
}
