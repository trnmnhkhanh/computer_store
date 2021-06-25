package nlu.vn.accomputer.service;


import nlu.vn.accomputer.entity.Image;

import java.util.List;


public interface ImageService {
    List<Image> findAll();
    List<Image> findImageByAccessory_Id(Long id);
}
