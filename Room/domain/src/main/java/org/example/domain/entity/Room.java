package org.example.domain.entity;

import java.sql.Date;

public class Room {
    private int id;
    private String name;
    private Date bgndate;
    private Date enddate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBgndate() {
        return bgndate;
    }

    public void setBgndate(Date bgndate) {
        this.bgndate = bgndate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    private Room(Builder builder) {
        this.setId(builder.id);
        this.setBgndate(builder.bgndate);
        this.setEnddate(builder.enddate);
        this.setName(builder.name);
    }

    public static class Builder {
        private int id;
        private String name;
        private Date bgndate;
        private Date enddate;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder bgndate(Date bgndate) {
            this.bgndate = bgndate;
            return this;
        }
        public Builder enddate(Date enddate) {
            this.enddate = enddate;
            return this;
        }

        public Room build() {
            return new Room(this);
        }
    }
}
