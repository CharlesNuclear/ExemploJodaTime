package br.edu.utfpr.exemplojodatime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import org.joda.time.DateTime
import org.joda.time.LocalDate
import org.joda.time.Period
import org.joda.time.PeriodType
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.seconds

class fields_fragment : Fragment() {

    private lateinit var dataPrimaria: EditText
    private lateinit var dataSecundaria: EditText
    private lateinit var horaPrimaria: EditText
    private lateinit var horaSecundaria: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fields_fragment, container, false)

        dataPrimaria   = view.findViewById(R.id.etDataPrimaria)
        dataSecundaria = view.findViewById(R.id.etDataSecundaria)
        horaPrimaria   = view.findViewById(R.id.etHoraPrimaria)
        horaSecundaria = view.findViewById(R.id.etHoraSecundaria)

        return view
    }

    fun calculaData(){
        val datePrimaria: LocalDate =
                LocalDate.fromDateFields(
                    SimpleDateFormat("dd/MM/yyyy").
                    parse(dataPrimaria.text.toString()))

        val dateSecundaria: LocalDate =
                LocalDate.fromDateFields(
                    SimpleDateFormat("dd/MM/yyyy").
                    parse(dataSecundaria.text.toString()))

        val horaPrimaria: Date =
                SimpleDateFormat("HH:mm").
                   parse(horaPrimaria.text.toString())

        val horaSecundaria: Date =
                SimpleDateFormat("HH:mm").
                   parse(horaSecundaria.text.toString())

        var dtInicio =
              DateTime(datePrimaria.year, datePrimaria.monthOfYear, datePrimaria.dayOfMonth,
             12, horaPrimaria.hours, horaPrimaria.minutes, 0);

        var dtFim =
             DateTime(dateSecundaria.year, dateSecundaria.monthOfYear, dateSecundaria.dayOfMonth,
                 12, horaSecundaria.hours, horaPrimaria.minutes, 0);

        val period = Period(dtInicio, dtFim, PeriodType.yearMonthDay())

        val builder = getActivity()?.let { AlertDialog.Builder(it) }
        builder?.setTitle("Tempo Passado")
        builder?.setMessage("Anos passados: ${period.years}, " +
                            "Meses passados: ${period.months}, " +
                            "Dias Passados: ${period.days}")
        builder?.show()
    }
}