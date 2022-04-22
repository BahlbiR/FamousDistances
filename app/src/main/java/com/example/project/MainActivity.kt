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

    private var fromIndex = 0
    private var toIndex = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val christ : LandmarkContent.LandmarkItem = LandmarkContent.LandmarkItem("Christ the Redeemer", -22.9519, -43.2105)
        val eiffel : LandmarkContent.LandmarkItem = LandmarkContent.LandmarkItem("Eiffel Tower", 48.8584, 2.2945)
        val gate : LandmarkContent.LandmarkItem = LandmarkContent.LandmarkItem("Golden Gate Bridge", 37.8199, -122.4783)
        val wall : LandmarkContent.LandmarkItem = LandmarkContent.LandmarkItem("Great Wall of China", 40.4319, 116.5704)
        val pyramids : LandmarkContent.LandmarkItem = LandmarkContent.LandmarkItem("Pyramids of Giza", 29.9792, 31.1342)
        val statue : LandmarkContent.LandmarkItem = LandmarkContent.LandmarkItem("Statue of Liberty", 40.6892, -74.0445)
        val opera : LandmarkContent.LandmarkItem = LandmarkContent.LandmarkItem("Sydney Opera House", -33.8568, 151.2153)

        addItem(christ)
        addItem(eiffel)
        addItem(gate)
        addItem(wall)
        addItem(pyramids)
        addItem(statue)
        addItem(opera)



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

                if (fromLandmark == "Christ the Redeemer"){
                    fromIndex = 0
                }
                else if (fromLandmark == "Eiffel Tower"){
                    fromIndex = 1
                }
                else if (fromLandmark == "Golden Gate Bridge"){
                    fromIndex = 2
                }
                else if (fromLandmark == "Great Wall of China"){
                    fromIndex = 3
                }
                else if (fromLandmark == "Pyramids of Giza"){
                    fromIndex = 4
                }
                else if (fromLandmark == "Statue of Liberty"){
                    fromIndex = 5
                }
                else if (fromLandmark == "Sydney Opera House"){
                    fromIndex = 6
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }

        toSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>, view: View?, i: Int, l: Long) {
                toSelection = adapterView.getItemAtPosition(i) as String
                toLandmark = toSelection
                distanceText.text = "${fromLandmark} and ${toLandmark} are [BLANK] Miles apart"

                if (toLandmark == "Christ the Redeemer"){
                    toIndex = 0
                }
                else if (toLandmark == "Eiffel Tower"){
                    toIndex = 1
                }
                else if (toLandmark == "Golden Gate Bridge"){
                    toIndex = 2
                }
                else if (toLandmark == "Great Wall of China"){
                    toIndex = 3
                }
                else if (toLandmark == "Pyramids of Giza"){
                    toIndex = 4
                }
                else if (toLandmark == "Statue of Liberty"){
                    toIndex = 5
                }
                else if (toLandmark == "Sydney Opera House"){
                    toIndex = 6
                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
        
        var individualLocationLauncher  = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
            }
        }

        mapButton.setOnClickListener{
            val intent = Intent(this@MainActivity, MapsActivity::class.java)

            intent.putExtra("fromLandmark", LandmarkContent.ITEMS[fromIndex].name)
            intent.putExtra("fromLatitude", LandmarkContent.ITEMS[fromIndex].latitude)
            intent.putExtra("fromLongitude", LandmarkContent.ITEMS[fromIndex].longitude)

            intent.putExtra("toLandmark", LandmarkContent.ITEMS[toIndex].name)
            intent.putExtra("toLatitude", LandmarkContent.ITEMS[toIndex].latitude)
            intent.putExtra("toLongitude", LandmarkContent.ITEMS[toIndex].longitude)

            individualLocationLauncher.launch(intent)
        }
    }
}