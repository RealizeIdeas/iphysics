package net.realizeideas.iphysics.question

import net.realizeideas.iphysics.common.BasePersistentObject

/**
 * Physics categories: Heat, Plasma
 *
 * @author Michael Astreiko
 */
class Category extends BasePersistentObject{
    String title
    String description

    static hasMany = [tasks:Question]
}
