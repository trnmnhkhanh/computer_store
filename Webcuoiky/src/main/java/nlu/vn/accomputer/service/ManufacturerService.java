package nlu.vn.accomputer.service;


import nlu.vn.accomputer.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    List<Manufacturer> findAll();
    Manufacturer findOneById(Long id);
}
