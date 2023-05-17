# Mango_test_task
# Тестовое задание : https://disk.yandex.ru/i/KSioreexTKt91g

#### Стек
- MVVM
- Kotlin Coroutines
- Flow
- Retroffit 
- Room
- Navigation component
- Dagger

Реализованно:
 - Динамическая масска ввода телефона в зависимости от страны. Маска меняется как при смене страны так и при смене кода
 - Валидация вводимых данных согласно тз
 - Навигая по фрагментам в зависимости от ответа от сервера(согласно ТЗ)
 - upload image через Base64
 - изменения некоторых данных пользователя(вот тут не совсем понятно, бек не может обратать все поля которые в Тз)
 - рефрешь токена в случае когда access token не действителен(в domain слое)
 - сверстаны два простых экрана для чата с использование RecyclerView. типов для рисования в одном адаптере всего два, поэтому решил не пользоваться адаптер делегатми
 - сохранения usera в БД, если пользователь раньше заходил с данного устройства то все данные грузятся локально
 Примечание:
 -В ТЗ нияего не сказана про проверку при запуске приложение на действующего пользователя, Поэтому для удобства тестирования каждый запуск приложения счиатется что в данный момент нет зарегестрированного пользователя

<p float="left">
<img src="https://github.com/SR-rodi/Mango_test_task/blob/main/screen/mask_1.jpg" width=20% height=20%>
<img src="https://github.com/SR-rodi/Mango_test_task/blob/main/screen/mask_2.jpg" width=20% height=20%>
<img src="https://github.com/SR-rodi/Mango_test_task/blob/main/screen/error.jpg" width=20% height=20%>
</p>

<p float="left">
<img src="https://github.com/SR-rodi/Mango_test_task/blob/main/screen/chat.jpg" width=20% height=20%>
<img src="https://github.com/SR-rodi/Mango_test_task/blob/main/screen/profile.jpg" width=20% height=20%>
</p>
