package com.zzsharing.specification;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Created by zsl-pc on 2016/9/15.
 */
public class BottomSpecification<T> implements Specification<T> {

    public static final String GRATE_EQUAL = "ge"; //大于等于
    public static final String GRATE_THEN = "gt"; //大于
    public static final String LESS_EQUAL = "le"; //小于等于
    public static final String LESS_THEN = "lt"; //小于
    public static final String LIKE_BEGIN = "likeb"; // like '%?'
    public static final String LIKE_END = "likee"; //like '?%'
    public static final String LIKE = "like"; //like '%?%'
    public static final String LIKE_BEGIN_END = "likebe"; //like '%?%'
    public static final String NOT_LIKE_BEGIN = "nlikeb"; //not like '%?'
    public static final String NOT_LIKE_END = "nlikee"; //not like '?%'
    public static final String NOT_LIKE = "nlike"; //not like '%?%'
    public static final String NOT_LIKE_BEGIN_END = "nlikebe"; // not like '%?%'
    public static final String EQUAL = "eq"; //equal =
    public static final String NOT_EQUAL = "neq"; // not equal   !=
    public static final String IS_NULL = "isnull"; //is null

    public BottomSpecification(String key, String opt, String value) {
        conditions = new Condition[] {new Condition(key, opt, value)};
    }

    public BottomSpecification(String key, String operation, String value, String connection) {
        conditions = new Condition[]{new Condition(key, operation, value, connection)};
    }

    public BottomSpecification(Condition ...conditions) {
        this.conditions = conditions;
    }

    private Condition [] conditions;
    public BottomSpecification(Condition con) {
        conditions = new Condition[]{con};
    }
    @Override
    public Predicate toPredicate
            (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Predicate result = null;
        for(Condition con : conditions) {
            String connection = con.getConnection();
            Predicate pre = buildPre(root, builder, con);
            if(pre!=null) {
                if(result==null) {
                    result = pre;
                } else {
                    if (connection.equalsIgnoreCase("and")) {
                        result = builder.and(result, pre);
                    } else if(connection.equalsIgnoreCase("or")) {
                        result = builder.or(result, pre);
                    }
                }
            }
        }
        return result;
    }

    private Predicate buildPre(Root<T> root, CriteriaBuilder builder, Condition con) {
        String opt = con.getOperation();
        String key = con.getKey();
        String value = con.getValue().toString();
        if (opt.equalsIgnoreCase(GRATE_EQUAL)) { //大于等于
            return builder.greaterThanOrEqualTo(
                    root.<String> get(key), value);
        } else if(opt.equalsIgnoreCase(GRATE_THEN)) { //大于
            return builder.greaterThan(root.get(key), value);
        } else if(opt.equalsIgnoreCase(LESS_EQUAL)) { //小于等于
            return builder.lessThanOrEqualTo(root.get(key), value);
        } else if(opt.equalsIgnoreCase(LESS_THEN)) { //小于
            return builder.lessThan(root.get(key), value);
        } else if(opt.equalsIgnoreCase(LIKE_BEGIN)) { // like '%?'
            return builder.like(root.get(key), "%"+value);
        } else if(opt.equalsIgnoreCase(LIKE_END)) { // like '?%'
            return builder.like(root.get(key), value+"%");
        } else if(opt.equalsIgnoreCase(LIKE) || opt.equalsIgnoreCase(LIKE_BEGIN_END)) { //like '%?%'
            return builder.like(root.get(key), "%"+value+"%");
        } else if(opt.equalsIgnoreCase(NOT_LIKE_BEGIN)) { // not like '%?'
            return builder.notLike(root.get(key), "%"+value);
        } else if(opt.equalsIgnoreCase(NOT_LIKE_END)) { // not like '?%'
            return builder.notLike(root.get(key), value + "%");
        } else if(opt.equalsIgnoreCase(NOT_LIKE) || opt.equalsIgnoreCase(NOT_LIKE_BEGIN_END)) { //not like '%?%'
            return builder.notLike(root.get(key), "%"+value+"%");
        } else if(opt.equalsIgnoreCase(EQUAL)) { //equal
            return builder.equal(root.get(key), value);
        } else if(opt.equalsIgnoreCase(NOT_EQUAL)) { //not equal
            return builder.notEqual(root.get(key), value);
        } else if(opt.equalsIgnoreCase(IS_NULL)) { // is null
            return builder.isNull(root.get(key));
        }
        return null;
    }
}