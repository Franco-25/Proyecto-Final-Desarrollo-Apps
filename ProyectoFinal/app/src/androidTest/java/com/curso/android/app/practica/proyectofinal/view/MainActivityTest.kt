package com.curso.android.app.practica.proyectofinal.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.proyectofinal.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_compareEqualTexts() {
        Espresso.onView(
            ViewMatchers.withId(R.id.editTextText)
        ).perform(
            ViewActions.typeText("Hola"),
            ViewActions.closeSoftKeyboard()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.editTextText2)
        ).perform(
            ViewActions.typeText("Hola"),
            ViewActions.closeSoftKeyboard()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compareButton)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.textView)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son iguales.")
            )
        )
    }

    @Test
    fun mainActivity_compareDifferentTexts() {
        Espresso.onView(
            ViewMatchers.withId(R.id.editTextText)
        ).perform(
            ViewActions.typeText("Hola"),
            ViewActions.closeSoftKeyboard()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.editTextText2)
        ).perform(
            ViewActions.replaceText("Hola cómo estás?"),
            ViewActions.closeSoftKeyboard()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compareButton)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.textView)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos no son iguales.")
            )
        )
    }
}