package com.example.wally_app

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //R.layout.activity_main)

    }

    fun PressCalculate(view: View) {

        //Data Input
        val qA_text : TextView = text_q_A //findViewById(R.id.text_q_A)
        val temp0_text : TextView = text_T_0 // findViewById(R.id.text_T_2)
        val k_text : TextView = text_K //findViewById(R.id.text_K)
        val distance_text : TextView = text_distance

        //Strings
        var temp0_string :String = temp0_text.text.toString()
        var qA_string :String = qA_text.text.toString()
        var k_string :String = k_text.text.toString()
        var distance_string :String = distance_text.text.toString()

        //Verify if an Input is an Empty value
        //Temperature 0 at X=0 [°C -> Kelvin]
        if (temp0_string.isEmpty()) {
            temp0_string = "0"
        }

        //qA heat transfer by area unit [W/m^2]
        if (qA_string.isEmpty()){
            qA_string = "0"
        }

        //Conductivity [W/m/K]
        if (k_string.isEmpty()){
            k_string = "0"
        }

        //Distance [meters]
        if (distance_string.isEmpty()){
            distance_string = "0"
        }

        //Doubles
        var temp0_number :Double = temp0_string.toDouble()
        var qA_number :Double = qA_string.toDouble()
        var k_number :Double = k_string.toDouble()
        var distance_number :Double = distance_string.toDouble()


        //Operations ===================================================================

        val graph = graphman as GraphView //PART OF A GRAPH




        //Loop
        //temp0_number += 273.15 //°C to Kelvin

        var i = 0.0
        var tCount: Double = temp0_number
        var diff : Double = distance_number/1000

        var thePoints1 = mutableListOf<DataPoint>(DataPoint(0.0, temp0_number)) //First Point in the graph

        while (i <= distance_number ) {
            tCount += diff * qA_number / k_number
            i += diff
            thePoints1.add(DataPoint(i, tCount))
        }


        var result : Double = 0.0

        var result_text : TextView = calculation_1 //(R.id.calculation_1)

        result = tCount //temp0_number + qA_number + k_number +distance_number

        //End Operations =======================================

        when(view.id) {

            R.id.btnCalculate -> {
                result_text.setText("$result °C")
            }
        }

        // GRAPH =================================================

        var thePoints = thePoints1.toTypedArray() //arrayOf()
        val series: LineGraphSeries<DataPoint> = LineGraphSeries(thePoints) //

        graph.addSeries(series)


        //Experiments Section
        //var listMutable = mutableListOf<DataPoint>()


    }
}