package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "SELECT c FROM Category c where c.id=?1")
    Category getCategoryById(long id);
}
