package com.fullstack.springboot.model;

public class Teknisi {
    private String idTeknisi;
    private String namaTeknisi;
    private String alamatTeknisi;
    private int telpTeknisi;
    private String bidangJasa;

    public Teknisi (){}

    public Teknisi(String idTeknisi, String namaTeknisi, String alamatTeknisi, int telpTeknisi, String bidangJasa) {
        this.idTeknisi = idTeknisi;
        this.namaTeknisi = namaTeknisi;
        this.alamatTeknisi = alamatTeknisi;
        this.telpTeknisi = telpTeknisi;
        this.bidangJasa = bidangJasa;
    }

    public String getIdTeknisi() {
        return idTeknisi;
    }

    public void setIdTeknisi(String idTeknisi) {
        this.idTeknisi = idTeknisi;
    }

    public String getNamaTeknisi() {
        return namaTeknisi;
    }

    public void setNamaTeknisi(String namaTeknisi) {
        this.namaTeknisi = namaTeknisi;
    }

    public String getAlamatTeknisi() {
        return alamatTeknisi;
    }

    public void setAlamatTeknisi(String alamatTeknisi) {
        this.alamatTeknisi = alamatTeknisi;
    }

    public int getTelpTeknisi() {
        return telpTeknisi;
    }

    public void setTelpTeknisi(int telpTeknisi) {
        this.telpTeknisi = telpTeknisi;
    }

    public String getBidangJasa() {
        return bidangJasa;
    }

    public void setBidangJasa(String bidangJasa) {
        this.bidangJasa = bidangJasa;
    }
}
