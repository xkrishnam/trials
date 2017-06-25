package org.khcl.shopstops.controllers;

import static org.junit.Assert.assertNotNull;

import org.khcl.shopstops.entity.Shop;
import org.khcl.shopstops.services.ShopService;
import org.khcl.shopstops.services.gmap.GmapServiceImpl;
import org.khcl.shopstops.wrappers.AlreadyExistResponseWrapper;
import org.khcl.shopstops.wrappers.ResponseWrapper;
import org.khcl.shopstops.wrappers.ShopDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * Main front controller for application
 * */
@RestController("/rest/shop")
public class ShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private GmapServiceImpl gmpImpl;

	@RequestMapping(method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public Shop getNearestshop(@RequestParam("latitude") double latitude,@RequestParam("longitude") double longitude){
		assertNotNull("latitude must not null", latitude);
		assertNotNull("Longitude must not null",longitude);
		logger.info("finding nearest shop from latitude :{} and logitude :{}",latitude,longitude);
		return this.shopService.getNearestShop(latitude,longitude);
	}
	
	@RequestMapping(method=RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public Object saveShop(@RequestBody Shop shop){
		ResponseWrapper res=new ResponseWrapper();
		shop.setLocation(this.gmpImpl.getLatLngByAddress(shop.getAddress().getAddressline()+" , "+shop.getAddress().getPostalcode()));
		Shop tmp=this.shopService.getShopByName(shop.getName());
		if(tmp==null || tmp.getId()==null){
			this.shopService.addShop(shop);
			logger.info("Adding new shop :"+shop.getName());
			res.setStatus("OK");
			res.setMessage("New Shop added - Name : "+shop.getName()+" Id : "+shop.getId());
			return res;
		}else{
			logger.info("Replacing old shop with new");
			AlreadyExistResponseWrapper response=new AlreadyExistResponseWrapper();
			response.setPreviousAddress(new ShopDto().makeShopDtoFromShop(tmp));
			response.setNewAddress(new ShopDto().makeShopDtoFromShop(shop));
			shop.setId(tmp.getId());
			this.shopService.addShop(shop);		
			return response;
		}
		
	}
}