package nlu.vn.accomputer.repository;


import nlu.vn.accomputer.entity.Accessory;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.OrderBy;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Set;

@Repository
public interface AccessoryRepo extends JpaRepository<Accessory, Long> {
    Accessory findOneById(Long id);
    List<Accessory> findByIdIn(Set<Long> idList);

    List<Accessory> findAllByManufacturerName(String manufacturerName);
//
//    Page<Accessory> findByBrand(Manufacturer entity, Pageable pageable);
//
//    Page<Accessory> findByNameIgnoreCaseContainingAndStatus(String name, Integer status, Pageable pageable);
//
//    @Query(value = "select a from Accessory a join  Image i on a.id= i.accessory.id join Price p on a.price.id  = p.id")
//    Page<Accessory> findAllDetailAccessory(Pageable pageable);

//    @Query(value = "select * from  Accessory a join Price  p on a.price.id = p.id")

// Tim san pham ngau nhien
    @Query(nativeQuery = true, value = "select * from Accessory ac order by RAND()")
    Page<Accessory> findRandomPage(Pageable pageable);

//    Tim san pham moi nhat nhat
    @Query(nativeQuery = true, value = "select * from Accessory ac order by ac.id DESC")
    Page<Accessory> findLatestPage(Pageable pageable);

//    Tim san pham ban chay nhat
    @Query(nativeQuery = true, value = "select * from Accessory ac order by ac.quantity ASC")
    Page<Accessory> findBestsellerPage(Pageable pageable);

    //    Tim san pham khuyen mai cao nhat
    @Query(nativeQuery = true, value = "select * from Accessory ac join Price p on ac.price_id = p.id order by p.sale_percent DESC")
    Page<Accessory> findTopSalePage(Pageable pageable);

//    Tim san pham co lien quan
    @Query(value = "select distinct ac from Accessory ac join Manufacturer mn on ac.manufacturer.id = mn.id join Category ct on ac.category.id = ct.id where mn.name= :manufacture or ct.name= :category")
    List<Accessory> findRelatedProduct(@Param("manufacture") String manufacture, @Param("category") String category);




//
//    @Query(value = "select a from Accessory a join  Price p on a.price.id= p.id where a.price.salePrice > 20000000")
//    Page<Accessory> findByPriceTop20tr(Pageable pageable);
}
