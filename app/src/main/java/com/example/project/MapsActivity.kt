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
        }
        if (intent.hasExtra("fromLongitude")) {
            fromLongitude = intent.getDoubleExtra("fromLongitude", 0.0)
        }
        if (intent.hasExtra("fromLandmark")) {
            fromLandmark = intent.getStringExtra("fromLandmark")
        }
        if (intent.hasExtra("toLatitude")) {
            toLatitude = intent.getDoubleExtra("toLatitude", 0.0)
        }
        if (intent.hasExtra("toLongitude")) {
            toLongitude = intent.getDoubleExtra("toLongitude", 0.0)
        }
        if (intent.hasExtra("toLandmark")) {
            toLandmark = intent.getStringExtra("toLandmark")
        }

        mMap = googleMap

        // Get the location of the from landmark
        val fromLocation = LatLng(fromLatitude, fromLongitude)

        // variables for adding images to map
        val christ1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.christ))
            .position(fromLocation, 900000f, 900000f)
        val eiffel1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.eiffel))
            .position(fromLocation, 900000f, 900000f)
        val ggb1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.ggb))
            .position(fromLocation, 900000f, 900000f)
        val giza1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.giza))
            .position(fromLocation, 900000f, 900000f)
        val gwoc1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.gwoc))
            .position(fromLocation, 900000f, 900000f)
        val liberty1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.liberty))
            .position(fromLocation, 900000f, 900000f)
        val soh1 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.soh))
            .position(fromLocation, 900000f, 900000f)

        // Add images of from landmark to map and set hue
        when (fromLandmark) {
            "Christ the Redeemer" ->{
                mMap.addMarker(MarkerOptions().position(fromLocation).title("${fromLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)))
                mMap.addGroundOverlay(christ1)
            }
            "Eiffel Tower" -> {
                mMap.addMarker(MarkerOptions().position(fromLocation).title("${fromLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
                mMap.addGroundOverlay(eiffel1)
            }
            "Golden Gate Bridge" -> {
                mMap.addMarker(MarkerOptions().position(fromLocation).title("${fromLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
                mMap.addGroundOverlay(ggb1)
            }
            "Pyramids of Giza" -> {
                mMap.addMarker(MarkerOptions().position(fromLocation).title("${fromLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
                mMap.addGroundOverlay(giza1)
            }
            "Great Wall of China" -> {
                mMap.addMarker(MarkerOptions().position(fromLocation).title("${fromLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
                mMap.addGroundOverlay(gwoc1)
            }
            "Statue of Liberty" -> {
                mMap.addMarker(MarkerOptions().position(fromLocation).title("${fromLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)))
                mMap.addGroundOverlay(liberty1)
            }
            "Sydney Opera House" -> {
                mMap.addMarker(MarkerOptions().position(fromLocation).title("${fromLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
                mMap.addGroundOverlay(soh1)
            }
        }

        // Get the location of the to landmark
        val toLocation = LatLng(toLatitude, toLongitude)

        // variables for adding images to map
        val christ2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.christ))
            .position(toLocation, 900000f, 900000f)
        val eiffel2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.eiffel))
            .position(toLocation, 900000f, 900000f)
        val ggb2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.ggb))
            .position(toLocation, 900000f, 900000f)
        val giza2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.giza))
            .position(toLocation, 900000f, 900000f)
        val gwoc2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.gwoc))
            .position(toLocation, 900000f, 900000f)
        val liberty2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.liberty))
            .position(toLocation, 900000f, 900000f)
        val soh2 = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.soh))
            .position(toLocation, 900000f, 900000f)

        // Add images of to landmark to map and change hue
        when (toLandmark) {
            "Christ the Redeemer" -> {
                mMap.addMarker(MarkerOptions().position(toLocation).title("${toLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)))
                mMap.addGroundOverlay(christ2)
            }
            "Eiffel Tower" -> {
                mMap.addMarker(MarkerOptions().position(toLocation).title("${toLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)))
                mMap.addGroundOverlay(eiffel2)
            }
            "Golden Gate Bridge" -> {
                mMap.addMarker(MarkerOptions().position(toLocation).title("${toLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)))
                mMap.addGroundOverlay(ggb2)
            }
            "Pyramids of Giza" -> {
                mMap.addMarker(MarkerOptions().position(toLocation).title("${toLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)))
                mMap.addGroundOverlay(giza2)
            }
            "Great Wall of China" -> {
                mMap.addMarker(MarkerOptions().position(toLocation).title("${toLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)))
                mMap.addGroundOverlay(gwoc2)
            }
            "Statue of Liberty" -> {
                mMap.addMarker(MarkerOptions().position(toLocation).title("${toLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE)))
                mMap.addGroundOverlay(liberty2)
            }
            "Sydney Opera House" -> {
                mMap.addMarker(MarkerOptions().position(toLocation).title("${toLandmark} Marker")
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))
                mMap.addGroundOverlay(soh2)
            }
        }

        // Add a line connecting the landmarks
        val polylineOptions = PolylineOptions()
            .add(LatLng(fromLatitude, fromLongitude))
            .add(LatLng(toLatitude, toLongitude))
        val polyline = mMap.addPolyline(polylineOptions)

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}