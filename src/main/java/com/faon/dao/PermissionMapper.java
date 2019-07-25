package com.faon.dao;

import com.faon.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionMapper {

    Permission getPermissionById(int id);

    List<Permission> getPermissionsByUserId(int userId);
}
