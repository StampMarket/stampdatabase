package com.stampdatabase.server;

import com.stampdatabase.dao.StampdatabaseDao;
import com.stampdatabase.pojo.StampDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StampDatabaseService {
    @Autowired
    private StampdatabaseDao stampdatabaseDao;
    public List<StampDatabase> findAll(){return stampdatabaseDao.findAll();}
    public StampDatabase findById(Integer id){return stampdatabaseDao.findById(id).get();}
    public void add(StampDatabase stampDatabase){
        stampdatabaseDao.save(stampDatabase);}
    public void update(StampDatabase stampDatabase){
        stampdatabaseDao.save(stampDatabase);}
    public void deleteById(Integer id){
        stampdatabaseDao.deleteById(id);}
}
