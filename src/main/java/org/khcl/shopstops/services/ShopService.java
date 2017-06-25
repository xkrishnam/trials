package org.khcl.shopstops.services;

import org.khcl.shopstops.entity.Shop;

public interface ShopService {
	public Shop getShopByName(String name);
	public Shop addShop(Shop shop);
	Shop getNearestShop(double lat,double lng);
}
