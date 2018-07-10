package com.libmanager.util;

import java.sql.Date;
import java.text.DateFormat;
import java.util.Locale;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Time {
	public static String year=null;
	public static String month=null;
	public static String day=null;
	public static String getDate()
	{
		String date=DateFormat.getDateTimeInstance(2, 2, Locale.CHINESE).format(new java.util.Date());
		year=date.substring(0, 4);
		month=date.substring(5, 7);
		day=date.substring(8, 10);
		/*System.out.println(date);
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);*/
		return date;
	}/*
	public static void main(String[] args) {
		getDate();
	}*/
}

