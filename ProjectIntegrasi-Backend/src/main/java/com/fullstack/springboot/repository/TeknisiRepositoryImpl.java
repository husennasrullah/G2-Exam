package com.fullstack.springboot.repository;

import com.fullstack.springboot.model.Teknisi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("teknisiRepository")
public class TeknisiRepositoryImpl implements TeknisiRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createTeknisi(Teknisi teknisi) {
        UUID id = UUID.randomUUID();
        String idtek = "Tech-"+id;
        jdbcTemplate.update("INSERT INTO teknisi VALUES (?,?,?,?,?)",
                //teknisi.getIdTeknisi(),
                idtek,
                teknisi.getNamaTeknisi(),
                teknisi.getAlamatTeknisi(),
                teknisi.getTelpTeknisi(),
                teknisi.getBidangJasa()
        );
    }

    @Override
    public void updateTeknisi(Teknisi teknisi) {
        jdbcTemplate.update("update teknisi set namaTeknisi=?, alamat=?, noTelp=?, bidang=? where idTeknisi=?",
                teknisi.getNamaTeknisi(),
                teknisi.getAlamatTeknisi(),
                teknisi.getTelpTeknisi(),
                teknisi.getBidangJasa(),
                teknisi.getIdTeknisi()
        );
    }

    @Override
    public List<Teknisi> findAllTeknisi() {
        return jdbcTemplate.query("select * from teknisi",
                (rs, rowNum) ->
                        new Teknisi(
                                rs.getString("idTeknisi"),
                                rs.getString("namaTeknisi"),
                                rs.getString("alamat"),
                                rs.getInt("noTelp"),
                                rs.getString("bidang")
                        )
        );
    }

    @Override
    public List<Teknisi> findAllWithPaging(int page, int limit) {
        int numPages;
        numPages = jdbcTemplate.query("SELECT COUNT(*) as count FROM teknisi",
                (rs, rowNum) -> rs.getInt("count")).get(0);
        // validate page
        if (page < 1) page = 1;
        if (page > numPages) page = numPages;

        int start = (page - 1) * limit;
        List<Teknisi> daftarTeknisi =
                jdbcTemplate.query("SELECT * FROM teknisi LIMIT " + start + "," + limit + ";",
                        (rs, rowNum) ->
                                new Teknisi(
                                        rs.getString("idTeknisi"),
                                        rs.getString("namaTeknisi"),
                                        rs.getString("alamat"),
                                        rs.getInt("noTelp"),
                                        rs.getString("bidang")
                                )
                );
        return daftarTeknisi;
    }

    @Override
    public Teknisi findById(String idTeknisi) {
        return jdbcTemplate.queryForObject("select * from teknisi where idTeknisi = ?",
                (rs, rowNum) ->
                        new Teknisi(
                                rs.getString("idTeknisi"),
                                rs.getString("namaTeknisi"),
                                rs.getString("alamat"),
                                rs.getInt("noTelp"),
                                rs.getString("bidang")
                        ), idTeknisi
        );
    }

    @Override
    public List<Teknisi> findByName(String namaTeknisi) {
        return jdbcTemplate.query("select * from teknisi where namaTeknisi like ?",
                new Object[]{"%" + namaTeknisi},
                (rs, rowNum) ->
                        (new Teknisi(
                                rs.getString("idTeknisi"),
                                rs.getString("namaTeknisi"),
                                rs.getString("alamat"),
                                rs.getInt("noTelp"),
                                rs.getString("bidang")
                        ))
        );
    }

    @Override
    public void deleteTeknisiById(String idTeknisi) {
        jdbcTemplate.update("delete from teknisi where idTeknisi = ?", idTeknisi);
    }

    @Override
    public void deleteAllCustomer() {
        jdbcTemplate.update("delete from teknisi");

    }

    @Override
    public boolean isTeknisiExist(Teknisi teknisi) {
        return false;
    }
}
