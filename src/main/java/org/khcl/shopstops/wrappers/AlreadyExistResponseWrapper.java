package org.khcl.shopstops.wrappers;

import lombok.Data;

/*
 * Response wrapper returned in case when shopname already exists
 * */
@Data
public class AlreadyExistResponseWrapper {
 private ShopDto previousAddress;
 private ShopDto newAddress;
}
