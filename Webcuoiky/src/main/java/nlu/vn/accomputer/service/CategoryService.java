package nlu.vn.accomputer.service;


import nlu.vn.accomputer.entity.Category;

import java.util.List;


public interface CategoryService {
    Category findOneById(Long id);

//    List<Category> findAllFetchEager();

    void save(Category brand);

    void deletes(Long[] ids);
    List<Category> findAll();
}
