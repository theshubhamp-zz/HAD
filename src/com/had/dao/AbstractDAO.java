package com.had.dao;

import com.had.data.Population;

import java.util.List;

/**
 * Created by Shubham S Patil on 1/28/2016.
 */
public interface AbstractDAO
{
    public void addObject(Object obj);
    public List getList();
    public void query();
}
