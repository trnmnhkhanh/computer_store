package nlu.vn.accomputer.service;


import nlu.vn.accomputer.entity.Accessory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface AccessoryService {

    void save(Accessory accessory);

    List<Accessory> findAll();
    List<Accessory> findAllByManufacturerName(String categoryName);

    Accessory findDetailById(Long id);
//
//    Page<Accessory> findByCategoryId(Manufacturer id, Pageable pageable);
//
    Accessory findOneById(Long id);
//
    Page<Accessory> findRandomPage(Pageable pageable);
    Page<Accessory> findLatestPage(Pageable pageable);
    Page<Accessory> findBestsellerPage(Pageable pageable);
    Page<Accessory> findTopSalePage(Pageable pageable);

    List<Accessory> getAllAccessoryByList(Set<Long> idList);
    List<Accessory> findRelatedProduct(String manufacturer, String category, int numOfProduct);

//    Page<Accessory> searchAutocomplete(String key, Pageable pageable);
//
//    Page<Accessory> findProductunder10tr(Pageable pageable);
//
//    Page<Accessory> findProductUnder20tr(Pageable pageable);
//
//    Page<Accessory> findProductTop20Tr(Pageable pageable);


}
