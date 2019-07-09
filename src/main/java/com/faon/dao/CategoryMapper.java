package com.faon.dao;

import com.faon.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    Category  getById(Long id);
}
