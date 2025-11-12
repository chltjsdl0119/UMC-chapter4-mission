package com.umc.gwnu.store.infrastructure;

import com.umc.gwnu.store.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
