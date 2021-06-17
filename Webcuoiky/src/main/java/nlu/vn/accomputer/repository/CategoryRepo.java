package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    @Override

    List<Category> findAll();

    Category findOneById(Long id);





}
