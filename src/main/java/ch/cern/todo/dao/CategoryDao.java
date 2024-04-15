package ch.cern.todo.dao;

import ch.cern.todo.exception.technical.DaoException;
import ch.cern.todo.data.model.Category;
import ch.cern.todo.data.repository.CategoryRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Scope(value = "singleton")
@Service()
public class CategoryDao {

    private final CategoryRepository categoryRepository;

    public CategoryDao(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        try{
            List<Category> categories =  categoryRepository.findAll();
            return categories;
        }
        catch (Exception e){
            throw new DaoException(e);
        }
    }

    public Category newCategory(Category newCategory) {
        try {
            return categoryRepository.save(newCategory);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Optional<Category> getById(Long id) {
        try {
            return categoryRepository.findById(id);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Category updateCategory(Category categoryUpdated) {
        try {
            return categoryRepository.save(categoryUpdated);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void deleteCategory(Long id) {
        try {
            categoryRepository.deleteById(id);
        }
        catch (Exception e){
            throw new DaoException(e);
        }
    }
}
