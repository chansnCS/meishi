/**
 * @Title:  SpringContext.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.melody.meishi.core;

import org.springframework.context.ApplicationContext;

/**
 * 
 * @author fangyi
 */
public class SpringContext {
	private static ApplicationContext ctx;

	public static ApplicationContext getCtx() {
		return ctx;
	}

	public static void setCtx(ApplicationContext ctx) {
		SpringContext.ctx = ctx;
	}
}
