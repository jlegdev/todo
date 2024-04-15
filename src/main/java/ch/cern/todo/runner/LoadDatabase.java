package ch.cern.todo.runner;

import ch.cern.todo.data.model.Category;
import ch.cern.todo.data.model.Task;
import ch.cern.todo.data.repository.CategoryRepository;
import ch.cern.todo.data.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
class LoadDatabase {


    @Bean
    CommandLineRunner initDatabase(CategoryRepository categoryRepository, TaskRepository taskRepository) {

        return args -> {
           Category category1 =  categoryRepository.save(new Category("Category 1", "Important"));
           Category category2 =   categoryRepository.save(new Category("Category 2", "Less important"));

           Task task1 = taskRepository.save(new Task("task1","this is the task1", new Date(),false,category1));
           Task task12 = taskRepository.save(new Task("task2","this is the task2",new Date(),false,category1));

           Task task3 = taskRepository.save(new Task("task3","this is the task3",new Date(),false,category2));
           Task task4 = taskRepository.save(new Task("task4","this is the task4",new Date(),false,category2));

        };
    }
}