package net.realizeideas.iphysics.exam

import net.realizeideas.iphysics.common.BasePersistentObject
import net.realizeideas.iphysics.User
import net.realizeideas.iphysics.question.Question
import net.realizeideas.iphysics.question.StudentAnswer

/**
 * @author Michael Astreiko
 */
class Exam extends BasePersistentObject {
    User student

    static hasMany = [questions:Question, studentAnswers:StudentAnswer]

    BigDecimal getTotalPointsEarned() {
        BigDecimal result = 0
        studentAnswers?.each {StudentAnswer studentAnswer ->
            if (questions.find {it == studentAnswer.question}.answers.find {it.isCorrect}.value == studentAnswer.answer.value) {
                result++
            }
        }
        result
    }


}
