package nlu.vn.accomputer.service.impl;


import nlu.vn.accomputer.repository.RoleRepo;
import nlu.vn.accomputer.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepo roleRepo;
}
