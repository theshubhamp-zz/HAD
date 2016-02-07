package com.analysis.dao;

import java.util.List;

/**
 * @author Akshat Shukla
 * @since February 7, 2016
 */
public interface AbstractDAO
{
    void addObject(Object obj);
    List<?> getList();
    void query();
}
