package ch.cern.todo.controller;

import ch.cern.todo.business.TaskBusiness;
import ch.cern.todo.data.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "task")
public class TaskController {

    @Autowired
    private TaskBusiness taskBusiness;

    @GetMapping(path="",produces = "application/json")
    public List<Task> getAll() {
        return taskBusiness.getAll();
    }

    @GetMapping(path="/{id}",produces = "application/json")
    public Task getById(@PathVariable("id") long id) {
        return taskBusiness.getById(id);
    }

    @PostMapping(path="",produces = "application/json")
    public Task create(@RequestBody Task task) {
        return taskBusiness.newTask(task);
    }

    @PutMapping(path="/{id}",produces = "application/json")
    public Task update(@PathVariable("id") long id, @RequestBody Task task) {
        return taskBusiness.updateTask(task,id);
    }

    @DeleteMapping(path="/{id}",produces = "application/json")
    public void delete(@PathVariable("id") long id) {
        taskBusiness.deleteTask(id);
    }
}