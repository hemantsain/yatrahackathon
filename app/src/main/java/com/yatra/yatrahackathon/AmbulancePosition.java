package com.yatra.yatrahackathon;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AmbulancePosition extends Activity implements LocationListener {

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
                double newLatitude = latLng.latitude + 0.018;
                double newLongitude = latLng.longitude + 0.018;
                for (int i = 17; i >= 0; i--) {
                    newLatitude -= 0.001;
                    newLongitude -= 0.001;

//                    if (markerOptionsForCab != null) {
                        markerOptionsForCab.position(new LatLng(newLatitude, newLongitude));
//                        map.addMarker(new MarkerOptions().title(name).position(new LatLng(newLatitude, newLongitude)).icon(BitmapDescriptorFactory.fromResource(R.drawable.transport)));
//                    }

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (i == 0) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(AmbulancePosition.this).setTitle("Alert").setMessage("You cab has been reached to your door!\nTime to move on!");

                        Dialog dialog = builder.create();
                        dialog.show();
                    }
                }
            }
        });
	}

	private void setAmbLocation(double lat, double lon) {
		LatLng latLng = new LatLng(lat, lon);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));

		map.addMarker(new MarkerOptions().title("").position(latLng));

	}

	@Override
	public void onLocationChanged(Location location) {
		if (latLng == null) {
			latLng = new LatLng(location.getLatitude(), location.getLongitude());

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
}
