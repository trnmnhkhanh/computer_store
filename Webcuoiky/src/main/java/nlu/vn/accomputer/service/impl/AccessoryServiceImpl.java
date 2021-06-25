package nlu.vn.accomputer.service.impl;


import nlu.vn.accomputer.entity.Accessory;
import nlu.vn.accomputer.repository.AccessoryRepo;
import nlu.vn.accomputer.service.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AccessoryServiceImpl implements AccessoryService {
    @Autowired
    private AccessoryRepo accessoryRepo;

    @Override
    public void save(Accessory accessory) {
        accessoryRepo.save(accessory);
    }

    @Override
    public List<Accessory> findAll() {
        return accessoryRepo.findAll();
    }

    @Override
    public List<Accessory> findAllByManufacturerName(String manufacturerName) {
        return accessoryRepo.findAllByManufacturerName(manufacturerName);
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
    public Page<Accessory> findRandomPage(Pageable pageable) {
        return accessoryRepo.findRandomPage(pageable);
    }

    @Override
    public Page<Accessory> findLatestPage(Pageable pageable) {
        return accessoryRepo.findLatestPage(pageable);
    }

    @Override
    public Page<Accessory> findBestsellerPage(Pageable pageable) {
        return accessoryRepo.findBestsellerPage(pageable);
    }

    @Override
    public Page<Accessory> findTopSalePage(Pageable pageable) {
        return accessoryRepo.findTopSalePage(pageable);
    }

    @Override
    public List<Accessory> getAllAccessoryByList(Set<Long> idList) {
        return accessoryRepo.findByIdIn(idList);
    }

    @Override
    public List<Accessory> findRelatedProduct(String manufacturer, String category, int numOfProduct) {
        List<Accessory> List = accessoryRepo.findRelatedProduct(manufacturer, category);
        List<Accessory> rdList = new ArrayList<>();
        List<Accessory> copy = new ArrayList<>(List);
        SecureRandom rand = new SecureRandom();
        for (int i = 0; i < Math.min(numOfProduct, List.size()); i++) {
//            System.out.println(copy.remove(rand.nextInt(copy.size())));
            rdList.add(copy.remove(rand.nextInt(copy.size())));
        }
//        System.out.println(copy.size());
        System.out.println(rdList);
        return rdList;
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
