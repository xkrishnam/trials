package org.khcl.shopstops.services;

import java.util.List;

import javax.transaction.Transactional;

import org.khcl.shopstops.entity.Shop;
import org.khcl.shopstops.repository.ShopRepository;
import org.khcl.shopstops.utils.HaversineAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Service Implementation of SsopService interface
 * */
@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopRepository shopRepository;
	
	@Override
	@Transactional
	public Shop getShopByName(String name) {
		return this.shopRepository.findByName(name);
	}

	@Override
	@Transactional
	public Shop addShop(Shop shop) {
		Shop s=this.shopRepository.save(shop);
		return s;
	}

	@Override
	@Transactional
	public Shop getNearestShop(double lat,double lng) {
		List<Shop> shops=this.shopRepository.findAll();
		double mindistance=889989898989898989.0,tmp;
		Shop nearest=null;
		for(Shop shop :shops){
			tmp=HaversineAlgorithm.HaversineInKM(lat, lng, shop.getLocation().getLat(),shop.getLocation().getLng());
			if(tmp<mindistance){
				mindistance=tmp;
				nearest=shop;
			}
		}
		return nearest;
	}

}
