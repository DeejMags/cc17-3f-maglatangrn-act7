package com.example.mycityapp.data

import com.example.mycityapp.R

object DataSource {

    val defaultCategory = Category(
        name = R.string.defualt_name,
        picture = R.drawable.westside,
        reccomendationList = listOf()
    )

    val defaultReccomendation = Reccomendation(
        title = R.string.defualt_name,
        text = R.string.defualt_name,
        image = R.drawable.starfitness
    )

    val categories = listOf(

        //Sights
        Category(
            name = R.string.category_1,
            picture = R.drawable.pugad,
            reccomendationList = listOf(
                Reccomendation(
                    title = R.string.C1_Reccomendation1,
                    text = R.string.C1_Reccomendation1_text,
                    image = R.drawable.pugad
                ),
                Reccomendation(
                    title = R.string.C1_Reccomendation2,
                    text = R.string.C1_Reccomendation2_text,
                    image = R.drawable.tapuacan
                ),
                Reccomendation(
                    title = R.string.C1_Reccomendation3,
                    text = R.string.C1_Reccomendation3_text,
                    image = R.drawable.kultura
                ),
                Reccomendation(
                    title = R.string.C1_Reccomendation4,
                    text = R.string.C1_Reccomendation4_text,
                    image = R.drawable.ambangonan
                ),
                Reccomendation(
                    title = R.string.C1_Reccomendation5,
                    text = R.string.C1_Reccomendation5_text,
                    image = R.drawable.holy
                )
            )
        ),

        //Food Place
        Category(
            name = R.string.category_2,
            picture = R.drawable.inihawrepublic,
            reccomendationList = listOf(
                Reccomendation(
                    title = R.string.C2_Reccomendation1,
                    text = R.string.C2_Reccomendation1_text,
                    image = R.drawable.kambak
                ),
                Reccomendation(
                    title = R.string.C2_Reccomendation2,
                    text = R.string.C2_Reccomendation2_text,
                    image = R.drawable.cafeinthesky
                ),
                Reccomendation(
                    title = R.string.C2_Reccomendation3,
                    text = R.string.C2_Reccomendation3_text,
                    image = R.drawable.inihawrepublic
                ),
                Reccomendation(
                    title = R.string.C2_Reccomendation4,
                    text = R.string.C2_Reccomendation4_text,
                    image = R.drawable.soulcafe
                ),
                Reccomendation(
                    title = R.string.C2_Reccomendation5,
                    text = R.string.C2_Reccomendation5_text,
                    image = R.drawable.matutinas
                )
            )
        ),

        //Gym
        Category(
            name = R.string.category_3,
            picture = R.drawable.westside,
            reccomendationList = listOf(
                Reccomendation(
                    title = R.string.C3_Reccomendation1,
                    text = R.string.C3_Reccomendation1_text,
                    image = R.drawable.westside
                ),
                Reccomendation(
                    title = R.string.C3_Reccomendation2,
                    text = R.string.C3_Reccomendation2_text,
                    image = R.drawable.starfitness
                )
            )
        ),

        //Fun place
        Category(
            name = R.string.category_4,
            picture = R.drawable.bato_de_luna,
            reccomendationList = listOf(
                Reccomendation(
                    title = R.string.C4_Reccomendation1,
                    text = R.string.C4_Reccomendation1_text,
                    image = R.drawable.bahay_na_bato_la_union
                ),
                Reccomendation(
                    title = R.string.C4_Reccomendation2,
                    text = R.string.C4_Reccomendation2_text,
                    image = R.drawable.bato_de_luna
                ),
                Reccomendation(
                    title = R.string.C4_Reccomendation3,
                    text = R.string.C4_Reccomendation3_text,
                    image = R.drawable.immuki_island
                ),
                Reccomendation(
                    title = R.string.C4_Reccomendation4,
                    text = R.string.C4_Reccomendation4_text,
                    image = R.drawable.la_union_grape_picking
                )
            )
        )
    )
}