package cn.likeyiyy.todoweb.models;

public class ToDoItem implements Comparable<ToDoItem> {
    private long id;
    private String name;
    private boolean completed;

    public ToDoItem(String s) {
        name = s;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public int compareTo(ToDoItem todoItem) {
        return Long.compare(id, todoItem.id);
    }

    @Override
    public String toString() {
        return name;
    }
}
