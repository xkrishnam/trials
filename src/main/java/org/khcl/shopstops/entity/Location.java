package org.khcl.shopstops.entity;

import javax.persistence.Embeddable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
@Data
public class Location {
    private double lat;
    private double lng;
    
    Location(){
    }

	public Location(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
}