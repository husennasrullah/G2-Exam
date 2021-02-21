package com.fullstack.springboot.model;

public class Customer {
    private String idCustomer;
    private String namaCustomer;
    private String alamat;
    private long noTelepon;
    private String jenisMobil;

    public Customer (){}

    public Customer(String idCustomer, String namaCustomer, String alamat, long noTelepon) {
        this.idCustomer = idCustomer;
        this.namaCustomer = namaCustomer;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
    }

    public Customer(String idCustomer, String namaCustomer, String alamat, long noTelepon, String jenisMobil) {
        this.idCustomer = idCustomer;
        this.namaCustomer = namaCustomer;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.jenisMobil = jenisMobil;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public long getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(long noTelepon) {
        this.noTelepon = noTelepon;
    }

    public String getJenisMobil() {
        return jenisMobil;
    }

    public void setJenisMobil(String jenisMobil) {
        this.jenisMobil = jenisMobil;
    }
}
