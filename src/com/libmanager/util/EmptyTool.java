package com.libmanager.util;

/**
 * �ж��Ƿ�Ϊ��/�Ƿ񲻿�
 * @author Administrator
 *
 */
public class EmptyTool {
	//�ж��Ƿ�Ϊ��
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
	
	//�ж��Ƿ񲻿�
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
