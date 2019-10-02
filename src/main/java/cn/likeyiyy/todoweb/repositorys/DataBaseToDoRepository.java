package cn.likeyiyy.todoweb.repositorys;

import cn.likeyiyy.todoweb.models.ToDoItem;

import java.util.List;

public class DataBaseToDoRepository implements ToDoRepository {
    @Override
    public List<ToDoItem> findAll() {
        return null;
    }

    @Override
    public ToDoItem findById(Long id) {
        return null;
    }

    @Override
    public Long insert(ToDoItem todoItem) {
        return null;
    }

    @Override
    public void update(ToDoItem todoItem) {

    }

    @Override
    public void delete(ToDoItem todoItem) {

    }
}
