package com.yatra.yatrahackathon.webaccess;

import android.content.Context;
import android.os.AsyncTask;

public class QueryServer extends AsyncTask<String, Void, Object> {

	String cypherQuery = "";
	ResultHandler caller;
	WSActions action;
	Context context;
	ServerAccess serverAccess;

	public QueryServer(Context context, ResultHandler caller, WSActions action) {
		this.caller = caller;
		this.action = action;
		this.context = context;

		serverAccess = new ServerAccess(context, caller, action);
	}

	@Override
	protected void onPostExecute(Object result) {

		if(result == null)
		{
			caller.onResult(true, result);
		}
		else
		{
			caller.onResult(false, result);
		}
	}

	@Override
	protected Object doInBackground(String... params) {
		return serverAccess.sendRequestToServer(params);
	}
}
