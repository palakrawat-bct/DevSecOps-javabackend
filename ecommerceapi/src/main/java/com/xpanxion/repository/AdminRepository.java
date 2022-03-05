package com.xpanxion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xpanxion.entity.AdminEntity;
import java.util.*;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Integer>{

    @Query(value="SELECT * from admin where admin_username=?",nativeQuery = true)
    List<AdminEntity> getLoginDetails(int id);

}
