package com.example.shop.settlement.InfraStructure;

import com.example.shop.settlement.domian.SellerSettlement;
import com.example.shop.settlement.domian.SettlementStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SellerSettlementJpaRepository extends JpaRepository<SellerSettlement, UUID> {

    List<SellerSettlement> findByStatus(SettlementStatus status);
}