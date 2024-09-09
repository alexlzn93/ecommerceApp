package com.capitoleconsulting.ecommercetest.service;

import com.capitoleconsulting.ecommercetest.model.PriceResponse;
import com.capitoleconsulting.ecommercetest.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public PriceResponse getPriceFromQuery(Integer productId, Integer brandId, LocalDateTime applicationDate) {
        return priceRepository.findTopByProductIdAndBrandIdAndApplicationDate(productId, brandId, applicationDate)
                .map(price -> {
                        PriceResponse priceResponse = new PriceResponse();
                        priceResponse.setPrice(price.getPrice());
                        priceResponse.setProductId(price.getProductId());
                        priceResponse.setBrandId(price.getBrandId());
                        priceResponse.setPriceList(price.getPriceList());
                        priceResponse.setStartDate(price.getStartDate());
                        priceResponse.setEndDate(price.getEndDate());
                        return priceResponse;
                })
                .orElse(null);
    }
}
