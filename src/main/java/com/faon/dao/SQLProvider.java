package com.faon.dao;


import java.util.Map;

public interface SQLProvider<T> {
    String list();
    String get(Map selectCondition);
    String add(T t);
    String update(Map updateCondition);
    String delete(int id);


}
