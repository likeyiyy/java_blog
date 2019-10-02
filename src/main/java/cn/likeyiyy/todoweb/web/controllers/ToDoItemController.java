package cn.likeyiyy.todoweb.web.controllers;
import cn.likeyiyy.todoweb.models.ToDoItem;
import cn.likeyiyy.todoweb.repositorys.InMemoryToDoRepository;
import cn.likeyiyy.todoweb.repositorys.ToDoRepository;
import cn.likeyiyy.todoweb.web.presentation.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

//    FIND_ALL('a'), FIND_BY_ID('f'), INSERT('i'), UPDATE('u'), DELETE('d'), EXIT('e');

@RestController
public class ToDoItemController {
    private ToDoRepository toDoRepository = new InMemoryToDoRepository();

    @RequestMapping("/all")
    public List<ToDoItem> allToDos() {
        return toDoRepository.findAll();
    }

    @RequestMapping("/find_by_id")
    public ToDoItem findById(@RequestParam(value="id", defaultValue = "1") long id) {
        return toDoRepository.findById(id);
    }

    @RequestMapping("/add")
    public Response add(@RequestParam(value="name", defaultValue = "1") String name) {
        ToDoItem toDoItem = new ToDoItem(name);
        return new Response(toDoRepository.insert(toDoItem));
    }

    @RequestMapping("/update")
    public ToDoItem update(
            @RequestParam(value="name") String name,
            @RequestParam(value="id", defaultValue = "1") Long id,
            @RequestParam(value="completed", defaultValue = "false") boolean completed
    ) {
        ToDoItem toDoItem = toDoRepository.findById(id);
        if (toDoItem != null) {
            if (name != null) {
                toDoItem.setName(name);
            }
            toDoItem.setCompleted(completed);
        }
        toDoRepository.update(toDoItem);
        return toDoItem;
    }

    @RequestMapping("/delete")
    public Response delete(@RequestParam(value="id", defaultValue = "1") Long id) {
        ToDoItem toDoItem = toDoRepository.findById(id);
        if (toDoItem == null) {
            return new Response(false, "No Such Todo");
        }
        toDoRepository.delete(toDoItem);
        return new Response(id);
    }
}
