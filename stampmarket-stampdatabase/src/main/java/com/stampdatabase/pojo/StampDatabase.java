package com.stampdatabase.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stampmarket")
public class StampDatabase implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;//编号
        private String stampName;//用户名
        private String Description;//密码
        private Integer unit_price;//性别
        private Integer remainingNum;//余额
        public StampDatabase() {
        }
        public StampDatabase(Integer id, String stampName, String Description, Integer unit_price, Integer remainingNum) {
            this.id = id;
            this.stampName = stampName;
            this.Description = Description;
            this.unit_price = unit_price;
            this.remainingNum = remainingNum;
        }
        public Integer getId() {        return id;    }
        public void setId(Integer id) {        this.id = id;    }
        public String getstampName() {        return stampName;    }
        public void setstampName(String stampName) {        this.stampName = stampName;    }
        public String getDescription() {        return Description;    }
        public void setDescription(String Description) {        this.Description = Description;    }
        public Integer getunit_price() {        return unit_price;    }
        public void setSex(Integer sex) {        this.unit_price = unit_price;    }
        public Integer getremainingNum() {        return remainingNum;    }
        public void setremainingNum(Integer remainingNum) {        this.remainingNum = remainingNum;    }
    }
