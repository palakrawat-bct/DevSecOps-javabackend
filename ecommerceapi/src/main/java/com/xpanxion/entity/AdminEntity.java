package com.xpanxion.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class AdminEntity {
	
    @Id
    @Column(name="admin_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int admin_id;
	
    @Column(name="admin_username")
    String admin_username;

    @Column(name="password")
    String password;

    @Column(name="admin_key")
    String admin_key;

    public AdminEntity(){

    }

    public AdminEntity(int admin_id,String admin_username,String password,String admin_key){
        this.admin_id = admin_id;
        this.admin_username = admin_username;
        this.password = password;
        this.admin_key = admin_key;
    }

    public int getAdmin_id(){
        return admin_id;
    }

    public void setAdmin_id(int admin_id){
        this.admin_id = admin_id;
    }

    public String getAdmin_username(){
        return admin_username;
    }

    public void setAdmin_username(String admin_username){
        this.admin_username = admin_username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getAdmin_key(){
        return admin_key;
    }

    public void setAdmin_key(String admin_key){
        this.admin_key = admin_key;
    }


}
