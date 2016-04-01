package com.yatra.yatrahackathon.webaccess;

import com.yatra.yatrahackathon.dao.VehicleDao;
import com.yatra.yatrahackathon.webaccess.WSActions;

public class BuildRequest {

	static String cypherQuery;

	private static final String MAIN_URL = "";

	public static String getRequestString(WSActions RequestAction, Object params) {

		switch (RequestAction) {

			case GET_VEHICLE_LIST:
				getVehil((VehicleDao) params);
				break;


			default:
				cypherQuery = "error:Action " + RequestAction + " is undefined";
				break;
		}
		return cypherQuery;
	}

	private static String getVehil(VehicleDao vehicleDao)
	{


		return "";
	}
}
