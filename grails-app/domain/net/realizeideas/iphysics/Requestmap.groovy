package net.realizeideas.iphysics
/**
 * @author Michael Astreiko
 */
class Requestmap {

    String url
    String configAttribute

    static mapping = {
        cache true
    }

    static constraints = {
        url blank: false, unique: true
        configAttribute blank: false
    }
}