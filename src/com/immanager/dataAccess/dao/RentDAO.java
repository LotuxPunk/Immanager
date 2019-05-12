package com.immanager.dataAccess.dao;

import com.immanager.exception.AllRentException;
import com.immanager.model.RentOwed;

import java.util.ArrayList;

public interface RentDAO {
    ArrayList<RentOwed> getAllRentFromRenter(Integer contractID) throws AllRentException;
}
