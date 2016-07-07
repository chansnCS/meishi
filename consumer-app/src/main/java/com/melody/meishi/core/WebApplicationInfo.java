/**
 * @Title:  WebApplicationInfo.java
 * @Copyright (C) 2014-2015 by ywx.co.,ltd.All Rights Reserved.
 *  YWX CONFIDENTIAL AND TRADE SECRET
 * @author:  
 * @data:    
 */
package com.melody.meishi.core;

/**
 * 网站相关信息
 * @author fangyi
 */
public class WebApplicationInfo {
	private static String rootDiskPath; //网站物理根目录

	private static String rootUrl;  //网站访问根路径,ip地址域名
	
	
	
	public static String getRootDiskPath() {
		return rootDiskPath;
	}

	public static void setRootDiskPath(String rootDiskPath) {
		WebApplicationInfo.rootDiskPath = rootDiskPath;
	}

	public static String getRootUrl() {
		return rootUrl;
	}

	public static void setRootUrl(String rootUrl) {
		WebApplicationInfo.rootUrl = rootUrl;
	}
}
