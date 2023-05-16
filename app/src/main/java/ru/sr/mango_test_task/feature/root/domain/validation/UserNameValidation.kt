package ru.sr.mango_test_task.feature.root.domain.validation

interface UserNameValidation {

    fun checkUserName(userName:String):Boolean
    fun checkName(name:String):Boolean
}