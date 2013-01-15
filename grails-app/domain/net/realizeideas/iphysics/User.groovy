package net.realizeideas.iphysics

import net.realizeideas.iphysics.common.BasePersistentObject

class User extends BasePersistentObject {

    transient springSecurityService

    String username
    String password
    String firstName
    String lastName
    String email

    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    BigDecimal totalPoints = 0

    static constraints = {
        username blank: false, unique: true
        password blank: false
        email nullable: true, email: true
        totalPoints nullable: true
    }


    static mapping = {
        password column: '`password`'
    }



    Set<Role> getAuthorities() {
        //Will look into only for existed User
        if (id) {
            User.withNewSession {
                UserRole.findAllByUser(this).collect { it.role } as Set
            }
        } else {
            return [] as Set
        }
    }

    def boolean isAdmin() {
        def role = getAuthorities()?.find {it.authority == Role.ROLE_ADMIN}
        return role != null
    }

    def beforeInsert() {
        super.beforeInsert()
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }
}
