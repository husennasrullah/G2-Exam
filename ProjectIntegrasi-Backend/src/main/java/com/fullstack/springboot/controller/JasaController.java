package com.fullstack.springboot.controller;

import com.fullstack.springboot.model.Jasa;
import com.fullstack.springboot.service.JasaService;
import com.fullstack.springboot.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class JasaController {

    public static final Logger logger = LoggerFactory.getLogger(JasaController.class);

    @Autowired
    JasaService jasaService;

    // end-point untuk mengambil seluruh data
    //---------------------------------------------------------
    @RequestMapping(value = "/jasa/", method = RequestMethod.GET)
    public ResponseEntity<List<Jasa>> listAllJasa() {
        List<Jasa> dataJasa = jasaService.findAllJasa();
        if (dataJasa.isEmpty()) {
            return new ResponseEntity<>(dataJasa, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dataJasa, HttpStatus.OK);
    }

    // end-point untuk mengambil seluruh data dengan paging
    //---------------------------------------------------------
    @RequestMapping(value = "/jasa/paging/", method = RequestMethod.GET)
    public ResponseEntity<?>getJasaWithPaging(@RequestParam int page, @RequestParam int limit){
        List<Jasa> daftarJasa = jasaService.findAllWithPaging(page, limit);
        if(daftarJasa.isEmpty()){
            return new ResponseEntity<>(daftarJasa,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(daftarJasa,HttpStatus.OK);
        }
    }

    // end-point untuk mengambil single data customer
    //---------------------------------------------------------
    @RequestMapping(value = "/jasa/{idJasa}", method = RequestMethod.GET)
    public ResponseEntity<?> getJasaById(@PathVariable("idJasa") String idJasa) {
        logger.info("mengambil data jasa dengan id {}", idJasa);
        Jasa jasa = jasaService.findById(idJasa);
        if (jasa == null) {
            logger.error("data jasa dengan id {} tidak ditemukan.", idJasa);
            return new ResponseEntity<>(new CustomErrorType("data Jasa dengan id " + idJasa + " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jasa, HttpStatus.OK);
    }

    // end-point untuk mengambil single data customer (by name)
    //---------------------------------------------------------
    @RequestMapping(value = "/jasa/jenis/{jenisJasa}", method = RequestMethod.GET)
    public ResponseEntity<?> getJasaByName(@PathVariable("jenisJasa") String jenisjasa) {
        logger.info("mengambil data jasa dengan merk {}", jenisjasa);
        Jasa jasa= jasaService.findByName(jenisjasa);
        if (jasa == null) {
            logger.error("data jasa dengan nama {} tidak ditemukan.", jenisjasa);
            return new ResponseEntity<>(new CustomErrorType("data jasa dengan nama " + jenisjasa+ " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(jasa, HttpStatus.OK);
    }

    //end-point untuk menambah data jasa
    //------------------------------------
    @RequestMapping(value = "/jasa/", method = RequestMethod.POST)
    public ResponseEntity<?> createJasa(@RequestBody Jasa jasa) {
        logger.info("membuat data jasa : {}", jasa);

        if (jasaService.isJasaExist(jasa)) {
            logger.error("tidak bisa memuat data, data jasa dengan nama {} sudah ada", jasa.getJenisJasa());
            return new ResponseEntity<>(new CustomErrorType("tidak bisa membuat data jasa dengan merk"+
                    jasa.getJenisJasa() + " sudah ada."), HttpStatus.CONFLICT);
        }
        jasaService.createJasa(jasa);
        return new ResponseEntity<>(jasa, HttpStatus.CREATED);
    }

    // end-point untuk update data jasa
    //---------------------------------------------------------
    @RequestMapping(value = "/jasa/{idJasa}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateJasa(@PathVariable("idJasa") String idJasa, @RequestBody Jasa jasa) {
        logger.info("update data Jasa dengan id {}", idJasa);

        Jasa dataJasa = jasaService.findById(idJasa);
        if (dataJasa == null) {
            logger.error("tidak bisa update. Jasa dengan id {} tidak ditemukan.", idJasa);
            return new ResponseEntity<>(new CustomErrorType("tidak bisa update. Jasa dengan id " + idJasa +
                    " tidak ditemukan."),
                    HttpStatus.NOT_FOUND);
        }
        dataJasa.setJenisJasa(jasa.getJenisJasa());
        dataJasa.setHargaSatuan(jasa.getHargaSatuan());
        dataJasa.setLamaPengerjaan(jasa.getLamaPengerjaan());

        jasaService.updateJasa(dataJasa);

        return new ResponseEntity<>(dataJasa, HttpStatus.OK);
    }

    // end-point untuk delete data teknisi
    //---------------------------------------------------------
    @RequestMapping(value = "/jasa/{idJasa}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteJasa(@PathVariable("idJasa") String idJasa) {
        logger.info("memuat dan menghapus Jasa dengan id {}", idJasa);

        Jasa jasa = jasaService.findById(idJasa);
        if (jasa == null) {
            logger.error("tidak bisa menghapus!! data jasa dengan id {} tidak ditemukan.", idJasa);
            return new ResponseEntity<>(new CustomErrorType("tidak bisa menghapus data, jasa dengan id " + idJasa + " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }

        jasaService.deleteJasaById(idJasa);
        return new ResponseEntity<Jasa>(HttpStatus.NO_CONTENT);
    }

}
