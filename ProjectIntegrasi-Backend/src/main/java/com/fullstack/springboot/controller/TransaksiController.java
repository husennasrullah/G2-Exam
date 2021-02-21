package com.fullstack.springboot.controller;

import com.fullstack.springboot.model.Jasa;
import com.fullstack.springboot.model.Teknisi;

import com.fullstack.springboot.model.Transaksi;
import com.fullstack.springboot.model.TransaksiResponse;
import com.fullstack.springboot.service.TransaksiService;
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
public class TransaksiController {

    public static final Logger logger = LoggerFactory.getLogger(TeknisiController.class);

    @Autowired
    TransaksiService transaksiService;

    @RequestMapping(value = "/transaksi/", method = RequestMethod.GET)
    public ResponseEntity<List<Transaksi>> listAllTransaksi() {
        List<Transaksi> dataTransaksi = transaksiService.findAll();
        if (dataTransaksi.isEmpty()) {
            return new ResponseEntity<>(dataTransaksi, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dataTransaksi, HttpStatus.OK);
    }

    @RequestMapping(value = "/transaksi/", method = RequestMethod.POST)
    public ResponseEntity<?> createJasa(@RequestBody Transaksi transaksi) {
        logger.info("membuat data jasa : {}", transaksi);
        transaksiService.saveTransaksi(transaksi);
        return new ResponseEntity<>(transaksi, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/transaksi/{idTransaksi}", method = RequestMethod.GET)
    public ResponseEntity<?> getTransaksiById(@PathVariable("idTransaksi") String idTransaksi) {
        logger.info("mengambil transaksi dengan id {}", idTransaksi);
        TransaksiResponse transaksiResponse = transaksiService.findById(idTransaksi);
        if (transaksiResponse == null) {
            logger.error("transaksi dengan id {} tidak ditemukan.", idTransaksi);
            return new ResponseEntity<>(new CustomErrorType("Transaksi dengan id " + idTransaksi + " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transaksiResponse, HttpStatus.OK);
    }
}
