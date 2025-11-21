package com.example.shop.settlement.domian;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SellerSettlementRepository {

    List<SellerSettlement> findByStatus(SettlementStatus status);

    List<SellerSettlement> findByStatusAndSellerId(SettlementStatus status, UUID sellerId);

    SellerSettlement save(SellerSettlement sellerSettlement);
}
