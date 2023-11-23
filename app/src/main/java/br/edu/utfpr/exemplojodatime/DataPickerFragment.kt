package br.edu.utfpr.exemplojodatime

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import org.joda.time.DateTime
import java.util.Calendar

class DataPickerFragment(val callback: (result: DateTime) -> Unit) : Fragment(), DatePickerDialog.OnDateSetListener{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.datapicker_fragment, container, false)

        return view
    }

    override fun onDateSet(picker: DatePicker?, year: Int, month: Int, day: Int) {
        val monthString = (month + 1).toString()
        val dayString = day.toString()
        val yearString = year.toString()
        callback( DateTime(year, month, day, 0, 0))

    }


}