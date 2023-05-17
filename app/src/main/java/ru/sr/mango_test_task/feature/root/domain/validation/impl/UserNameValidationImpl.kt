package ru.sr.mango_test_task.feature.root.domain.validation.impl

import ru.sr.mango_test_task.feature.root.domain.validation.UserNameValidation

class UserNameValidationImpl : UserNameValidation {
    private val regUserName = Regex("^(.*[a-zA-Z-_0-9]{5,})")
    private val regName = Regex("^(.*[a-zA-Z- ]{3,})")

    override fun checkUserName(userName: String): Boolean {
        return regUserName.matchEntire(userName)?.value != null
    }

    override fun checkName(name: String): Boolean {
        return regName.matchEntire(name)?.value != null
    }
}