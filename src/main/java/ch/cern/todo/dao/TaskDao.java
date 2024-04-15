package ch.cern.todo.dao;

import ch.cern.todo.exception.technical.DaoException;
import ch.cern.todo.data.model.Task;
import ch.cern.todo.data.repository.TaskRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Scope(value = "singleton")
@Service()
public class TaskDao {

    private final TaskRepository taskRepository;

    public TaskDao(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll() {
        try{
            List<Task> tasks =  taskRepository.findAll();
            return tasks;
        }
        catch (Exception e){
            throw new DaoException(e);
        }
    }

    public List<Task> getByCategoryId(Long id) {
        try{
            List<Task> tasks =  taskRepository.findByCategoryId(id);
            return tasks;
        }
        catch (Exception e){
            throw new DaoException(e);
        }
    }

    public Task newTask(Task newTask) {
        try {
            return taskRepository.save(newTask);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Optional<Task> getOne(Long id) {
        try {
            return taskRepository.findById(id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Task updateTask(Task taskUpdated) {
        try {
            return taskRepository.save(taskUpdated);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
        }
        catch (Exception e){
            throw new DaoException(e);
        }
    }
}
