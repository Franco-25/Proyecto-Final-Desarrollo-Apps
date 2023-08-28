package com.curso.android.app.practica.proyectofinal.view

import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.proyectofinal.model.Texts

class MainViewModel : ViewModel() {

    val texts = Texts()
    private var result = ""

    fun setText1 (text: String) {
        texts.text1 = text
    }

    fun setText2 (text: String) {
        texts.text2 = text
    }

    fun compareTexts () {
        result =  if (texts.text1 == texts.text2) {
            "Los textos son iguales."
        } else {
            "Los textos no son iguales."
        }
    }

    fun getResult() : String {
        return result
    }
}