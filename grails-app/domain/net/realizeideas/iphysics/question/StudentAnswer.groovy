package net.realizeideas.iphysics.question

import net.realizeideas.iphysics.common.BasePersistentObject
import net.realizeideas.iphysics.User
import net.realizeideas.iphysics.exam.Exam

/**
 * @author Michael Astreiko
 */
class StudentAnswer extends BasePersistentObject{
    Question question
    Answer answer

    static belongsTo = [student:User, exam:Exam]
}
