package com.yatra.yatrahackathon.webaccess.parser;

import com.yatra.yatrahackathon.dao.VehicleApproximateRate;
import com.yatra.yatrahackathon.dao.VehicleDao;
import com.yatra.yatrahackathon.dao.VehicleRate;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;


public class VehicleListHandler extends BaseHandler
{

	public int response_code = -1;
    public String response_message = null;
    public String response_message_mobile_holder_id = null;
	List<VehicleDao> listVehicle;
    VehicleDao vehicleDao;

    @Override
	public Object getData()
	{
		return listVehicle;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);

		if(localName.equalsIgnoreCase("VehicleDateLocation")) {
			listVehicle = new ArrayList<VehicleDao>();
		}
		if(localName.equalsIgnoreCase("Vehicle"))
		{
			vehicleDao = new VehicleDao();
			vehicleDao.setVendorCode(attributes.getValue("VendorCode"));
			vehicleDao.setAirConditioning(attributes.getValue("AirConditioning"));
			vehicleDao.setTransmissionType(attributes.getValue("TransmissionType"));
			vehicleDao.setVehicleClass(attributes.getValue("VehicleClass"));
			vehicleDao.setCategory(attributes.getValue("Category"));
			vehicleDao.setDoorCount(attributes.getValue("DoorCount"));
			vehicleDao.setLocation(attributes.getValue("Location"));
			vehicleDao.setVendorLocationKey(attributes.getValue("VendorLocationKey"));
			vehicleDao.setDescription(attributes.getValue("Description"));
			vehicleDao.setReturnAtPickup(attributes.getValue("ReturnAtPickup"));

			listVehicle.add(vehicleDao);
//			buffer = new StringBuffer();
		}
		if(localName.equalsIgnoreCase("VehicleRate")) {
			VehicleRate vehicleRate = new VehicleRate();
			vehicleRate.setRatePeriod(attributes.getValue("RatePeriod"));
			vehicleRate.setUnlimitedMileage(attributes.getValue("UnlimitedMileage"));
			vehicleRate.setUnits(attributes.getValue("Units"));
			vehicleRate.setRateSource(attributes.getValue("RateSource"));
			vehicleRate.setRateAvailability(attributes.getValue("RateAvailability"));
			vehicleRate.setRateCode(attributes.getValue("RateCode"));
			vehicleRate.setRateCategory(attributes.getValue("RateCategory"));
			vehicleDao.setVehicleRate(vehicleRate);
		}
		if(localName.equalsIgnoreCase("ApproximateRate")) {
			VehicleApproximateRate vehicleApproximateRate = new VehicleApproximateRate();
			vehicleApproximateRate.setRateForPeriod(attributes.getValue("RateForPeriod"));
			vehicleApproximateRate.setBaseRate(attributes.getValue("BaseRate"));
			vehicleApproximateRate.setEstimatedTotalAmount(attributes.getValue("EstimatedTotalAmount"));
			vehicleApproximateRate.setDropOffCharge(attributes.getValue("DropOffCharge"));
			vehicleApproximateRate.setExtraMileageCharge(attributes.getValue("ExtraMileageCharge"));
			vehicleDao.setVehicleApproximateRate(vehicleApproximateRate);
		}
	}

    @Override
    public void endElement(String uri, String localName, String qName)
    		throws SAXException {
    	if(localName.equalsIgnoreCase("VehicleDateLocation"))
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
