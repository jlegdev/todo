package ch.cern.todo.business;

import ch.cern.todo.dao.TaskDao;
import ch.cern.todo.exception.business.NotFoundException;
import ch.cern.todo.data.model.Task;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope(value = "singleton")
@Service()
public class TaskBusiness {

    @Autowired
    private TaskDao taskDao;

    public List<Task> getAll() {
        return taskDao.getAll();
    }

    public List<Task> getByCategoryId(Long id) {
        List<Task> tasks = taskDao.getByCategoryId(id);
        List<Task> t = taskDao.getAll();

        return tasks;
    }

    public Task newTask(@Valid Task newTask) {
        return taskDao.newTask(newTask);
    }

    public Task getById(Long id) {
        Optional<Task> task = taskDao.getOne(id);
        if(task.isPresent()){
            return task.get();
        }
        else{
            throw new NotFoundException("Task with id " + id + " not found");
        }
    }

    public Task updateTask(@Valid Task taskUpdated, Long id) {
        Task task = this.getById(id);
        task.setDescription(taskUpdated.getDescription());
        task.setName((taskUpdated.getName()));
        task.setIsFinish((taskUpdated.getIsFinish()));
        return taskDao.updateTask(task);
    }

    public void deleteTask(Long id) {
        Task task = this.getById(id);
        taskDao.deleteTask(id);
    }
}