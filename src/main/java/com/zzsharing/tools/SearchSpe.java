package com.zzsharing.tools;

/**
 * Created by 钟述林 393156105@qq.com on 2016/11/28 21:57.
 */
public class SearchSpe {
    private String key;

    private String opt;

    private String value;

    public SearchSpe(String key, String opt, String value) {
        this.key = key;
        this.opt = opt;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
