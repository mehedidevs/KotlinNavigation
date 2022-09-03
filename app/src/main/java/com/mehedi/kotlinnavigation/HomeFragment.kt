package com.mehedi.kotlinnavigation


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mehedi.kotlinnavigation.databinding.FragmentHomeBinding
import java.text.DecimalFormat

class HomeFragment : Fragment() {
    var binding: FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.calculateBtn.setOnClickListener {
            calculateBmi(
                binding!!.heightEdt.text.toString(), binding!!.weightEdt.text.toString()
            )
        }
    }

    private fun calculateBmi(heightStr: String, weight: String) {
        val height = heightStr.toDouble() * 0.3048
        val bmiScore = weight.toDouble() / (height * height)
        val decimalFormat = DecimalFormat("#.0")
        val bmi = decimalFormat.format(bmiScore)
        val bmiMessage = BmiMessage()
        Log.i("TAG", "calculateBmi: $bmi")
        binding!!.tvMyBmiScore.text = bmiMessage.getMessage(bmiScore) + " With " + bmi
    }
}