package com.garcia.recyclerviewvsgroupie

import androidx.lifecycle.ViewModel
import com.garcia.recyclerviewvsgroupie.domain.mock.DomainObjectMocks
import com.garcia.recyclerviewvsgroupie.domain.models.Ohlc

class MainViewModel : ViewModel() {

    val mockedData: List<Ohlc> by lazy {
        DomainObjectMocks.getMockedData()
    }

    var recyclerStartTime = 0L
    var recyclerEndTime = 0L
    var groupieStartTime = 0L
    var groupieEndTime = 0L
}