package com.capitoleconsulting.ecommercetest.repository;

import com.capitoleconsulting.ecommercetest.dto.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {


    @Query(value = "SELECT * FROM prices WHERE product_id = :productId AND brand_id = :brandId AND start_date <= :applicationDate AND end_date >= :applicationDate ORDER BY priority DESC LIMIT 1", nativeQuery = true)
    Optional<Price> findTopByProductIdAndBrandIdAndApplicationDate(
            @Param("productId") Integer productId,
            @Param("brandId") Integer brandId,
            @Param("applicationDate") LocalDateTime applicationDate);
}
