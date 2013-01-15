package net.realizeideas.iphysics.question

import net.realizeideas.iphysics.common.BasePersistentObject

/**
 * @author Michael Astreiko
 */
class Answer extends BasePersistentObject {
    Boolean isCorrect = false

    String value

    static belongsTo = [StudentAnswer, Question]

    @Override
    public String toString() {
        return value + (isCorrect ? " (correct)" : "");
    }
}
