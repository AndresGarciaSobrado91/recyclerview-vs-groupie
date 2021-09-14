package com.garcia.recyclerviewvsgroupie.fragments.groupieFragment

import android.view.View
import com.garcia.recyclerviewvsgroupie.R
import com.garcia.recyclerviewvsgroupie.databinding.MockedDataItemViewBinding
import com.garcia.recyclerviewvsgroupie.domain.models.Ohlc
import com.xwray.groupie.viewbinding.BindableItem

class GroupieView(val ohlc: Ohlc, val callback: (Long) -> Unit): BindableItem<MockedDataItemViewBinding>(){

    override fun bind(viewBinding: MockedDataItemViewBinding, position: Int) {
        with(viewBinding){
            textViewPosition.text = position.toString()
            textViewTimestamp.text = ohlc.timestamp
        }
        if(position == 23)
            callback(System.currentTimeMillis())
    }

    override fun getLayout() = R.layout.mocked_data_item_view

    override fun initializeViewBinding(view: View): MockedDataItemViewBinding {
        return MockedDataItemViewBinding.bind(view)
    }
}