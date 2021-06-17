package nlu.vn.accomputer.service.impl;


import nlu.vn.accomputer.entity.Accessory;
import nlu.vn.accomputer.repository.AccessoryRepo;
import nlu.vn.accomputer.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryServiceImpl  implements AccessoryService {
    @Autowired
    private AccessoryRepo accessoryRepo;

    @Override
    public void save(Accessory accessory) {  accessoryRepo.save(accessory);}

    @Override
    public List<Accessory> findAll() {
        return accessoryRepo.findAll();
    }

    @Override
    public Accessory findDetailById(Long id) {
        return accessoryRepo.findOneById(id);
    }


    //
//    @Override
//    public Accessory findDetailById(Long id) {
//        return accessoryRepo.findOneById(id);
//    }
//
//    @Override
//    public Page<Accessory> findByCategoryId(Manufacturer id, Pageable pageable) {
//        return accessoryRepo.findByBrand(id, pageable);
//    }
//
    @Override
    public Accessory findOneById(Long id) {
        return accessoryRepo.findOneById(id);
    }

    @Override
    public Page<Accessory> findAllPaging(Pageable pageable) {
        return accessoryRepo.findAll(pageable);
    }
//    @Override
//    public Page<Accessory> findAllDetailAccessory(Pageable pageable) {
//        return accessoryRepo.findAllDetailAccessory(pageable);
//    }

//
//    @Override
//    public Page<Accessory> searchAutocomplete(String key, Pageable pageable) {
//        return accessoryRepo.findByNameIgnoreCaseContainingAndStatus(key, 1, pageable);
//    }
//
//    @Override
//    public Page<Accessory> findProductunder10tr(Pageable pageable) {
//        return accessoryRepo.findByPriceUnder10tr(pageable);
//    }
//
//    @Override
//    public Page<Accessory> findProductUnder20tr(Pageable pageable) {
//        return accessoryRepo.findByPriceUnder20tr(pageable);
//    }
//
//    @Override
//    public Page<Accessory> findProductTop20Tr(Pageable pageable) {
//        return accessoryRepo.findByPriceTop20tr(pageable);
//    }

}
