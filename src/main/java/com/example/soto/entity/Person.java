package com.example.soto.entity;



import javax.persistence.*;


@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;
    @Column(name = "is_del",length = 1)
    private int isdel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getIsdel() {
        return isdel;
    }

    public void setIsdel(int isdel) {
        this.isdel = isdel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", isdel=" + isdel +
                '}';
    }
}
