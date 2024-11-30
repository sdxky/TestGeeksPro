package com.example.testgeekspro.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testgeekspro.data.CarModel
import com.example.testgeekspro.databinding.ItemCarBinding

class CarAdapter(
    private val carList: List<CarModel>, private val onCLick: (CarModel) -> Unit,
) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.ViewHolder {
        return ViewHolder(
            ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CarAdapter.ViewHolder, position: Int) {
        holder.bind(carList[position])
    }

    override fun getItemCount(): Int = carList.size

    inner class ViewHolder(private val binding: ItemCarBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(model: CarModel) = with(binding) {
            tvName.text = model.name
            tvYear.text = model.year
            Glide.with(imgCar).load(model.img).into(imgCar)

            itemView.setOnClickListener {
                onCLick(model)
            }
        }
    }
}