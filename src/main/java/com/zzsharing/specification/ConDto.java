package com.zzsharing.specification;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/29 9:44.
 */
public class ConDto {

    private String con;

    private Condition [] conditions;

    public ConDto(String con, Condition ...conditions) {
        this.con = con;
        this.conditions = conditions;
    }

    public ConDto(String con, String key, String operation, Object value) {
        this.con = con;
        this.conditions = new Condition[] {new Condition(key, operation, value)};
    }

    public ConDto(String con, String key, String operation, Object value, String connection) {
        this.con = con;
        this.conditions = new Condition[] {new Condition(key, operation, value, connection)};
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public Condition [] getConditions() {
        return conditions;
    }

    public void setCondition(Condition [] conditions) {
        this.conditions = conditions;
    }
}
