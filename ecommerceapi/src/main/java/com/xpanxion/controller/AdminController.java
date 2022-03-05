package com.xpanxion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xpanxion.services.AdminServices;
import com.xpanxion.entity.AdminEntity;
import java.util.*;
@CrossOrigin
@RestController
public class AdminController {

    @Autowired
    private AdminServices service;

    @RequestMapping("/getlogindetails/{id}")
    public List<AdminEntity> getLoginDetails(@PathVariable int id){
        return service.getLoginDetails(id);
    }

}
