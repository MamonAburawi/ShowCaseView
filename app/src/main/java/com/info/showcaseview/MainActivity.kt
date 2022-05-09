package com.info.showcaseview


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.info.showcaseview.databinding.ActivityMainBinding
import uk.co.samuelwall.materialtaptargetprompt.MaterialTapTargetPrompt
import uk.co.samuelwall.materialtaptargetprompt.extras.backgrounds.RectanglePromptBackground
import uk.co.samuelwall.materialtaptargetprompt.extras.focals.RectanglePromptFocal

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val prefManager by lazy { PrefManager(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // the prompt it will be started with ok button then fab button then home icon then search icon
        showPrompt()

    }



    private fun showPrompt(){
        if(!prefManager.isPrompt()){
            showOkButton()
        }
    }


    private fun showOkButton() { // start with ok button
        MaterialTapTargetPrompt.Builder(this)
            .setTarget(binding.btnOk)
            .setPrimaryText("click me!")
            .setSecondaryText("this is ok button")
            .setBackButtonDismissEnabled(true)
            .setPromptBackground(RectanglePromptBackground())
            .setPromptFocal(RectanglePromptFocal())
            .setPromptStateChangeListener{_,state ->
                if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                    || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED){
                    showFabPrompt()
                }

            }
            .show()
    }

    private fun showFabPrompt(){
        MaterialTapTargetPrompt.Builder(this)
            .setTarget(binding.fab)
            .setPrimaryText("click me!")
            .setSecondaryText("this is fab button")
            .setBackButtonDismissEnabled(true)
            .setPromptStateChangeListener{_,state ->
                if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                    || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED){
                    showHomePrompt()
                }
            }
            .show()
    }


    private fun showHomePrompt(){
        MaterialTapTargetPrompt.Builder(this)
            .setTarget(R.id.home)
            .setPrimaryText("click me!")
            .setSecondaryText("this is home button")
            .setBackButtonDismissEnabled(true)
            .setPromptStateChangeListener {_,state ->
                if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                    || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED){
                    showSearchPrompt()
                }
            }
            .show()
    }

    private fun showSearchPrompt(){
        MaterialTapTargetPrompt.Builder(this)
            .setTarget(R.id.search)
            .setPrimaryText("click me!")
            .setSecondaryText("this is search button")
            .setBackButtonDismissEnabled(true)
            .setPromptStateChangeListener {_,state ->
                if (state == MaterialTapTargetPrompt.STATE_FOCAL_PRESSED
                    || state == MaterialTapTargetPrompt.STATE_NON_FOCAL_PRESSED){
                    prefManager.setPrompt()
                }
            }
            .show()
    }









}