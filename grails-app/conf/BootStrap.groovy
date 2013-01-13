import net.realizeideas.iphysics.Requestmap
import net.realizeideas.iphysics.User
import net.realizeideas.iphysics.Role
import net.realizeideas.iphysics.UserRole

class BootStrap {

    def init = { servletContext ->
        Requestmap.findByUrl('/exam/**') ?: new Requestmap(url: '/exam/**', configAttribute: 'IS_AUTHENTICATED_REMEMBERED').save()
        Requestmap.findByUrl('/question/**') ?: new Requestmap(url: '/question/**', configAttribute: 'ROLE_ADMIN').save()
        Requestmap.findByUrl('/category/**') ?: new Requestmap(url: '/category/**', configAttribute: 'ROLE_ADMIN').save()
        Requestmap.findByUrl('/user/**') ?: new Requestmap(url: '/user/**', configAttribute: 'ROLE_ADMIN').save()
        Requestmap.findByUrl('/requestmap/**') ?: new Requestmap(url: '/requestmap/**', configAttribute: 'ROLE_ADMIN').save()

        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save(failOnError: true)
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
        User adminUser = User.findByUsername('admin') ?: new User(
                username: 'admin',
                password: 's0cial',
                enabled: true,
                accountExpired: false,
                accountLocked: false,
                firstName: 'Michael',
                lastName: 'Astreiko'
        ).save(failOnError: true)

        User user = User.findByUsername('user') ?: new User(
                username: 'user',
                password: 'user',
                enabled: true,
                firstName: 'Vasily',
                lastName: 'Pupkin'
        ).save(failOnError: true)

        if (!adminUser.authorities.contains(adminRole)) {
            UserRole.create adminUser, adminRole
        }
        if (!user.authorities.contains(userRole)) {
            UserRole.create user, userRole
        }



    }
    def destroy = {
    }
}
