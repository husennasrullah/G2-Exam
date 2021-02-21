package com.fullstack.springboot.controller;

import com.fullstack.springboot.model.Teknisi;
import com.fullstack.springboot.service.TeknisiService;
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
@RequestMapping("/api")
public class TeknisiController {


    public static final Logger logger = LoggerFactory.getLogger(TeknisiController.class);

    @Autowired
    TeknisiService teknisiService;

    // end-point untuk mengambil seluruh data teknisi
    //---------------------------------------------------------
    @RequestMapping(value = "/teknisi/", method = RequestMethod.GET)
    public ResponseEntity<List<Teknisi>> listAllTeknisi() {
        List<Teknisi> dataTeknisi = teknisiService.findAllTeknisi();
        if (dataTeknisi.isEmpty()) {
            return new ResponseEntity<>(dataTeknisi, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dataTeknisi, HttpStatus.OK);
    }

    // end-point untuk mengambil seluruh data dengan paging
    //---------------------------------------------------------
    @RequestMapping(value = "/teknisi/paging/", method = RequestMethod.GET)
    public ResponseEntity<?>getTeknisiWithPaging(@RequestParam int page, @RequestParam int limit){
        List<Teknisi> daftarTeknisi = teknisiService.findAllWithPaging(page, limit);
        if(daftarTeknisi.isEmpty()){
            return new ResponseEntity<>(daftarTeknisi,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(daftarTeknisi,HttpStatus.OK);
        }
    }

    // end-point untuk mengambil single data teknisi
    //---------------------------------------------------------
    @RequestMapping(value = "/teknisi/{idTeknisi}", method = RequestMethod.GET)
    public ResponseEntity<?> getTeknisiById(@PathVariable("idTeknisi") String idTeknisi) {
        logger.info("mengambil teknisi dengan id {}", idTeknisi);
        Teknisi teknisi = teknisiService.findById(idTeknisi);
        if (teknisi == null) {
            logger.error("teknisi dengan id {} tidak ditemukan.", idTeknisi);
            return new ResponseEntity<>(new CustomErrorType("Teknisi dengan id " + idTeknisi + " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teknisi, HttpStatus.OK);
    }

    // end-point untuk meng-create single data teknisi (by id)
    //---------------------------------------------------------
    @RequestMapping(value = "/teknisi/", method = RequestMethod.POST)
    public ResponseEntity<?> createTeknisi(@RequestBody Teknisi teknisi) {
        logger.info("membuat data teknisi : {}", teknisi);

        if (teknisiService.isTeknisiExist(teknisi)) {
            logger.error("tidak bisa memuat data. teknisi dengan nama {} sudah ada", teknisi.getNamaTeknisi());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. A Customer with name " +
                    teknisi.getNamaTeknisi() + " already exist."), HttpStatus.CONFLICT);
        }
        teknisiService.createTeknisi(teknisi);
        return new ResponseEntity<>(teknisi, HttpStatus.CREATED);
    }

    // end-point untuk mengambil single data teknisi (by name)
    //---------------------------------------------------------
    @RequestMapping(value = "/teknisi/nama/{namaTeknisi}", method = RequestMethod.GET)
    public ResponseEntity<?> getTeknisi(@PathVariable("namaTeknisi") String namaTeknisi) {
        logger.info("mengambil data teknisi dengan nama {}", namaTeknisi);
        Teknisi teknisi = teknisiService.findByName(namaTeknisi);
        if (teknisi == null) {
            logger.error("Teknisi dengan nama {} tidak ditemukan.", namaTeknisi);
            return new ResponseEntity<>(new CustomErrorType("Teknisi dengan nama" + namaTeknisi + " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teknisi, HttpStatus.OK);
    }

    // end-point untuk update data teknisi
    //---------------------------------------------------------
    @RequestMapping(value = "/teknisi/{idTeknisi}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateTeknisi(@PathVariable("idTeknisi") String idTeknisi, @RequestBody Teknisi teknisi) {
        logger.info("update data teknisi dengan id {}", idTeknisi);

        Teknisi dataTeknisi = teknisiService.findById(idTeknisi);
        if (dataTeknisi == null) {
            logger.error("tidak bisa update. teknisi dengan id {} tidak ditemukan.", idTeknisi);
            return new ResponseEntity<>(new CustomErrorType("tidak bisa update. teknisi dengan id " + idTeknisi +
                    " tidak ditemukan."),
                    HttpStatus.NOT_FOUND);
        }

        dataTeknisi.setNamaTeknisi(teknisi.getNamaTeknisi());
        dataTeknisi.setAlamatTeknisi(teknisi.getAlamatTeknisi());
        dataTeknisi.setTelpTeknisi(teknisi.getTelpTeknisi());
        dataTeknisi.setBidangJasa(teknisi.getBidangJasa());

        teknisiService.updateTeknisi(dataTeknisi);

        return new ResponseEntity<>(dataTeknisi, HttpStatus.OK);
    }

    // end-point untuk delete data teknisi
    //---------------------------------------------------------
    @RequestMapping(value = "/teknisi/{idTeknisi}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTeknisi(@PathVariable("idTeknisi") String idTeknisi) {
        logger.info("memuat dan menghapus data teknisi dengan id {}", idTeknisi);

        Teknisi teknisi = teknisiService.findById(idTeknisi);
        if (teknisi == null) {
            logger.error("tidak bisa menghapus!! data teknisi dengan id {} tidak ditemukan.", idTeknisi);
            return new ResponseEntity<>(new CustomErrorType("tidak bisa menghapus data, teknisi dengan id " + idTeknisi + " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }

        teknisiService.deleteTeknisiById(idTeknisi);
        return new ResponseEntity<Teknisi>(HttpStatus.NO_CONTENT);
    }






}