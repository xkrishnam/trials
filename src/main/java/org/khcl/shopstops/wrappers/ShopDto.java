package org.khcl.shopstops.wrappers;

import org.khcl.shopstops.entity.Shop;

import lombok.Data;

/*
 * Dto class for shop convey simple information about Shop entity
 * */

@Data
public class ShopDto {
	private String shopName;
	private String shopAddress;
	private String shopPostCode;
	private double latitude;
	private double longitude;
	
	/*
	 * Method to clone Shop into ShopDto
	 * */
	public ShopDto makeShopDtoFromShop(Shop shop){
		this.setShopName(shop.getName());
		this.setShopAddress(shop.getAddress().getAddressline());
		this.setShopPostCode(shop.getAddress().getPostalcode());
		this.setLatitude(shop.getLocation().getLat());
		this.setLongitude(shop.getLocation().getLng());
		return this;
	}
}
