package com.example.DBApplication;

import org.springframework.data.repository.CrudRepository;

public interface AddRepo extends CrudRepository<Alien, Integer> {

    Alien[] findByAname(String aname);

}
