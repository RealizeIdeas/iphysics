package net.realizeideas.iphysics.exam

import net.realizeideas.iphysics.question.Category
import net.realizeideas.iphysics.question.Question
import net.realizeideas.iphysics.User
import net.realizeideas.iphysics.question.StudentAnswer
import net.realizeideas.iphysics.question.Answer

/**
 * @author Michael Astreiko
 */
class ExamController {
    def springSecurityService

    def startExam(Long categoryId) {

        def user = User.read(springSecurityService.currentUser.id)
        Category category = Category.read(categoryId)

        def questions = Question.findAllByCategory(category, [max: 5])

        session["exam"] = new Exam(questions: questions, student: user).save()
        session["currentQuestionInd"] = 0
        println "questions: ${questions}"
        println "questions[0]: ${questions[0]}"
        render(view: "question", model: [question: questions[0]])
    }

    def nextQuestion(String answerValue) {
        Exam exam = session["exam"]
        def currentInd = ++session["currentQuestionInd"]

        def user = User.read(springSecurityService.currentUser.id)

        def questions = exam?.questions as List
        if (questions[currentInd - 1]) {
            StudentAnswer studentAnswer = new StudentAnswer(student: user, exam: exam,
                    question: questions[currentInd - 1])
            studentAnswer.answer = new Answer(value: answerValue).save()
            exam.addToStudentAnswers(studentAnswer)
            studentAnswer.save(failOnError: true)
        }


        if (questions?.size() <= currentInd) {
            flash.message = "Exam finished"

            render(view: "examReport", model: [exam: exam])
        } else {
            render(view: "question", model: [question: Question.read(questions[currentInd]?.id)])
        }

    }
}
