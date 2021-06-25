package nlu.vn.accomputer.service;


import nlu.vn.accomputer.entity.Price;

import java.util.List;

public interface PriceService {
    int getSalePercent();
    List<Price> findAll();


}
