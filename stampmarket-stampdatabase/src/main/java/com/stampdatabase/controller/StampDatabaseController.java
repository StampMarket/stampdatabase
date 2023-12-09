package com.stampdatabase.controller;

import com.stampdatabase.pojo.StampDatabase;
import com.stampdatabase.server.StampDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("/stampdatabase")
@RestController   // @RestController=@RequestMapping + @ResponseBody
public class StampDatabaseController {
    @Autowired
    private StampDatabaseService stampDatabaseService;

    public Integer selectId(String name){
        int num=this.findAll().size();
        StampDatabase instance;
        for(int i=0;i<num;i++)
        {
            instance=this.findAll().get(i);
            if(name.equals(instance.getstampName()))
            {
                return instance.getId();
            }
        }
        throw new NoSuchElementException("未找到名称为"+name+"的邮票");
    }
    /*** 添加邮票     */
    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody StampDatabase stampDatabase){
        stampDatabaseService.add(stampDatabase);
        return "添加成功";    }
    /*** 根据id删除邮票     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteById(@PathVariable Integer id){
        stampDatabaseService.deleteById(id);
        return "删除成功";    }
    /*** 根据名称删除邮票     */
    @RequestMapping(value = "/{stampName}",method = RequestMethod.DELETE)
    public String deleteByName(@PathVariable String name){
        Integer id=selectId(name);
        stampDatabaseService.deleteById(id);
        return "删除成功";    }

    /*** 查询所有邮票     */
    @RequestMapping(method = RequestMethod.GET)
    public List<StampDatabase> findAll(){
        return stampDatabaseService.findAll();
    }
    /*** 根据id查询邮票     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public StampDatabase findById(@PathVariable Integer id){
        return stampDatabaseService.findById(id);    }
    /*** 根据邮票名称查询邮票     */
    @RequestMapping(value = "/{stampName}",method = RequestMethod.GET)
    public StampDatabase findByName(@PathVariable String name){
        Integer id=this.selectId(name);
        {return stampDatabaseService.findById(id);}
    }
    /*** 修改邮票     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String update(@RequestBody StampDatabase stampDatabase, @PathVariable Integer id){
        //设置id
        stampDatabase.setId(id);
        stampDatabaseService.update(stampDatabase);
        return "修改成功";    }
    /*** 修改用户     */
    @RequestMapping(value = "/{stampName}",method = RequestMethod.PUT)
    public String update(@RequestBody StampDatabase stampDatabase){
        stampDatabaseService.update(stampDatabase);
        return "修改成功";    }

}
