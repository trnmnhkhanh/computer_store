package nlu.vn.accomputer.service.impl;

import nlu.vn.accomputer.entity.Image;
import nlu.vn.accomputer.repository.ImageRepo;
import nlu.vn.accomputer.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImageServiceImpl implements ImageService {
   @Autowired
    ImageRepo imageRepo;

    @Override
    public List<Image> findAll() {
        return imageRepo.findAll();
    }
}
