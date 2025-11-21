package com.example.shop.settlement.InfraStructure;

import com.example.shop.settlement.domian.SellerSettlement;
import com.example.shop.settlement.domian.SellerSettlementRepository;
import com.example.shop.settlement.domian.SettlementStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SellerSettlementRepositoryAdapter implements SellerSettlementRepository {

    private final SellerSettlementJpaRepository sellerSettlementJpaRepository;

    @Override
    public List<SellerSettlement> findByStatus(SettlementStatus status) {
        return sellerSettlementJpaRepository.findByStatus(status);
    }

    @Override
    public List<SellerSettlement> findByStatusAndSellerId(SettlementStatus status, UUID sellerId) {
        return List.of();
    }

    @Override
    public SellerSettlement save(SellerSettlement sellerSettlement) {
        return sellerSettlementJpaRepository.save(sellerSettlement);
    }
}
