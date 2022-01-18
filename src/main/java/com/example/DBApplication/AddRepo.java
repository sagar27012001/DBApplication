package com.example.DBApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddRepo extends JpaRepository<Alien, Integer> {

    List<Alien> findByAname(String aname);

    List<Alien> findByAidGreaterThan(int aid);

    @Query("from Alien where aname=?1 order by aid desc")
    List<Alien> findByAnameSorted(String aname);

}
