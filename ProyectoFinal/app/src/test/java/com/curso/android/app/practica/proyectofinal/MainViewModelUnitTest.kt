package com.curso.android.app.practica.proyectofinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.proyectofinal.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckEditText() = runTest {
        val value = viewModel.texts.text1
        assertEquals("",value)
    }

    @Test
    fun mainViewModel_CheckEditText2() = runTest {
        val value = viewModel.texts.text2
        assertEquals("",value)
    }

    @Test
    fun mainViewModel_TestSetText1() = runTest {
        launch {
            viewModel.setText1("Hola")
        }
        advanceUntilIdle()
        val value = viewModel.texts.text1
        assertEquals( "Hola", value)
    }

    @Test
    fun mainViewModel_TestSetText2() = runTest {
        launch {
            viewModel.setText2("Hola de nuevo")
        }
        advanceUntilIdle()
        val value = viewModel.texts.text2
        assertEquals( "Hola de nuevo", value)
    }

    @Test
    fun mainViewModel_TestCompareTexts() = runTest {
        launch {
            viewModel.setText1("Hola cómo estás?")
            viewModel.setText2("Hola cómo estás?")
            viewModel.compareTexts()
        }
        advanceUntilIdle()
        val value = viewModel.getResult()
        assertEquals( "Los textos son iguales.", value)
    }

    @Test
    fun mainViewModel_TestCompareDifferentTexts() = runTest {
        launch {
            viewModel.setText1("Hola cómo estás?")
            viewModel.setText2("Hola estoy bien y vos??")
            viewModel.compareTexts()
        }
        advanceUntilIdle()
        val value = viewModel.getResult()
        assertEquals( "Los textos no son iguales.", value)
    }
}