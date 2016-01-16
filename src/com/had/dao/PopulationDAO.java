package com.had.dao;

import java.util.ArrayList;
import java.util.List;
import com.had.data.Population;

/**
 * @author Shubham S Patil
 * @since January 13, 2016
 */
public class PopulationDAO {

    List<Population> populations;
	public PopulationDAO() {
        populations = new ArrayList<>();
	}
    public void addPopulation(Population obj)
    {
        populations.add(obj);
    }
    public List<Population> getPopulations() {
        return populations;
    }
}
