package com.example.shop.order.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PurchaseOrderRepository{
    Optional<PurchaseOrder> findById(UUID id);

    Page<PurchaseOrder> findAll(Pageable pageable);

    PurchaseOrder save(PurchaseOrder purchaseOrder);
}
