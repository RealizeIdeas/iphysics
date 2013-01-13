package net.realizeideas.iphysics.question

import org.springframework.dao.DataIntegrityViolationException

class CategoryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [categoryList: Category.list(params), categoryTotal: Category.count()]
    }

    def create() {
        [category: new Category(params)]
    }

    def save() {
        def category = new Category(params)
        if (!category.save(flush: true)) {
            render(view: "create", model: [category: category])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'category.label', default: 'Category'), category.id])
        redirect(action: "show", id: category.id)
    }

    def show(Long id) {
        def category = Category.get(id)
        if (!category) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'category.label', default: 'Category'), id])
            redirect(action: "list")
            return
        }

        [category: category]
    }

    def edit(Long id) {
        def category = Category.get(id)
        if (!category) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'category.label', default: 'Category'), id])
            redirect(action: "list")
            return
        }

        [category: category]
    }

    def update(Long id, Long version) {
        def category = Category.get(id)
        if (!category) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'category.label', default: 'Category'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (category.version > version) {
                category.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'category.label', default: 'Category')] as Object[],
                          "Another user has updated this Category while you were editing")
                render(view: "edit", model: [category: category])
                return
            }
        }

        category.properties = params

        if (!category.save(flush: true)) {
            render(view: "edit", model: [category: category])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'category.label', default: 'Category'), category.id])
        redirect(action: "show", id: category.id)
    }

    def delete(Long id) {
        def category = Category.get(id)
        if (!category) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'category.label', default: 'Category'), id])
            redirect(action: "list")
            return
        }

        try {
            category.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'category.label', default: 'Category'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'category.label', default: 'Category'), id])
            redirect(action: "show", id: id)
        }
    }
}
