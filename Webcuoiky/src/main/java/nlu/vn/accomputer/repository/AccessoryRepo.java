package nlu.vn.accomputer.repository;


import nlu.vn.accomputer.entity.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryRepo extends JpaRepository<Accessory, Long> {
    Accessory findOneById(Long id);
//
//    Page<Accessory> findByBrand(Manufacturer entity, Pageable pageable);
//
//    Page<Accessory> findByNameIgnoreCaseContainingAndStatus(String name, Integer status, Pageable pageable);
//
//    @Query(value = "select a from Accessory a join  Image i on a.id= i.accessory.id join Price p on a.price.id  = p.id")
//    Page<Accessory> findAllDetailAccessory(Pageable pageable);

//    @Query(value = "select * from  Accessory a join Price  p on a.price.id = p.id")

//
//    @Query(value = "select a from Accessory a join  Price p on a.price.id= p.id where a.price.salePrice between 10000000 and 20000000")
//    Page<Accessory> findByPriceUnder20tr(Pageable pageable);
//
//    @Query(value = "select a from Accessory a join  Price p on a.price.id= p.id where a.price.salePrice > 20000000")
//    Page<Accessory> findByPriceTop20tr(Pageable pageable);
}
