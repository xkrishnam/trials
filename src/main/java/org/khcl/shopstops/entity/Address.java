package org.khcl.shopstops.entity;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Address {
	String addressline;
	String postalcode;
}
