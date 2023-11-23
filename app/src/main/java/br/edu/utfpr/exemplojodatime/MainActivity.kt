package br.edu.utfpr.exemplojodatime

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var fieldsFragment: fields_fragment
    private lateinit var dataPickerFragment: DataPickerFragment
    private lateinit var timepickerFragment: timepicker_fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fieldsFragment = fields_fragment()
        timepickerFragment = timepicker_fragment()


        setFragment(fieldsFragment)
    }

    fun calcularIdade(view: View) {
        fieldsFragment.calculaData()
    }

    private fun setFragment(fragment: Fragment) {
        val fragTransaction = supportFragmentManager.beginTransaction()

        fragTransaction.replace(R.id.container_fragment, fragment)

        fragTransaction.commit()
    }

}