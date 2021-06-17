package nlu.vn.accomputer.service;


import nlu.vn.accomputer.entity.Accessory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccessoryService {

    void save(Accessory accessory);

    List<Accessory> findAll();

    Accessory findDetailById(Long id);
//
//    Page<Accessory> findByCategoryId(Manufacturer id, Pageable pageable);
//
    Accessory findOneById(Long id);
//
    Page<Accessory> findAllPaging(Pageable pageable);

//    Page<Accessory> searchAutocomplete(String key, Pageable pageable);
//
//    Page<Accessory> findProductunder10tr(Pageable pageable);
//
//    Page<Accessory> findProductUnder20tr(Pageable pageable);
//
//    Page<Accessory> findProductTop20Tr(Pageable pageable);


}
