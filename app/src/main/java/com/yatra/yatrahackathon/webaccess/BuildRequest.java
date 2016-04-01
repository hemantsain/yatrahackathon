package com.yatra.yatrahackathon.webaccess;

import com.yatra.yatrahackathon.dao.VehicleDao;
import com.yatra.yatrahackathon.webaccess.WSActions;

public class BuildRequest {

	static String cypherQuery;

	private static final String MAIN_URL = "";

	public static String getRequestString(WSActions RequestAction, Object params) {

		switch (RequestAction) {

			case GET_VEHICLE_LIST:
				cypherQuery = getVehil(null);
				break;
			default:
				cypherQuery = "error:Action " + RequestAction + " is undefined";
				break;
		}
		return cypherQuery;
	}

	private static String getVehil(VehicleDao vehicleDao)
	{
		String req = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:com=\"http://www.travelport.com/schema/common_v29_0\" xmlns:veh=\"http://www.travelport.com/schema/vehicle_v29_0\">   <soapenv:Header/>   <soapenv:Body>      <veh:VehicleSearchAvailabilityReq AuthorizedBy=\"user\" ReturnAllRates=\"false\" TargetBranch=\"P105128\" TraceId=\"trace\">         <com:BillingPointOfSaleInfo OriginApplication=\"UAPI\"/>         <veh:VehicleDateLocation PickupDateTime=\"2016-04-09T12:00:00\" PickupLocation=\"SFO\" PickupLocationType=\"CityCenterDowntown\" ReturnDateTime=\"2016-04-16T12:00:00\" ReturnLocation=\"DEN\" ReturnLocationType=\"CityCenterDowntown\"/>         <veh:VehicleSearchModifiers PreferredCurrency=\"AUD\" TourCode=\"IT-123456\" UnlimitedMileage=\"true\">            <veh:SearchDistance Direction=\"NW\" MaxDistance=\"15\" MinDistance=\"1\" Units=\"KM\"/>         </veh:VehicleSearchModifiers>      </veh:VehicleSearchAvailabilityReq>   </soapenv:Body>\n" +
				"</soapenv:Envelope>\n";

		return req;
	}
}
