package com.zzsharing.model;

import javax.persistence.*;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/28 21:22.
 */
@Entity
@Table(name = "t_teacher")
public class Teacher extends BaseEntity {

    private String name;

    private String headimg;

    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
