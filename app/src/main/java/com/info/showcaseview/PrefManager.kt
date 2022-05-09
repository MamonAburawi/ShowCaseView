package com.info.showcaseview

import android.content.Context

class PrefManager(private val context: Context) {
    companion object{
        private const val PROMPT_FILE = "PromptFile"
        private const val PROMPT_KEY = "Prompt"
    }
    private val sharedPref = context.getSharedPreferences(PROMPT_FILE, Context.MODE_PRIVATE)
    private val edit = sharedPref.edit()


    fun setPrompt(){
        edit.putBoolean(PROMPT_KEY,true)
        edit.commit()
        edit.apply()
    }

    fun isPrompt(): Boolean {
        return sharedPref.getBoolean(PROMPT_KEY, false)
    }



}