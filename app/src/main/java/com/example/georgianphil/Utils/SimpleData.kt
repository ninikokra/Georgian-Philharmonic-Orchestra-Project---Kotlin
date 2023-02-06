package com.example.georgianphil.Utils

import com.example.georgianphil.Model.ConcertsModel
import com.example.georgianphil.Model.ConcertsMainModel

object SimpleData {

    private val ConcertsModel = listOf(
        ConcertsModel(concertsImgURL.image1),
        ConcertsModel(concertsImgURL.image2),
        ConcertsModel(concertsImgURL.image3),
        ConcertsModel(concertsImgURL.image4),
        ConcertsModel(concertsImgURL.image5),
        ConcertsModel(concertsImgURL.image6),
        ConcertsModel(concertsImgURL.image7)
    )

    val collections = listOf(
        ConcertsMainModel("Upcoming Concerts", ConcertsModel),
        ConcertsMainModel("Archive Concerts", ConcertsModel.reversed())

    )
}