package com.capitoleconsulting.ecommercetest;

import com.capitoleconsulting.ecommercetest.controller.PriceController;
import com.capitoleconsulting.ecommercetest.factory.PriceResponseFactory;
import com.capitoleconsulting.ecommercetest.model.PriceResponse;
import com.capitoleconsulting.ecommercetest.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
public class PriceControllerTest {

    public static final String PATH = "/v1/prices";
    public static final String APPLICATION_DATE = "applicationDate";
    public static final String PRODUCT_ID = "productId";
    public static final String BRAND_ID = "brandId";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PriceService priceService;

    @Test
    public void testGetPriceAt10AMOn14th() throws Exception {
        PriceResponse mockResponse = PriceResponseFactory.createPriceResponse(35455, 1, 1,
                LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 35.50);
        when(priceService.getPriceFromQuery(any(), any(), any())).thenReturn(mockResponse);

        mockMvc.perform(get(PATH)
                        .param(APPLICATION_DATE, "2020-06-14 10:00:00")
                        .param(PRODUCT_ID, "35455")
                        .param(BRAND_ID, "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void testGetPriceAt4PMOn14th() throws Exception {
        PriceResponse mockResponse = PriceResponseFactory.createPriceResponse(35455, 1, 2,
                LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"), 25.45);
        when(priceService.getPriceFromQuery(any(), any(), any())).thenReturn(mockResponse);

        mockMvc.perform(get(PATH)
                        .param(APPLICATION_DATE, "2020-06-14 16:00:00")
                        .param(PRODUCT_ID, "35455")
                        .param(BRAND_ID, "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(25.45));
    }

    @Test
    public void testGetPriceAt9PMOn14th() throws Exception {

        PriceResponse mockResponse = PriceResponseFactory.createPriceResponse(35455, 1, 1,
                LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 35.50);
        when(priceService.getPriceFromQuery(any(), any(), any())).thenReturn(mockResponse);

        mockMvc.perform(get(PATH)
                        .param(APPLICATION_DATE, "2020-06-14 21:00:00")
                        .param(PRODUCT_ID, "35455")
                        .param(BRAND_ID, "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(35.50));
    }

    @Test
    public void testGetPriceAt10AMOn15th() throws Exception {
        PriceResponse mockResponse = PriceResponseFactory.createPriceResponse(35455, 1, 3,
                LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"), 30.50);
        when(priceService.getPriceFromQuery(any(), any(), any())).thenReturn(mockResponse);

        mockMvc.perform(get(PATH)
                        .param(APPLICATION_DATE, "2020-06-15 10:00:00")
                        .param(PRODUCT_ID, "35455")
                        .param(BRAND_ID, "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(30.50));
    }

    @Test
    public void testGetPriceAt9PMOn16th() throws Exception {

        PriceResponse mockResponse = PriceResponseFactory.createPriceResponse(35455, 1, 4,
                LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"), 38.95);
        when(priceService.getPriceFromQuery(any(), any(), any())).thenReturn(mockResponse);

        mockMvc.perform(get(PATH)
                        .param(APPLICATION_DATE, "2020-06-16 21:00:00")
                        .param(PRODUCT_ID, "35455")
                        .param(BRAND_ID, "1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.price").value(38.95));
    }
}
