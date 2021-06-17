package nlu.vn.accomputer.repository;

import nlu.vn.accomputer.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepo extends JpaRepository<Manufacturer, Long> {
    Manufacturer findOneById(Long id);
}

