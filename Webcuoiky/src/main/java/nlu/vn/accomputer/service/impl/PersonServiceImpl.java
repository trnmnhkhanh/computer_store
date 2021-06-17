package nlu.vn.accomputer.service.impl;

import nlu.vn.accomputer.repository.PersonRepo;
import nlu.vn.accomputer.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;
}
