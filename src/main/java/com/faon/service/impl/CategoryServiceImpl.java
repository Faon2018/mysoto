package com.faon.service.impl;

import com.faon.dao.CategoryMapper;
import com.faon.entity.Category;
import com.faon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public Category getById(Long id) {
        return categoryMapper.getById(id);
    }
}
