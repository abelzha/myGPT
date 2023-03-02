package cn.abel.meta.vo;


public class KeyValuePair {
    private int key;
    private String value;
    private String descr;

    public KeyValuePair(int key, String value, String descr) {
        this.key = key;
        this.value = value;
        this.descr = descr;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

}
