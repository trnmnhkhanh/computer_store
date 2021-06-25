package nlu.vn.accomputer.service.impl;


import nlu.vn.accomputer.entity.Category;
import nlu.vn.accomputer.repository.CategoryRepo;
import nlu.vn.accomputer.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public Category findOneById(Long id) {
        return categoryRepo.findOneById(id);
    }

//    @Override
//    public List<Category> findAllFetchEager() {
//        return categoryRepo.findAllFetchEager();
//    }

    @Override
    public void save(Category brand) {
    }

    @Override
    public void deletes(Long[] ids) {

    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }



}
