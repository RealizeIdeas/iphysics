package net.realizeideas.iphysics.common

/**
 * @author Michael Astreiko
 */
abstract class BasePersistentObject implements Serializable {
   transient springSecurityService

    static mapping = {
        tablePerHierarchy false
    }

    Date dateCreated // autoupdated by GORM
    Date lastUpdated // autoupdated by GORM
    String createdBy

    static constraints = {
        createdBy(nullable: true)
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
    }

    def beforeInsert() {
        if (!createdBy) {
            //Need to determine user who created object

            // use '?' after springSecurityService because there is a bug in Grails:
            //when populating collection of object like user.addCommission or venue.addVideo related objects
            //(commission, video) has no springSecurityService inserted
            def user = springSecurityService?.getCurrentUser()
            createdBy = user?.username ?: 'system'
        }
    }

}
