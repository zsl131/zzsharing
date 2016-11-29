package com.zzsharing.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/29 10:02.
 */
public class SpecificationUtil {

    public static Specification buildSpe(String key, String operation, String value) {
        BottomSpecification bs = new BottomSpecification(key, operation, value);
        return bs;
    }

    public static Specification buildSpe(String key, String operation, String value, String connection) {
        BottomSpecification bs = new BottomSpecification(key, operation, value, connection);
        return bs;
    }

    public static Specification buildSpe(Condition ...cons) {
        BottomSpecification bs = new BottomSpecification(cons);
        return bs;
    }

    public static Specification buildSpe(ConDto ...dtos) {
        Specifications bs = null;
        for(ConDto dto : dtos) {
            if(bs==null) {
                bs = Specifications.where(buildSpe(dto.getConditions()));
            } else {
                if (dto.getCon().equalsIgnoreCase("and")) {
                    bs = bs.and(buildSpe(dto.getConditions()));
                } else if(dto.getCon().equalsIgnoreCase("or")) {
                    bs = bs.or(buildSpe(dto.getConditions()));
                }
            }
        }
        return bs;
    }
}
