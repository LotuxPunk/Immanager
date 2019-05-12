package com.immanager.dataAccess;

import com.immanager.dataAccess.dao.RentDAO;
import com.immanager.exception.AllRentException;
import com.immanager.model.RentOwed;

import java.util.ArrayList;

public class RentDbAccess implements RentDAO {
    @Override
    public ArrayList<RentOwed> getAllRentFromRenter(Integer renterID) throws AllRentException {
        return null;
    }
}
