package com.example.testgeekspro.ui.fragment.detailCar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.testgeekspro.R
import com.example.testgeekspro.data.CarModel
import com.example.testgeekspro.databinding.FragmentDetailCarBinding
import com.example.testgeekspro.utils.Keys


class DetailCarFragment : Fragment() {

    private val binding by lazy {
        FragmentDetailCarBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.carFragment)
        }
    }

    private fun getData() {
        val model = arguments?.getSerializable(Keys.KEYS_FOR_CAR) as CarModel
        binding.apply {
            tvName.text = model.name
            tvYear.text = model.year
            Glide.with(imgCar).load(model.img).into(imgCar)
        }
    }
}
