package com.zzsharing.specification;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/29 8:49.
 */
public class Condition {

    private String key;

    private String operation;

    private Object value;

    private String connection;

    public static Condition one(String key, String operation, Object value) {
        return new Condition(key, operation, value);
    }

    public static Condition one(String key, String operation, Object value, String connection) {
        return new Condition(key, operation, value, connection);
    }

    public Condition(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;

        this.connection = "and";
    }

    public Condition(String key, String operation, Object value, String connection) {
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.connection = connection;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }
}
