package com.had.data;

/**
 * @author Shubham S Patil
 * @since February 3, 2016
 */
public class State {
    String name;
    int stateid;

    public State(String name, int stateid) {
        this.name = name;
        this.stateid = stateid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }
}
