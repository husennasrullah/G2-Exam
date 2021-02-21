package com.fullstack.springboot.model;

import java.util.Date;
import java.util.List;

public class Transaksi {
    private String idTransaksi;
    private Date tgltransaksi;
    private String idCustomer;
    private String idTeknisi;
    private double totalBayar;
    List<TransaksiDetail> details;

    public Transaksi(String idTransaksi, Date tgltransaksi, String idCustomer, String idTeknisi, double totalBayar) {
        this.idTransaksi = idTransaksi;
        this.tgltransaksi = tgltransaksi;
        this.idCustomer = idCustomer;
        this.idTeknisi = idTeknisi;
        this.totalBayar = totalBayar;
    }

    public List<TransaksiDetail> getDetails() {
        return details;
    }

    public void setDetails(List<TransaksiDetail> details) {
        this.details = details;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Date getTgltransaksi() {
        return tgltransaksi;
    }

    public void setTgltransaksi(Date tgltransaksi) {
        this.tgltransaksi = tgltransaksi;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdTeknisi() {
        return idTeknisi;
    }

    public void setIdTeknisi(String idTeknisi) {
        this.idTeknisi = idTeknisi;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }
}
