package com.immanager.business;

import com.immanager.dataAccess.*;
import com.immanager.dataAccess.dao.*;
import com.immanager.exception.*;
import com.immanager.model.Contract;
import com.immanager.model.ContractResult;
import com.immanager.model.Person;

import java.util.ArrayList;

public class ContractManager {
    private ContractDAO contractDataAccess;
    private PaymentDAO paymentDataAccess;
    private RentDAO rentDataAccess;
    private ApartmentDAO apartmentDataAccess;
    private PersonDAO personDataAccess;

    public ContractManager() {
        setContractDataAccess(new ContractDbAccess());
        setPaymentDataAccess(new PaymentDbAccess());
        setRentDataAccess(new RentDbAccess());
        setApartmentDataAccess(new ApartmentDbAccess());
        setPersonDataAccess(new PersonDbAccess());
    }

    public ArrayList<ContractResult> getAllContracts() throws AllContractException, ApartmentByIdException, PersonByIDException, AllPaymentException, AllRentException {
        ArrayList<ContractResult> contractResults = new ArrayList<>();
        ArrayList<Contract> contracts = contractDataAccess.getAllContracts();

        for (Contract contract : contracts) {
            ArrayList<Person> guarantees = new ArrayList<>();

            if (contract.getGuarantee1() != null)
                guarantees.add(personDataAccess.getPersonById(contract.getGuarantee1()));
            if (contract.getGuarantee2() != null)
                guarantees.add(personDataAccess.getPersonById(contract.getGuarantee2()));

            ContractResult contractResult = new ContractResult(
                    contract,
                    apartmentDataAccess.getApartmentById(contract.getApartmentID()),
                    personDataAccess.getPersonById(contract.getRenterID()),
                    guarantees,
                    paymentDataAccess.getAllPaymentFromRenter(contract.getId()),
                    rentDataAccess.getAllRentFromRenter(contract.getId())
            );

            contractResults.add(contractResult);
        }

        return  contractResults;

    }

    public void addContract(Contract contract) throws AddContractException {
        contractDataAccess.addContract(contract);
    }

    public void setContractDataAccess(ContractDAO contarctDataAccess) {
        this.contractDataAccess = contarctDataAccess;
    }

    public void setPaymentDataAccess(PaymentDAO paymentDataAccess) {
        this.paymentDataAccess = paymentDataAccess;
    }

    public void setRentDataAccess(RentDAO rentDataAccess) {
        this.rentDataAccess = rentDataAccess;
    }

    public void setApartmentDataAccess(ApartmentDAO apartmentDataAccess) {
        this.apartmentDataAccess = apartmentDataAccess;
    }

    public void setPersonDataAccess(PersonDAO personDataAccess) {
        this.personDataAccess = personDataAccess;
    }
}
