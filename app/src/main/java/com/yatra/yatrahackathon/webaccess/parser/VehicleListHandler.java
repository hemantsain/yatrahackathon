package com.yatra.yatrahackathon.webaccess.parser;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.yatra.yatrahackathon.dao.VehicleDao;


public class VehicleListHandler extends BaseHandler
{

	public int response_code = -1;
    public String response_message = null;
    public String response_message_mobile_holder_id = null;
    VehicleDao vehicleDao;

    @Override
	public Object getData()
	{
		return vehicleDao;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if(localName.equalsIgnoreCase(""))
		{
			buffer = new StringBuffer();
		}
	}

    @Override
    public void endElement(String uri, String localName, String qName)
    		throws SAXException {
    	if(localName.equalsIgnoreCase(""))
		{

		}
    }
    
    @Override
    public void characters(char[] ch, int start, int length)
    		throws SAXException {
    	buffer.append(ch,start,length);
    }



//	public static void writeSdcard(String str)
//	{
//		  try {
//		   {
//
//			   File file  = new File(AppConstants.TERM_CONDITION_FILE);
//			   {
//			    FileOutputStream fos = new FileOutputStream(file);
//			    BufferedOutputStream bos = new BufferedOutputStream(fos);
//			    bos.write(str.getBytes());
//
//			    bos.flush();
//			    bos.close();
//			    fos.close();
//			   }
//		   }
//
//		  } catch (Exception e) {
//		   e.printStackTrace();
//		  }
//		 }
	
	@Override
	public String getErrorMessage() 
	{
		return response_message;
	}
}
