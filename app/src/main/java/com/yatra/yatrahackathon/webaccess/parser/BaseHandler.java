package com.yatra.yatrahackathon.webaccess.parser;


import org.xml.sax.helpers.DefaultHandler;

import com.yatra.yatrahackathon.webaccess.WSActions;


public abstract class BaseHandler extends DefaultHandler
{
	public Boolean currentElement = false;
	public String currentValue = "";
	public abstract Object getData();
	public StringBuffer buffer = new StringBuffer();;
	public static BaseHandler getParser(WSActions wsMethod)
	{
		switch(wsMethod)
		{
			case GET_VEHICLE_LIST:
				return new VehicleListHandler();
		}
		return null;
	}
	
	
	/**
	 * Method to convert StringBuffer to String.
	 * @param sb
	 * @return String
	 */
	public String sb2String(StringBuffer sb)
	{
		if(sb == null)
			return "";
		try
		{
			return sb.toString();
		}
		catch(Exception e)
		{
	   		e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Method to convert StringBuffer to Long.
	 * @param sb
	 * @return long
	 */
	public long sb2Long(StringBuffer sb)
	{
		if(sb == null)
			return 0;
		try
		{
			return Long.parseLong(sb.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Method to convert StringBuffer to double.
	 * @param sb
	 * @return double
	 */
	public double sb2Double(StringBuffer sb)
	{
		if(sb == null)
			return 0;
		try
		{
			return Double.parseDouble(sb.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Method to convert StringBuffer to boolean.
	 * @param sb
	 * @return boolean
	 */
	public boolean sb2Boolean(StringBuffer sb)
	{
		boolean result = false;
		
		if(sb == null)
			return result;
		
		if (sb.length() > 0)
		{
			try
			{
				result = sb.toString().equalsIgnoreCase("true");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		return result;
	}
	
	/**
	 * Method to convert StringBuffer to int.
	 * @param sb
	 * @return int
	 */
	public int sb2Int(StringBuffer sb)
	{
		if (sb==null) 
			return 0;
		
		return string2Int(sb.toString());
	}

	/**
	 * Method to convert String to int.
	 * @param string
	 * @return int
	 */
	public int string2Int(String string)
	{
		int result = 0;
		if (string != null && string.length() > 0)
		{
			try
			{
				result = Integer.parseInt(string);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * Method to convert String to float.
	 * @param string
	 * @return float
	 */
	public float string2Float(String string)
	{
		float result = 0f;
		if (string != null && string.length() > 0)
		{
			try
			{
				result = Float.parseFloat(string);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * Method to convert String to double.
	 * @param string
	 * @return double
	 */
	public double string2Double(String string)
	{
		double result = 0f;
		if (string != null && string.length() > 0)
		{
			try
			{
				result = Double.parseDouble(string);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * Method to convert String to boolean.
	 * @param string
	 * @return boolean
	 */
	public boolean string2Boolean(String string)
	{
		boolean result = false;
		if (string != null && string.length() > 0)
		{
			try
			{
				result = string.equalsIgnoreCase("success");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * Method to convert String to boolean.
	 * @param string
	 * @return boolean
	 */
	public boolean getBoolean(String string)
	{
		boolean result = false;
		if (string != null && string.length() > 0)
		{
			try
			{
				result = string.equalsIgnoreCase("true");
			}
			catch(Exception e)
			{

			}
		}
		return result;
	}
	public abstract String getErrorMessage();
	
	
}
