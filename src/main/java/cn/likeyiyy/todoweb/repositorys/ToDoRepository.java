package cn.likeyiyy.todoweb.repositorys;

import cn.likeyiyy.todoweb.models.ToDoItem;

import java.util.List;

public interface ToDoRepository {
    List<ToDoItem> findAll();
    ToDoItem findById(Long id);
    Long insert(ToDoItem todoItem);
    void update(ToDoItem todoItem);
    void delete(ToDoItem todoItem);
}
