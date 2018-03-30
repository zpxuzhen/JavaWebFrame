package dev.local.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoTodoServiceImpl implements TodoService{
    private final TodoRepository repository;

    @Autowired
    MongoTodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Todo addTodo(Todo todo) {
        //构造todo的user归属

        return repository.insert(todo);
    }

    @Override
    public Todo deleteTodo(String id) {
        Todo deletedTodo = repository.findTodoById(id);
        repository.deleteTodoById(id);
        return deletedTodo;
    }

    @Override
    public List<Todo> findAll(String username) {
        return repository.findByUserUsername(username);
    }

    @Override
    public Todo findById(String id) {
        return repository.findTodoById(id);
    }

    @Override
    public Todo update(Todo todo) {
        repository.save(todo);
        return todo;
    }
}
