package net.realizeideas.iphysics.question

import net.realizeideas.iphysics.common.BasePersistentObject

/**
 * @author Michael Astreiko
 */
class Question extends BasePersistentObject {
    String title
    String description
    String type

    //Maximum points student can earn if answer correct on this question
    BigDecimal maxPointsToEarn

    static hasMany = [answers: Answer]

    static belongsTo = [category:Category]

    static constraints = {
        type(inList: ["selectOne", "selectMany"])
        description(nullable: true)
    }

    String toString(){
        description
    }
}
