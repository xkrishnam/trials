package org.khcl.shopstops.repository;

import org.khcl.shopstops.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {
	Shop findByName(String name);
}
