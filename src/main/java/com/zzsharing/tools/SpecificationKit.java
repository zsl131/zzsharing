package com.zzsharing.tools;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/28 21:57.
 */
public class SpecificationKit {

    public static Specification buildSpe(String key, String opt, String value) {
        BaseSpecification bs = new BaseSpecification(key, opt, value);

        return bs;
    }

    public static Specification buildSpe(List<SearchSpe> ...spes) {

    }

    public static Specification buildSpe(SearchSpe ...spe) {

    }
}
