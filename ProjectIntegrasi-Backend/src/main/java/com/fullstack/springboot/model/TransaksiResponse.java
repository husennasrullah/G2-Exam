package com.fullstack.springboot.model;

import java.util.Date;
import java.util.List;

public class TransaksiResponse {
    private String idTransaksi;
    private Date tgltransaksi;
    private Customer customer;
    private Teknisi teknisi;
    private double totalBayar;
    List<TransaksiDetail> details;

    public TransaksiResponse (){}

    public TransaksiResponse(String idTransaksi, Date tgltransaksi, double totalBayar) {
        this.idTransaksi = idTransaksi;
        this.tgltransaksi = tgltransaksi;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Teknisi getTeknisi() {
        return teknisi;
    }

    public void setTeknisi(Teknisi teknisi) {
        this.teknisi = teknisi;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }
}
