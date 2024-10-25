package ch.cern.todo.controller;

import ch.cern.todo.business.CategoryBusiness;
import ch.cern.todo.business.TaskBusiness;
import ch.cern.todo.data.model.Category;
import ch.cern.todo.data.model.Task;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="category" )
public class CategoryController {

    @Autowired
    private CategoryBusiness categoryBusiness;

    @GetMapping(path="",produces = "application/json")
    public List<Category> getAll() {
        return categoryBusiness.getAll();
    }

    @GetMapping(path="/{id}",produces = "application/json")
    public Category getById(@PathVariable("id") long id) {
        return categoryBusiness.getById(id);
    }

    @PostMapping(path="",produces = "application/json")
    public Category create(@RequestBody Category category) {
        return categoryBusiness.newCategory(category);
    }

    @PutMapping(path="/{id}",produces = "application/json")
    public Category update(@PathVariable("id") long id,@RequestBody Category category) {
        return categoryBusiness.updateCategory(category,id);
    }

    @DeleteMapping(path="/{id}",produces = "application/json")
    public void delete(@PathVariable("id") long id) {
        categoryBusiness.deleteCategory(id);
    }

    @PostMapping("/{id}/add-task")
    public Task addTask(@PathVariable("id") long id, @RequestBody Task task) {
        return  categoryBusiness.addTask(task,id);
    }
}
