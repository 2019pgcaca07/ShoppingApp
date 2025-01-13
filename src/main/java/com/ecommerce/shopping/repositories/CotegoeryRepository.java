package com.ecommerce.shopping.repositories;

import com.ecommerce.shopping.model.Cotegoery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CotegoeryRepository extends JpaRepository<Cotegoery,Long> {

    Cotegoery findByCotegoeryName(String cotegoeryName);
}
