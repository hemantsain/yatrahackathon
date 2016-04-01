package com.yatra.yatrahackathon.webaccess;

import android.content.Context;

import com.yatra.yatrahackathon.webaccess.parser.BaseHandler;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ServerAccess {

	ResultHandler caller;
	WSActions action;
	Context context;

	String cypherQuery = "";

	public ServerAccess(Context context, ResultHandler caller, WSActions action) {
		this.caller = caller;
		this.action = action;
		this.context = context;
	}

	public Object sendRequestToServer(Object params) {

		cypherQuery = BuildRequest.getRequestString(action, params);

		if (cypherQuery.startsWith("error:"))
			return cypherQuery;

		InputStream responseString = null;

		try {
			responseString = HttpHelper.sendGet(cypherQuery);


		} catch (Exception e) {
			e.printStackTrace();
		}

		return processResponseFromServer(responseString);
	}

	public Object processResponseFromServer(InputStream result) {

		if (cypherQuery.startsWith("error:")) {
			return cypherQuery;
		}

		Object object;
		try {
			if(null != result){
					BaseHandler handler = BaseHandler.getParser(action);
					SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
					parser.parse(result, handler);

				return handler.getData();

			}

		} catch (Exception e) {
			e.printStackTrace();
//			if (caller != null) {
//				return cypherQuery = "error:Exception";
//			}
		}
		return null;
	}
}
