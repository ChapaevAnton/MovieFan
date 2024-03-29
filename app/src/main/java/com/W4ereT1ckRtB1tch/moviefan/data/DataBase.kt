package com.W4ereT1ckRtB1tch.moviefan.data

import com.W4ereT1ckRtB1tch.moviefan.R
import java.time.LocalDate
import java.time.Month

class DataBase {

    companion object {

        val filmDataBase: List<Film> =
            listOf(
                Film(
                    "Мстители: Финал", R.drawable.image1,
                    "Железный человек, Тор и другие пытаются переиграть Таноса. Эпохальное завершение супергеройской франшизы",
                    7.6f, LocalDate.of(2019, Month.APRIL, 22)
                ),
                Film(
                    "Не время умирать", R.drawable.image2,
                    "Джеймс Бонд оставил оперативную службу и наслаждается спокойной жизнью на Ямайке. " +
                            "Все меняется, когда на острове появляется его старый друг Феликс Лейтер из ЦРУ с просьбой о помощи.",
                    7.2f, LocalDate.of(2021, Month.SEPTEMBER, 30)
                ),
                Film(
                    "Парк Юрского периода", R.drawable.image3,
                    "Экспансивный богач и профессор уговаривает двух палеонтологов приехать на остров у побережья Коста-Рики, " +
                            "где он устроил парк Юрского периода. Парк населен давно вымершими динозаврами, воссозданными профессором по " +
                            "образцам крови из ископаемого комара, которые должны стать гвоздем программы нового аттракциона.",
                    7.6f, LocalDate.of(1993, Month.APRIL, 4), true
                ),
                Film(
                    "Назад в будущее", R.drawable.image4,
                    "Подросток Марти с помощью машины времени, сооружённой его другом-профессором доком Брауном, попадает из 80-х в далекие 50-е. " +
                            "Там он встречается со своими будущими родителями, ещё подростками, и другом-профессором, совсем молодым.",
                    8.6f, LocalDate.of(1985, Month.JULY, 3)
                ),
                Film(
                    "Мстители: Финал", R.drawable.image1,
                    "Железный человек, Тор и другие пытаются переиграть Таноса. Эпохальное завершение супергеройской франшизы",
                    7.6f, LocalDate.of(2019, Month.APRIL, 22)
                ),
                Film(
                    "Не время умирать", R.drawable.image2,
                    "Джеймс Бонд оставил оперативную службу и наслаждается спокойной жизнью на Ямайке. " +
                            "Все меняется, когда на острове появляется его старый друг Феликс Лейтер из ЦРУ с просьбой о помощи.",
                    7.2f, LocalDate.of(2021, Month.SEPTEMBER, 30)
                ),
                Film(
                    "Парк Юрского периода", R.drawable.image3,
                    "Экспансивный богач и профессор уговаривает двух палеонтологов приехать на остров у побережья Коста-Рики, " +
                            "где он устроил парк Юрского периода. Парк населен давно вымершими динозаврами, воссозданными профессором по " +
                            "образцам крови из ископаемого комара, которые должны стать гвоздем программы нового аттракциона.",
                    7.6f, LocalDate.of(1993, Month.APRIL, 4)
                ),
                Film(
                    "Назад в будущее", R.drawable.image4,
                    "Подросток Марти с помощью машины времени, сооружённой его другом-профессором доком Брауном, попадает из 80-х в далекие 50-е. " +
                            "Там он встречается со своими будущими родителями, ещё подростками, и другом-профессором, совсем молодым.",
                    8.6f, LocalDate.of(1985, Month.JULY, 3)
                )
            )
    }

}