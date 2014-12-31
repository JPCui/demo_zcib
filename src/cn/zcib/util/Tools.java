package cn.zcib.util;

import java.util.Calendar;

public class Tools {

	public static String getCurrentTime()
	{
		Calendar cal = Calendar.getInstance();
		return cal.getTime().getTime()+"";
	}

	/*
	 * 获取当前时间
	 * @param Y_M_D 是否包含：年月日
	 * @param H_M_S 是否包含：时分秒
	 */
	public static String getCurrentTime(boolean Y_M_D, boolean H_M_S)
	{
		Calendar cal = Calendar.getInstance();
		int year = cal.get( Calendar.YEAR );
		int month = cal.get( Calendar.MONTH )+1;//月份是从0开始的
		int day = cal.get( Calendar.DAY_OF_MONTH );
		int hour = cal.get( Calendar.HOUR_OF_DAY );
		int min = cal.get( Calendar.MINUTE );
		int second = cal.get( Calendar.SECOND );
//		System.out.println(year +"-"+ month +"-"+ day +" "+ hour +":"+ min +":"+ second);
		
		String currentTime = "";
		if(Y_M_D){
			currentTime += year +"-"+ ( month<10?("0"+month):month ) +"-"+ ( day<10?("0"+day):day );
		}
		if(H_M_S){
			currentTime += " "+ ( hour<10?("0"+hour):hour ) +":"+ ( min<10?("0"+min):min ) +":"+ ( second<10?("0"+second):second );
		}
//		System.out.println( currentTime );
		return currentTime;
	}
	public static void main(String []args)
	{
		System.out.println( getCurrentTime(true,true) );
	}
}
