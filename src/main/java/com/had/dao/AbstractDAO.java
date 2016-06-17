package com.had.dao;

import java.util.List;

/**
 * @author Shubham S Patil
 * @since January 28, 2016
 */
public interface AbstractDAO
{
    void addObject(Object obj);
    List<?> getList();
    void query();
}
