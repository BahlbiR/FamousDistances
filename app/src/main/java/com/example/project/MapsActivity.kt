package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.example.project.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.*

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



        // Add a marker to the from location and move the camera
        val fromLocation = LatLng(fromLatitude, fromLongitude)
        mMap.addMarker(MarkerOptions().position(fromLocation).title("${fromLandmark} Marker"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(FROM_LOCATION_NAME_HERE, 15f))

        // variables for adding images to map
        val christ1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.christ))
            .position(fromLocation, 3000000f, 3000000f)
        val eiffel1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.eiffel))
            .position(fromLocation, 3000000f, 3000000f)
        val ggb1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.ggb))
            .position(fromLocation, 3000000f, 3000000f)
        val giza1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.giza))
            .position(fromLocation, 3000000f, 3000000f)
        val gwoc1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.gwoc))
            .position(fromLocation, 3000000f, 3000000f)
        val liberty1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.liberty))
            .position(fromLocation, 3000000f, 3000000f)
        val soh1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.soh))
            .position(fromLocation, 3000000f, 3000000f)

        // Add images of from landmark to map
        when (fromLandmark) {
            "Christ the Redeemer" -> mMap.addGroundOverlay(christ1)
            "Eiffel Tower" -> mMap.addGroundOverlay(eiffel1)
            "Golden Gate Bridge" -> mMap.addGroundOverlay(ggb1)
            "Pyramids of Giza" -> mMap.addGroundOverlay(giza1)
            "Great Wall of China" -> mMap.addGroundOverlay(gwoc1)
            "Statue of Liberty" -> mMap.addGroundOverlay(liberty1)
            "Sydney Opera House" -> mMap.addGroundOverlay(soh1)
        }


        val toLocation = LatLng(toLatitude, toLongitude)
        mMap.addMarker(MarkerOptions().position(toLocation).title("${toLandmark} Marker"))

        // variables for adding images to map
        val christ2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.christ))
            .position(toLocation, 3000000f, 3000000f)
        val eiffel2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.eiffel))
            .position(toLocation, 3000000f, 3000000f)
        val ggb2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.ggb))
            .position(toLocation, 3000000f, 3000000f)
        val giza2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.giza))
            .position(toLocation, 3000000f, 3000000f)
        val gwoc2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.gwoc))
            .position(toLocation, 3000000f, 3000000f)
        val liberty2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.liberty))
            .position(toLocation, 3000000f, 3000000f)
        val soh2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.soh))
            .position(toLocation, 3000000f, 3000000f)

        // Add images of from landmark to map
        when (toLandmark) {
            "Christ the Redeemer" -> mMap.addGroundOverlay(christ2)
            "Eiffel Tower" -> mMap.addGroundOverlay(eiffel2)
            "Golden Gate Bridge" -> mMap.addGroundOverlay(ggb2)
            "Pyramids of Giza" -> mMap.addGroundOverlay(giza2)
            "Great Wall of China" -> mMap.addGroundOverlay(gwoc2)
            "Statue of Liberty" -> mMap.addGroundOverlay(liberty2)
            "Sydney Opera House" -> mMap.addGroundOverlay(soh2)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}