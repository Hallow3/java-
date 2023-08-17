package com.brayant.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class NoPermissionException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4273623849565275189L;

	public NoPermissionException(String message) {
		super(message);
	}
}
