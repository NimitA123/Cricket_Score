package com.example.cricketscore

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.cricketscore.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count:Int = 8
    private var viratScore = 5
    private var ns = 3
    private var score = 8
    private var run = 0;
    private var over = 1
    private var point = 3
    private var overball = 9
    private var randomValues = 0
    private var viratBoolean = true
    private var jsBoolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

            binding.bowlButton.setOnClickListener {

                  if (count <= 40 && !binding.overPoint.text.toString().equals("4")) {
                      randomValues = Random.nextInt(1, 7)
                    if(viratBoolean) {
                        binding.kiratBohliStrike.visibility = View.VISIBLE
                          viratScore+=randomValues
                          binding.viratScore.text = viratScore.toString()
                          if(randomValues==1 || randomValues == 3 ||  randomValues == 5 || binding.overBall.text.toString().equals("6")){
                              if(binding.overBall.text.toString().equals("6") && (randomValues==1 || randomValues == 3 ||  randomValues == 5 )){

                              }
                              else {
                                  viratBoolean = false
                                  binding.kiratBohliStrike.visibility = View.INVISIBLE
                                  binding.nsNodhiStrike.visibility = View.VISIBLE
                              }
                          }
                    }
                    else {
                          binding.nsNodhiStrike.visibility = View.VISIBLE
                          ns += randomValues
                          binding.nsScore.text = ns.toString()
                          if(randomValues == 1 || randomValues == 3 || randomValues == 5 || binding.overBall.text.toString().equals("6")){
                              if(binding.overBall.text.toString().equals("6") && (randomValues==1 || randomValues == 3 ||  randomValues == 5 )){

                              }else{
                                  binding.nsNodhiStrike.visibility = View.INVISIBLE
                                  binding.kiratBohliStrike.visibility = View.VISIBLE
                                  viratBoolean = true
                              }

                          }
                      }
                      overball++
                      binding.overBall.text = overball.toString()
                      run = randomValues
                      binding.run.text = run.toString()
                      score += randomValues
                      binding.ScorePoint.text = score.toString()
                      Log.d("RandomValue", "onCreate: $randomValues")

                      if(point < 6){
                          point++
                          binding.overBall.text = point.toString()
                      }
                      else{
                          over++
                          binding.overPoint.text =  over.toString()
                          binding.overBall.text = "0"
                          point = 0
                      }
                  } else {
                      if(count >= 40) {
                          var remaining = 36 - overball
                          Toast.makeText(
                              this,
                              "Bangalore Won the match 1 Wicket and $remaining are remaining",
                              Toast.LENGTH_LONG
                          ).show()
                      }
                      else{

                          Toast.makeText(this, "Bangalore lost the match by 2 wicket", Toast.LENGTH_SHORT).show()
                      }
                  }
                  count += randomValues
               //   overball++

              }




        }


}
