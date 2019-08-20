package ru.job4j.tracker;

import java.util.Objects;

public class Item {
    private String id;
    private String name;
    private String desc;
    private long time;
//    private long created;


    public Item(String name, String desc, long time) {
        this.name = name;
        this.desc = desc;
        this.time = time;
    }

//    public Item(long created) {
//        this.created = created;
//    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * методы пока не используются
     */
    //    public void setName(String name) {
//        this.name = name;
//    }

   //    public void setDesc(String desc) {
//        this.desc = desc;
//    }

//    public long getTime() {
//        return time;
//    }

//    public void setTime(long time) {
//        this.time = time;
//    }

//    public long getCreated() {
//        return created;
//    }

//    public void setCreated(long created) {
//        this.created = created;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return time == item.time && Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(desc, item.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, time);
    }

    @Override
    public String toString() {
        return "ID заявки:   |" + this.id
                + '\n' + '\r'
                + "Имя заявки:  |" + this.name + '\n' + '\r'
                + "Описание:    |" + this.desc;
    }
}