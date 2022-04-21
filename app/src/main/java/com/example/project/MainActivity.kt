package com.example.project

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import com.example.project.LandmarkContent.addItem

class MainActivity : AppCompatActivity() {
    private var fromSelection : String? = "Christ the Redeemer"
    private var toSelection : String? = "Eiffel Tower"
    private var fromLandmark : String? = fromSelection
    private var toLandmark : String? = toSelection

    private var fromLatitude = 0.0
    private var fromLongitude = 0.0
    private var toLatitude = 0.0
    private var toLongitude = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val christ : LandmarkContent.LandmarkItem = LandmarkContent.LandmarkItem("Christ the Redeemer", -22.9519, -43.2105)

        addItem(LandmarkContent.LandmarkItem("Christ the Redeemer", -22.9519, -43.2105))
        addItem(LandmarkContent.LandmarkItem("Eiffel Tower", 48.8584, 2.2945))
        addItem(LandmarkContent.LandmarkItem("Golden Gate Bridge", 37.8199, -122.4783))
        addItem(LandmarkContent.LandmarkItem("Great Wall of China", 40.4319, 116.5704))
        addItem(LandmarkContent.LandmarkItem("Pyramids of Giza", 29.9792, 31.1342))
        addItem(LandmarkContent.LandmarkItem("Statue of Liberty", 40.6892, -74.0445))
        addItem(LandmarkContent.LandmarkItem("Sydney Opera House", -33.8568, 151.2153))



        val mapButton = findViewById<Button>(R.id.mapButton)

        val distanceText = findViewById<TextView>(R.id.distanceLabel)
        distanceText.text = "${fromLandmark} and ${toLandmark} are [BLANK] Miles apart"

        val fromSpinner = findViewById<Spinner>(R.id.fromSpinner)
        val toSpinner = findViewById<Spinner>(R.id.toSpinner)

        val adapter = ArrayAdapter.createFromResource(
            this, R.array.landmarks,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        )
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        fromSpinner.adapter = adapter
        toSpinner.adapter = adapter

        val fromPos = adapter.getPosition(fromSelection)
        fromSpinner.setSelection(fromPos)

        val toPos = adapter.getPosition(toSelection)
        toSpinner.setSelection(toPos)

        fromSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View?, i: Int, l: Long) {
                fromSelection = adapterView.getItemAtPosition(i) as String
                fromLandmark = fromSelection
                distanceText.text = "${fromLandmark} and ${toLandmark} are [BLANK] Miles apart"
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }

        toSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View?, i: Int, l: Long) {
                toSelection = adapterView.getItemAtPosition(i) as String
                toLandmark = toSelection
                distanceText.text = "${fromLandmark} and ${toLandmark} are [BLANK] Miles apart"
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }


        val fromLat = 25.0
        val fromLong = 25.0
        val toLat = -25.0
        val toLong = -25.0

        var individualLocationLauncher  = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
            }
        }

        mapButton.setOnClickListener{
            val intent = Intent(this@MainActivity, MapsActivity::class.java)
            fromLatitude = fromLat
            fromLongitude = fromLong
            intent.putExtra("fromLandmark", LandmarkContent.ITEMS[LandmarkContent.ITEMS.indexOf(christ)].name)
            intent.putExtra("fromLatitude", LandmarkContent.ITEMS[0].latitude)
            intent.putExtra("fromLongitude", LandmarkContent.ITEMS[0].longitude)

            toLatitude = toLat
            toLongitude = toLong
            intent.putExtra("toLatitude", toLatitude)
            intent.putExtra("toLongitude", toLongitude)
            intent.putExtra("toLandmark", toLandmark)

            individualLocationLauncher.launch(intent)
        }
    }
}