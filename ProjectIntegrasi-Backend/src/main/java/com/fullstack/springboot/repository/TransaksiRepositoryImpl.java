package com.fullstack.springboot.repository;

import com.fullstack.springboot.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("transaksiRepository")
public class TransaksiRepositoryImpl implements TransaksiRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Transaksi> findAll() {
        return jdbcTemplate.query("select * from transaksi",
                (rs, rowNum) ->
                        new Transaksi(
                                rs.getString("idTransaksi"),
                                rs.getDate("tglTransaksi"),
                                rs.getString("idCustomer"),
                                rs.getString("idTeknisi"),
                                rs.getDouble("totalBayar")
                        )
        );
    }

    @Override
    public List<TransaksiResponse> findAllTransaksi() {
        return null;

    }

    @Override
    public TransaksiResponse findById(String idTransaksi) {
        TransaksiResponse transaksiResponse;
        transaksiResponse = jdbcTemplate.queryForObject(
                "select idTransaksi, tglTransaksi, totalBayar from transaksi where idTransaksi='"+idTransaksi+"'",
                (rs, rowNum) ->
                        new TransaksiResponse(
                                rs.getString("idTransaksi"),
                                rs.getDate("tglTransaksi"),
                                rs.getDouble("totalBayar")
                        )
        );

            transaksiResponse.setTeknisi(jdbcTemplate.queryForObject("select b.idTeknisi, b.namaTeknisi, b.alamat, b.noTelp, b.bidang from " +
                            "transaksi a left join teknisi b on a.idTeknisi = b.idTeknisi where a.idTransaksi='" + idTransaksi + "'",
                    (rs, rowNum) ->
                            new Teknisi(
                                    rs.getString("idTeknisi"),
                                    rs.getString("namaTeknisi"),
                                    rs.getString("alamat"),
                                    rs.getInt("noTelp"),
                                    rs.getString("bidang")
                            ))
            );

            transaksiResponse.setCustomer(jdbcTemplate.query("select b.idCustomer, b.namaCustomer, b.alamat, b.noTelepon " +
                            "from transaksi a left join customer b on a.idCustomer = b.idCustomer " +
                            "where a.idTransaksi = '" + idTransaksi + "'",
                    (rs, rowNum) ->
                            new Customer(
                                    rs.getString("idCustomer"),
                                    rs.getString("namaCustomer"),
                                    rs.getString("alamat"),
                                    rs.getLong("noTelepon")
                            )).get(0)
            );

        transaksiResponse.setDetails(
                jdbcTemplate.query(
                        "select idDetail, idBan, hargaSatuanBan, idJasa, hargaSatuanJasa, quantity, totalHargaBan, totalHargaJasa from detailtransaksi where idTransaksi='"+idTransaksi+"'",
                        (rs, rowNum) ->
                                new TransaksiDetail(
                                        rs.getString("idDetail"),
                                        rs.getString("idBan"),
                                        rs.getDouble("hargaSatuanBan"),
                                        rs.getString("idjasa"),
                                        rs.getDouble("hargaSatuanJasa"),
                                        rs.getInt("quantity"),
                                        rs.getDouble("totalHargaBan"),
                                        rs.getDouble("totalHargaJasa")
                                )
                ));

        return transaksiResponse ;
    }

    @Override
    public void saveTransaksi(Transaksi transaksi) {
        UUID id = UUID.randomUUID();
        String idTransaksi = "Trans-" + id;
        jdbcTemplate.update("INSERT INTO transaksi VALUES (?,?,?,?,?)",
                idTransaksi,
                java.time.LocalDate.now(),
                transaksi.getIdCustomer(),
                transaksi.getIdTeknisi(),
                transaksi.getTotalBayar()
        );

        for (TransaksiDetail detail : transaksi.getDetails()) {
            UUID no = UUID.randomUUID();
            String idDetail = "Detail-" + no;
            jdbcTemplate.update("insert into detailTransaksi VALUES (?,?,?,?,?,?,?,?,?)",
                    idDetail,
                    idTransaksi,
                    detail.getIdBan(),
                    detail.getHargaSatuanBan(),
                    detail.getIdJasa(),
                    detail.getHargaSatuanJasa(),
                    detail.getQty(),
                    detail.getHargaTotalBan(),
                    detail.getHargaTotalJasa()
                    );
        }
    }

    @Override
    public void updateTransaksi(Transaksi transaksi) {

    }

    @Override
    public List<Transaksi> findAllWithPaging(int page, int limit) {
        return null;
    }
}