package com.capitoleconsulting.ecommercetest.factory;

import com.capitoleconsulting.ecommercetest.model.PriceResponse;

import java.time.LocalDateTime;

public class PriceResponseFactory {

    public static PriceResponse createPriceResponse(Integer productId, Integer brandId, Integer priceList,
                                                    LocalDateTime startDate, LocalDateTime endDate, Double price) {
        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setPrice(price);
        priceResponse.setProductId(productId);
        priceResponse.setBrandId(brandId);
        priceResponse.setPriceList(priceList);
        priceResponse.setStartDate(startDate);
        priceResponse.setEndDate(endDate);
        return priceResponse;
    }
}
