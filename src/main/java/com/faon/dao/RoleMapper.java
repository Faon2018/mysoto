package com.faon.dao;

import com.faon.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
//    @Select("select * from role where id=#{id}")
    Role getRoleById(int id);

    List<Role> getRolesByUserId(int userId);
}
