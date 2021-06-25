package nlu.vn.accomputer.service.impl;

import nlu.vn.accomputer.entity.Price;
import nlu.vn.accomputer.repository.PriceRepo;
import nlu.vn.accomputer.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepo priceRepo;


    @Override
    public int getSalePercent() {
        return 0;
    }

    @Override
    public List<Price> findAll() {
        return priceRepo.findAll();
    }

}
