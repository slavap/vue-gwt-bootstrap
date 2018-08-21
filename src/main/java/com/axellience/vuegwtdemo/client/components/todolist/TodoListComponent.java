package com.axellience.vuegwtdemo.client.components.todolist;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.axellience.vuegwt.core.annotations.component.Component;
import com.axellience.vuegwt.core.annotations.component.Computed;
import com.axellience.vuegwt.core.annotations.component.Data;
import com.axellience.vuegwt.core.client.component.IsVueComponent;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;

/**
 * A simple Todo list.
 * Is able to list some todo, mark them as done, remove done todos or all at the same time.
 */
@Component(components = TodoComponent.class)
public class TodoListComponent implements IsVueComponent
{
    @Data @JsProperty List<Todo> todos = new LinkedList<>();
    @Data String newTodoText = "";

    @JsMethod
    public void addTodo()
    {
        this.todos.add(new Todo(this.newTodoText));
        this.newTodoText = "";
    }

    @JsMethod
    public void removeTodo(Todo todo)
    {
        this.todos.remove(todo);
    }

    @JsMethod
    public void clearTodos()
    {
        this.todos.clear();
    }

    @JsMethod
    public void clearDoneTodos()
    {
        this.todos =
            this.todos.stream().filter(todo -> !todo.isDone()).collect(Collectors.toList());
    }

    /**
     * Will be automatically called by Vue.js to
     * get the value of doneTodos in the template
     * @return The number of todos that are done
     */
    @Computed
    public long getDoneTodos()
    {
        if (this.todos == null)
            return 0;

        return this.todos.stream().filter(Todo::isDone).count();
    }
}
