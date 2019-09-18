package ru.job4j.pojo;

import java.util.Date;
/**
 * Модель данных
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 19.09.2019
 */
public class License {
    private String owner;
    private String model;
    private String code;
    private Date created;

    String getOwner() {
        return owner;
    }

    void setOwner(String owner) {
        this.owner = owner;
    }

    String getModel() {
        return model;
    }

    void setModel(String model) {
        this.model = model;
    }

    String getCode() {
        return code;
    }

    void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    void setCreated(Date created) {
        this.created = created;
    }
}
