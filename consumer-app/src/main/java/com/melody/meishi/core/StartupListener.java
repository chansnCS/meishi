/**
 * @Title:  StartupListener.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.melody.meishi.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * 系统启动时，初始化相关数据
 * @author fangyi
 */
public class StartupListener implements ServletContextListener {
	private static Logger log = LoggerFactory.getLogger(StartupListener.class);

	public void contextDestroyed(ServletContextEvent arg0) {
	}
	
	public void contextInitialized(ServletContextEvent event) {
		if(log.isInfoEnabled()){
			log.info("Initialization Start");
		}
		ServletContext servletContext = event.getServletContext();
		
		// 安装全局context和加载静态数据
		setupContext(servletContext);
		if (log.isInfoEnabled()) {
			log.info("Initialization Complete");
		}
	}
	
	
	
	public static void setupContext(ServletContext context) {
		ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		
		SpringContext.setCtx(applicationContext);
		WebApplicationInfo.setRootDiskPath(context.getRealPath("/"));
		WebApplicationInfo.setRootUrl(context.getInitParameter("rootUrl"));
		System.setProperty("rootDiskPath", WebApplicationInfo.getRootDiskPath());

		// 加载静态数据
		initData(applicationContext);
	}

	private static void initData(ApplicationContext applicationContext) {

	}

}
