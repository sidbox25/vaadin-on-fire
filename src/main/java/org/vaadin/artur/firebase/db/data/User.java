package org.vaadin.artur.firebase.db.data;

import org.vaadin.artur.firebase.HasKey;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User implements HasKey {

    private String key;
    private String name;
    private String about;
    private int size;
    private int age;

    public User() {

    }

    public User(String name, int age, int size, String about) {
        super();
        this.name = name;
        this.age = age;
        this.size = size;
        this.about = about;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }

}
