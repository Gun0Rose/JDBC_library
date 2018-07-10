package com.libmanager.util;

/**
 * 判断是否为空/是否不空
 * @author Administrator
 *
 */
public class EmptyTool {
	//判断是否为空
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str.trim()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//判断是否不空
	public static boolean isNotEmpty(String str){
		if(str!=null&&!"".equals(str.trim()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
