package com.capitoleconsulting.ecommercetest.controller;

import com.capitoleconsulting.ecommercetest.model.PriceResponse;
import com.capitoleconsulting.ecommercetest.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/v1")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/prices")
    public ResponseEntity<PriceResponse> getPriceFromQuery(
            @RequestParam("applicationDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime applicationDate,
            @RequestParam("productId") Integer productId,
            @RequestParam("brandId") Integer brandId) {
        PriceResponse priceResponse = priceService.getPriceFromQuery(productId, brandId, applicationDate);
        if (nonNull(priceResponse)) {
            return new ResponseEntity<>(priceResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
