package org.khcl.shopstops.wrappers;

import lombok.Data;

/*
 * Simple response with status and message
 * */
@Data
public class ResponseWrapper{
	private String status;
	private String message;
}