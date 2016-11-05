package com.markodevcic.kvalidation

import com.markodevcic.kvalidation.errors.ErrorLevel
import com.markodevcic.kvalidation.messages.CustomMessageBuilder
import com.markodevcic.kvalidation.messages.MessageBuilder

class OnErrorSetter<T, TFor>(private val propertyContext: PropertyContext<T, TFor>) {

    infix fun errorMessage(message: String) {
        val messageBuilder = CustomMessageBuilder(message)
        propertyContext.validators.forEach { v -> v.messageBuilder = messageBuilder }
    }

    infix fun errorMessage(messageBuilder: MessageBuilder) {
        propertyContext.validators.forEach { v -> v.messageBuilder = messageBuilder }
    }

    infix fun errorCode(code: Int) {
        propertyContext.validators.forEach { v -> v.errorCode = code }
    }

    infix fun errorLevel(errorLevel: ErrorLevel) {
        propertyContext.validators.forEach { v -> v.errorLevel = errorLevel }
    }

    infix fun propertyName(name: String)  {
        propertyContext.propertyName = name
    }
}