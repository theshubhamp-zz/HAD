package com.had.data;

/**
 * @author Shubham S Patil
 * @since February 9, 2016
 */
public class HhUrtAnalysis {
    String name;
    int urt_id;
    int hh_no;

    public HhUrtAnalysis(String name, int urt_id, int hh_no) {
        this.name = name;
        this.urt_id = urt_id;
        this.hh_no = hh_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUrt_id() {
        return urt_id;
    }

    public void setUrt_id(int urt_id) {
        this.urt_id = urt_id;
    }

    public int getHh_no() {
        return hh_no;
    }

    public void setHh_no(int hh_no) {
        this.hh_no = hh_no;
    }
}
