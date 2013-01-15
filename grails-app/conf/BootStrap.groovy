import net.realizeideas.iphysics.Requestmap
import net.realizeideas.iphysics.User
import net.realizeideas.iphysics.Role
import net.realizeideas.iphysics.UserRole
import net.realizeideas.iphysics.question.Category
import net.realizeideas.iphysics.question.Question
import net.realizeideas.iphysics.question.Answer

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

        if (!UserRole.countByUserAndRole(adminUser, adminRole)) {
            UserRole.create adminUser, adminRole
        }
        if (!UserRole.countByUserAndRole(user, userRole)) {
            UserRole.create user, userRole
        }

        def heatCategory = Category.findByTitle('Heat') ?: new Category(
                title: 'Heat',
                description:"Тепловые явления"
        ).save(failOnError: true)

        Question.findByTitleAndCategory("Heat1", heatCategory)?: new Question(
                title: "Heat1",
                category: heatCategory,
                description: "Нагрев чашки, стоящей на столе рядом с горячим чайником, в основном, осуществляется",
                answers: [
                        new Answer(value: "теплопроводностью"),
                        new Answer(value: "конвекцией"),
                        new Answer(value: "излучением", isCorrect: true)
                ],
                type: "selectOne",
                maxPointsToEarn: 1
        ).save(failOnError: true)

        Question.findByTitleAndCategory("Heat2", heatCategory)?: new Question(
                title: "Heat2",
                category: heatCategory,
                description: "Нагрев жидкости внутри термометра, опущенного в калориметр с горячей водой, осуществляется",
                answers: [
                        new Answer(value: "теплопроводностью", isCorrect: true),
                        new Answer(value: "конвекцией"),
                        new Answer(value: "излучением")
                ],
                type: "selectOne",
                maxPointsToEarn: 1
        ).save(failOnError: true)

        Question.findByTitleAndCategory("Heat3", heatCategory)?: new Question(
                title: "Heat3",
                category: heatCategory,
                description: "Расположение вентиляционных отверстий на кухне в верхней части стены связано с",
                answers: [
                        new Answer(value: "теплопроводностью"),
                        new Answer(value: "конвекцией", isCorrect: true),
                        new Answer(value: "излучением")
                ],
                type: "selectOne",
                maxPointsToEarn: 1
        ).save(failOnError: true)


        Question.findByTitleAndCategory("Heat4", heatCategory)?: new Question(
                title: "Heat4",
                category: heatCategory,
                description: "В летний день нагрев нижних слоев воды в пруду осуществляется",
                answers: [
                        new Answer(value: "теплопроводностью", isCorrect: true),
                        new Answer(value: "конвекцией"),
                        new Answer(value: "излучением")
                ],
                type: "selectOne",
                maxPointsToEarn: 1
        ).save(failOnError: true)

        Question.findByTitleAndCategory("Heat5", heatCategory)?: new Question(
                title: "Heat5",
                category: heatCategory,
                description: "В летнюю ночь остывание нижних слоев воды в пруду, в основном, осуществляется",
                answers: [
                        new Answer(value: "теплопроводностью"),
                        new Answer(value: "конвекцией", isCorrect: true),
                        new Answer(value: "излучением")
                ],
                type: "selectOne",
                maxPointsToEarn: 1
        ).save(failOnError: true)

    }
    def destroy = {
    }
}
