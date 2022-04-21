package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.project.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private var fromLatitude = 0.0
    private var fromLongitude = 0.0
    private var toLatitude = 0.0
    private var toLongitude = 0.0
    private var fromLandmark : String? = "Christ the Redeemer"
    private var toLandmark : String? = "Eiffel Tower"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    override fun onMapReady(googleMap: GoogleMap) {
        if (intent.hasExtra("fromLatitude")) {
            fromLatitude = intent.getDoubleExtra("fromLatitude", 0.0)
            //latitude = data?.getDoubleExtra("latitude", 0.0) ?: 0.0
        }
        if (intent.hasExtra("fromLongitude")) {
            fromLongitude = intent.getDoubleExtra("fromLongitude", 0.0)
            //longitude = data?.getDoubleExtra("longitude", 0.0) ?: 0.0
        }
        if (intent.hasExtra("fromLandmark")) {
            fromLandmark = intent.getStringExtra("fromLandmark")
            //latitude = data?.getDoubleExtra("latitude", 0.0) ?: 0.0
        }

        if (intent.hasExtra("toLatitude")) {
            toLatitude = intent.getDoubleExtra("toLatitude", 0.0)
            //latitude = data?.getDoubleExtra("latitude", 0.0) ?: 0.0
        }
        if (intent.hasExtra("toLongitude")) {
            toLongitude = intent.getDoubleExtra("toLongitude", 0.0)
            //longitude = data?.getDoubleExtra("longitude", 0.0) ?: 0.0
        }
        if (intent.hasExtra("toLandmark")) {
            toLandmark = intent.getStringExtra("toLandmark")
            //longitude = data?.getDoubleExtra("longitude", 0.0) ?: 0.0
        }

        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val fromLocation = LatLng(fromLatitude, fromLongitude)
        mMap.addMarker(MarkerOptions().position(fromLocation).title("${fromLandmark} Marker"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(FROM_LOCATION_NAME_HERE, 15f))

        val toLocation = LatLng(toLatitude, toLongitude)
        mMap.addMarker(MarkerOptions().position(toLocation).title("${toLandmark} Marker"))

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}