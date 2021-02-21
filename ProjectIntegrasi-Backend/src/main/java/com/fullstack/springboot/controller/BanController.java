package com.fullstack.springboot.controller;

import com.fullstack.springboot.model.Ban;
import com.fullstack.springboot.service.BanService;
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
public class BanController {
    public static final Logger logger = LoggerFactory.getLogger(BanController.class);

    @Autowired
    BanService banService;

    // end-point untuk mengambil seluruh data
    //---------------------------------------------------------
    @RequestMapping(value = "/ban/", method = RequestMethod.GET)
    public ResponseEntity<List<Ban>> listAllBan() {
        List<Ban> dataBan = banService.findAllBan();
        if (dataBan.isEmpty()) {
            return new ResponseEntity<>(dataBan, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dataBan, HttpStatus.OK);
    }

    // end-point untuk mengambil seluruh data dengan paging
    //---------------------------------------------------------
    @RequestMapping(value = "/ban/paging/", method = RequestMethod.GET)
    public ResponseEntity<?>getBanWithPaging(@RequestParam int page, @RequestParam int limit){
        List<Ban> daftarBan = banService.findAllWithPaging(page, limit);
        if(daftarBan.isEmpty()){
            return new ResponseEntity<>(daftarBan,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(daftarBan,HttpStatus.OK);
        }
    }

    // end-point untuk mengambil single data customer
    //---------------------------------------------------------
    @RequestMapping(value = "/ban/{idBan}", method = RequestMethod.GET)
    public ResponseEntity<?> getBanById(@PathVariable("idBan") String idBan) {
        logger.info("mengambil data ban dengan id {}", idBan);
        Ban ban = banService.findById(idBan);
        if (ban == null) {
            logger.error("data Ban dengan id {} tidak ditemukan.", idBan);
            return new ResponseEntity<>(new CustomErrorType("data Ban dengan id " + idBan + " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ban, HttpStatus.OK);
    }

    // end-point untuk mengambil single data customer (by name)
    //---------------------------------------------------------
    @RequestMapping(value = "/ban/merk/{merkBan}", method = RequestMethod.GET)
    public ResponseEntity<?> getBanByName(@PathVariable("merkBan") String merkBan) {
        logger.info("mengambil data ban dengan merk {}", merkBan);
        Ban ban= banService.findByName(merkBan);
        if (ban == null) {
            logger.error("data Ban dengan merk {} tidak ditemukan.", merkBan);
            return new ResponseEntity<>(new CustomErrorType("data Ban dengan merk" + merkBan+ " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ban, HttpStatus.OK);
    }

    @RequestMapping(value = "/ban/", method = RequestMethod.POST)
    public ResponseEntity<?> createBan(@RequestBody Ban ban) {
        logger.info("membuat data ban : {}", ban);

        if (banService.isBanExist(ban)) {
            logger.error("tidak bisa memuat data, ban dengan merk {} sudah ada", ban.getMerkBan());
            return new ResponseEntity<>(new CustomErrorType("tidak bisa membua data produk ban dengan merk"+
                    ban.getMerkBan() + " sudah ada."), HttpStatus.CONFLICT);
        }
        banService.createBan(ban);
        return new ResponseEntity<>(ban, HttpStatus.CREATED);
    }

    // end-point untuk update data produk ban
    //---------------------------------------------------------
    @RequestMapping(value = "/ban/{idBan}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBan(@PathVariable("idBan") String idBan, @RequestBody Ban ban) {
        logger.info("update data produk ban dengan id {}", idBan);

        Ban dataBan = banService.findById(idBan);
        if (dataBan == null) {
            logger.error("tidak bisa update. produk ban dengan id {} tidak ditemukan.", idBan);
            return new ResponseEntity<>(new CustomErrorType("tidak bisa update. produk ban dengan id " + idBan +
                    " tidak ditemukan."),
                    HttpStatus.NOT_FOUND);
        }
        dataBan.setMerkBan(ban.getMerkBan());
        dataBan.setJenisBan(ban.getJenisBan());
        dataBan.setHargaSatuan(ban.getHargaSatuan());

        banService.updateBan(dataBan);

        return new ResponseEntity<>(dataBan, HttpStatus.OK);
    }

    // end-point untuk delete data teknisi
    //---------------------------------------------------------
    @RequestMapping(value = "/ban/{idBan}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBan(@PathVariable("idBan") String idBan) {
        logger.info("memuat dan menghapus produk ban dengan id {}", idBan);

        Ban ban = banService.findById(idBan);
        if (ban == null) {
            logger.error("tidak bisa menghapus!! produk ban dengan id {} tidak ditemukan.", idBan);
            return new ResponseEntity<>(new CustomErrorType("tidak bisa menghapus data, produk ban dengan id " + idBan + " tidak ditemukan"),
                    HttpStatus.NOT_FOUND);
        }

        banService.deleteBanById(idBan);
        return new ResponseEntity<Ban>(HttpStatus.NO_CONTENT);
    }
}

