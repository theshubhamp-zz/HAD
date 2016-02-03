package com.had.handlers;

import com.google.gson.Gson;
import com.had.dao.StateDAO;

/**
 * @author Shubham S Patil
 * @since February 3, 2016
 */
public class StateHandler {
    public String getStateData() {
        StateDAO stateDAO = new StateDAO();
        return new Gson().toJson(stateDAO.getList());
    }
}
