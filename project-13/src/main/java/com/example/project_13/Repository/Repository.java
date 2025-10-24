package com.example.project_13.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.project_13.models.Bookmodel;

public interface Repository extends CrudRepository<Bookmodel,Integer> {

}
