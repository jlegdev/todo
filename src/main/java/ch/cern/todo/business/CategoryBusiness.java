package ch.cern.todo.business;

import ch.cern.todo.dao.CategoryDao;
import ch.cern.todo.data.model.Task;
import ch.cern.todo.exception.business.NotFoundException;
import ch.cern.todo.data.model.Category;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Scope(value = "singleton")
@Service()
public class CategoryBusiness {

    private final CategoryDao categoryDao;
    private final TaskBusiness taskBusiness;

    public CategoryBusiness(final CategoryDao categoryDao, final TaskBusiness taskBusiness){
        this.categoryDao = categoryDao;
        this.taskBusiness = taskBusiness;
    }

    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    public Category newCategory(@Valid Category newCategory) {
        newCategory.setTasks(new ArrayList<>());
        return categoryDao.newCategory(newCategory);
    }

    public Category getById(Long id) {
        Optional<Category> category = categoryDao.getById(id);
        if(category.isPresent()){
            return category.get();
        }
        else{
            throw new NotFoundException("Category with id " + id + " not found");
        }
    }

    public Category updateCategory(@Valid Category categoryUpdated, Long id) {
        Category category = this.getById(id);
        category.setDescription(categoryUpdated.getDescription());
        category.setName((categoryUpdated.getName()));
        return categoryDao.updateCategory(category);
    }

    public void deleteCategory(Long id) {
        Category category = this.getById(id);
        categoryDao.deleteCategory(id);
    }

    public Task addTask(@Valid Task task, Long id){
        Category category = this.getById(id);
        task.setCategory(category);
        return taskBusiness.newTask(task);
    }
}
