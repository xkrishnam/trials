package org.khcl.shopstops.services.gmap;



import org.khcl.shopstops.appExceptions.LocationNotFoundException;
import org.khcl.shopstops.entity.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

/*
 * Service class which provide method to find location by address
 * */
@Service
public class GmapServiceImpl {


private static final Logger logger = LoggerFactory.getLogger(GmapServiceImpl.class);

@Value("${gmap.api.key}")
private String apikey;

/*
 * Find location by address takes shop.Addressline + shop.postalcode as argument
 * */
public Location getLatLngByAddress(String address){
	logger.info("finding  location for address : "+address);
	GeocodingResult[] results=null;
	GeoApiContext context = new GeoApiContext().setApiKey(apikey);
	try{
	results =  GeocodingApi.geocode(context,address).await();
	}catch(Exception e){
		
	}
    if(results !=null && results.length<1){
    	throw new LocationNotFoundException("Google returned no location for address : "+address);
    }
    Location loc=new Location(results[0].geometry.location.lat,results[0].geometry.location.lng);
    return loc;
}
}
