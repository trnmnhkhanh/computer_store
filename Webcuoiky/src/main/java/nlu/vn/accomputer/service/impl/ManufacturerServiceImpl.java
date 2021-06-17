package nlu.vn.accomputer.service.impl;


import nlu.vn.accomputer.entity.Manufacturer;
import nlu.vn.accomputer.repository.ManufacturerRepo;
import nlu.vn.accomputer.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
   @Autowired
    ManufacturerRepo manufacturerRepo;
    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepo.findAll();
    }

    @Override
    public Manufacturer findOneById(Long id) {
        return manufacturerRepo.findOneById(id);
    }
}
