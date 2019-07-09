package com.faon.service.impl;

import com.faon.dao.ArticleMapper;
import com.faon.entity.Article;
import com.faon.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Article> getAll() {
        return  articleMapper.selectAll();
    }
}
