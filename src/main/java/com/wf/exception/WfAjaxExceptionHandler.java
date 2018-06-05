package com.wf.exception;


import com.wf.pojo.WfJSONResult;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class WfAjaxExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
	public WfJSONResult defaultErrorHandler(HttpServletRequest req,
											Exception e) throws Exception {

		e.printStackTrace();
		return WfJSONResult.errorException(e.getMessage());
	}
}
