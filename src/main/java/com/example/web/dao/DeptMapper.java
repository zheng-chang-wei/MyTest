package com.example.web.dao;

import com.example.web.bean.Dept;
import com.example.web.bean.Employee;
import com.example.web.config.CommonMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@CacheNamespace
public interface DeptMapper extends CommonMapper<Dept> {

//  @Select(
//      "SELECT id FROM (SELECT t1.id,IF(FIND_IN_SET(parent_id, @pids) > 0, @pids := CONCAT(@pids, ',', id), 0) AS ischild FROM (SELECT id,parent_id FROM dept2 t  ORDER BY parent_id, id) t1,(SELECT @pids := 1) t2) t3 WHERE ischild != 0")
//  List<Dept> selectDept();


  @Select("select * from dept2 where parent_id = #{parentId}")
  List<Dept> selectDept(int parentId);
}
