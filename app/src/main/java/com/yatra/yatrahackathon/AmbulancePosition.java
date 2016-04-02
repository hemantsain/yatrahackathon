package com.yatra.yatrahackathon;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class AmbulancePosition extends Activity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

	private GoogleMap map;
	double coordinates[];
	private String name;
    private Button btnBookCab;

	private LocationManager locationManager;
    private MarkerOptions markerOptionsForCab;
	private LatLng latLng;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.amb_position);

		Bundle bundle = getIntent().getExtras();

		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		map.setMyLocationEnabled(true);
		map.moveCamera(CameraUpdateFactory.zoomBy(15));

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 100, this);

        btnBookCab = (Button) findViewById(R.id.btn_book);
        btnBookCab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        double newLatitude = latLng.latitude + 0.018;
                        double newLongitude = latLng.longitude + 0.018;
                        for (int i = 17; i >= 0; i--) {
                            newLatitude -= 0.001;
                            newLongitude -= 0.001;

//                    if (markerOptionsForCab != null) {
//                            markerOptionsForCab.position(new LatLng(newLatitude, newLongitude));
//                        map.addMarker(new MarkerOptions().title(name).position(new LatLng(newLatitude, newLongitude)).icon(BitmapDescriptorFactory.fromResource(R.drawable.transport)));
//                    }
                            Message message = Message.obtain();
                            message.arg1 = 1;
                            message.obj = new LatLng(newLatitude, newLongitude);
                            handler.sendMessage(message);

                            try {
                                Thread.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            if (i == 0) {
                                Message message1 = Message.obtain();
                                message1.arg1 = 2;
                                handler.sendMessage(message1);
                            }
                        }
                    }
                });
                thread.start();
            }
        });

		buildGoogleApiClient();
	}

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.arg1) {
                case 1:
                    LatLng newUpdatedLatLng = (LatLng) msg.obj;

                    map.clear();
                    map.addMarker(new MarkerOptions().title(name).position(newUpdatedLatLng).icon(BitmapDescriptorFactory.fromResource(R.drawable.transport)));
                    break;

                case 2:
                    AlertDialog.Builder builder = new AlertDialog.Builder(AmbulancePosition.this).setTitle("Alert").setMessage("You cab has been reached to your door!\nTime to move on!");
                    builder.setPositiveButton("OK", null);

                    Dialog dialog = builder.create();
                    dialog.show();
                    break;
            }


            super.handleMessage(msg);
        }
    };

	private void setAmbLocation(double lat, double lon) {
		LatLng latLng = new LatLng(lat, lon);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));

		map.addMarker(new MarkerOptions().title("").position(latLng));

	}

    @Override
    protected void onStop() {
        super.onStop();

        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }
    }

    @Override
	public void onLocationChanged(Location location) {
//		if (latLng == null) {
//			latLng = new LatLng(location.getLatitude(), location.getLongitude());
//
//			// Showing the current location in Google Map
//			map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//
//			// Zoom in the Google Map
//			map.animateCamera(CameraUpdateFactory.zoomTo(15));
//
//			map.clear();
//			map.addMarker(new MarkerOptions().title(name).position(latLng));
//
//            // Show cab icon
//            markerOptionsForCab = new MarkerOptions().title(name).position(new LatLng(latLng.latitude + 0.018, latLng.longitude + 0.018)).icon(BitmapDescriptorFactory.fromResource(R.drawable.transport));
//            map.addMarker(markerOptionsForCab);
//		}
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {

	}

	@Override
	public void onProviderEnabled(String provider) {

	}

	@Override
	public void onProviderDisabled(String provider) {

	}
	protected Location mCurrentLocation;
	@Override
	public void onConnected(Bundle bundle) {
		if (mCurrentLocation == null) {
			mCurrentLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
			updateLocation();
		}
	}

	private void updateLocation() {
		if(mCurrentLocation!=null)
			if (latLng == null) {
				latLng = new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());

				// Showing the current location in Google Map
				map.moveCamera(CameraUpdateFactory.newLatLng(latLng));

				// Zoom in the Google Map
				map.animateCamera(CameraUpdateFactory.zoomTo(15));

				map.clear();
				map.addMarker(new MarkerOptions().title(name).position(latLng));

				// Show cab icon
				markerOptionsForCab = new MarkerOptions().title(name).position(new LatLng(latLng.latitude + 0.018, latLng.longitude + 0.018)).icon(BitmapDescriptorFactory.fromResource(R.drawable.transport));
				map.addMarker(markerOptionsForCab);
			}
		{

		}
	}

	@Override
	public void onConnectionSuspended(int i) {

	}

	@Override
	public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

	}
	public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 10000;
	public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS =
			UPDATE_INTERVAL_IN_MILLISECONDS / 2;

	GoogleApiClient mGoogleApiClient;
	LocationRequest mLocationRequest;
	protected synchronized void buildGoogleApiClient() {
		// Log.i("mGoogleApiClient", "Building GoogleApiClient");
		mGoogleApiClient = new GoogleApiClient.Builder(this)
				.addConnectionCallbacks(this)
				.addOnConnectionFailedListener(this)
				.addApi(LocationServices.API)
				.build();
		createLocationRequest();
		mGoogleApiClient.connect();
	}

	protected void createLocationRequest() {
		mLocationRequest = new LocationRequest();
		mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
		mLocationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
		mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
	}
}
