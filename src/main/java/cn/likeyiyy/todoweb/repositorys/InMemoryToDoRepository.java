package cn.likeyiyy.todoweb.repositorys;

import cn.likeyiyy.todoweb.models.ToDoItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryToDoRepository implements ToDoRepository {
    private AtomicLong currentId = new AtomicLong();
    private ConcurrentHashMap<Long, ToDoItem> toDos = new ConcurrentHashMap<Long, ToDoItem>();

    @Override
    public List<ToDoItem> findAll() {
        List<ToDoItem> todoItems = new ArrayList<ToDoItem>(toDos.values());
        Collections.sort(todoItems);
        return todoItems;
    }

    @Override
    public ToDoItem findById(Long id) {
        return toDos.get(id);
    }

    @Override
    public Long insert(ToDoItem todoItem) {
        Long id = currentId.incrementAndGet();
        todoItem.setId(id);
        toDos.putIfAbsent(id, todoItem);
        return id;
    }

    @Override
    public void update(ToDoItem todoItem) {
        toDos.replace(todoItem.getId(), todoItem);
    }

    @Override
    public void delete(ToDoItem todoItem) {
        toDos.remove(todoItem.getId());
    }
}
