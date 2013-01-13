package net.realizeideas.iphysics

import org.springframework.dao.DataIntegrityViolationException

/**
 * RequestmapController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class RequestmapController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [requestmapList: Requestmap.list(params), requestmapTotal: Requestmap.count()]
    }

    def create() {
        [requestmap: new Requestmap(params)]
    }

    def save() {
        def requestmap = new Requestmap(params)
        if (!requestmap.save(flush: true)) {
            render(view: "create", model: [requestmap: requestmap])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), requestmap.id])
        redirect(action: "show", id: requestmap.id)
    }

    def show(Long id) {
        def requestmap = Requestmap.get(id)
        if (!requestmap) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), id])
            redirect(action: "list")
            return
        }

        [requestmap: requestmap]
    }

    def edit(Long id) {
        def requestmap = Requestmap.get(id)
        if (!requestmap) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), id])
            redirect(action: "list")
            return
        }

        [requestmap: requestmap]
    }

    def update(Long id, Long version) {
        def requestmap = Requestmap.get(id)
        if (!requestmap) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), id])
            redirect(action: "list")
            return
        }

        if (version) {
            if (requestmap.version > version) {
                requestmap.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'requestmap.label', default: 'Requestmap')] as Object[],
                          "Another user has updated this Requestmap while you were editing")
                render(view: "edit", model: [requestmap: requestmap])
                return
            }
        }

        requestmap.properties = params

        if (!requestmap.save(flush: true)) {
            render(view: "edit", model: [requestmap: requestmap])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), requestmap.id])
        redirect(action: "show", id: requestmap.id)
    }

    def delete(Long id) {
        def requestmap = Requestmap.get(id)
        if (!requestmap) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), id])
            redirect(action: "list")
            return
        }

        try {
            requestmap.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'requestmap.label', default: 'Requestmap'), id])
            redirect(action: "show", id: params.id)
        }
    }
}
