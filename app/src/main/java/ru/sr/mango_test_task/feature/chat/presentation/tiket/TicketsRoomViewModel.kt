package ru.sr.mango_test_task.feature.chat.presentation.tiket

import androidx.lifecycle.ViewModel
import ru.sr.mango_test_task.feature.chat.presentation.tiket.model.Ticket

class TicketsRoomViewModel : ViewModel() {
    val listTickets = listOf(
        Ticket("Как устроиться на работу?","0:46","Valera","18.05.23"),
        Ticket("Я прошел тестовое?","0:11","Ignat","17.05.23"),
        Ticket("Что делать на выходных?","2:40","Rustam","21.05.23"),
        Ticket("Просто по кайфу","1:46","Vay","19.05.23"),
    )
}