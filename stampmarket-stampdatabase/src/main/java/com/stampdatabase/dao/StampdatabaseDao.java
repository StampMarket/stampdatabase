package com.stampdatabase.dao;

import com.stampdatabase.pojo.StampDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StampdatabaseDao extends JpaRepository<StampDatabase,Integer> {
}
