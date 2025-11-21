package com.example.shop.order.infrastructure;

import com.example.shop.order.domain.PurchaseOrder;
import com.example.shop.order.domain.PurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PurchaseOrderRepositoryAdapter implements PurchaseOrderRepository {

    private final PurchaseOrderJpaRepository orderRepository;

    @Override
    public Optional<PurchaseOrder> findById(UUID id) {
        return orderRepository.findById(id);
    }

    @Override
    public Page<PurchaseOrder> findAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        return orderRepository.save(purchaseOrder);
    }
}
