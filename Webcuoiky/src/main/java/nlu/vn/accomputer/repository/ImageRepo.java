package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {
    List<Image> findImageByAccessory_Id(Long id);
}
