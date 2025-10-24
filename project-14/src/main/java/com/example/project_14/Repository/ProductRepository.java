package com.example.project_14.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.project_14.models.Productmodel;

public interface ProductRepository extends CrudRepository<Productmodel,Integer> {

}