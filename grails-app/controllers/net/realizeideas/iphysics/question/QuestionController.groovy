package net.realizeideas.iphysics.question

import org.springframework.dao.DataIntegrityViolationException

/**
 * QuestionController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class QuestionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [questionList: Question.list(params), questionTotal: Question.count()]
    }

    def create() {
        [question: new Question(params)]
    }

    def save() {
        def question = new Question(params)
        if (!question.save(flush: true)) {
            render(view: "create", model: [question: question])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'question.label', default: 'Question'), question.id])
        redirect(action: "show", id: question.id)
    }

    def show(Long id) {
        def question = Question.get(id)
        if (!question) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "list")
            return
        }

        [question: question]
    }

    def edit(Long id) {
        def question = Question.get(id)
        if (!question) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "list")
            return
        }

        [question: question]
    }

    def update(Long id, Long version) {
        def question = Question.get(id)
        if (!question) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "list")
            return
        }

        if (version) {
            if (question.version > version) {
                question.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'question.label', default: 'Question')] as Object[],
                          "Another user has updated this Question while you were editing")
                render(view: "edit", model: [question: question])
                return
            }
        }

        question.properties = params

        if (!question.save(flush: true)) {
            render(view: "edit", model: [question: question])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'question.label', default: 'Question'), question.id])
        redirect(action: "show", id: question.id)
    }

    def delete(Long id) {
        def question = Question.get(id)
        if (!question) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "list")
            return
        }

        try {
            question.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'question.label', default: 'Question'), id])
            redirect(action: "show", id: params.id)
        }
    }
}
