package com.immanager.business;

import com.immanager.dataAccess.*;
import com.immanager.dataAccess.dao.*;
import com.immanager.exception.*;
import com.immanager.model.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

            ArrayList<ShowableRent> showableRents = getRentSchedule(rentDataAccess.getAllRentFromRenter(contract.getId()), contract.getDateEnd());

            ContractResult contractResult = new ContractResult(
                    contract,
                    apartmentDataAccess.getApartmentById(contract.getApartmentID()),
                    personDataAccess.getPersonById(contract.getRenterID()),
                    guarantees,
                    paymentDataAccess.getAllPaymentFromRenter(contract.getId()),
                    showableRents
            );

            contractResults.add(contractResult);
        }

        return  contractResults;

    }

    public void addContract(Contract contract, RentOwed rentOwed) throws AddContractException, AddRentOwedException {
        Integer id = contractDataAccess.addContract(contract);
        rentDataAccess.addRent(rentOwed, id);
    }

    /**
     * Tâche métier
     * @param rentOweds Tableau de loyers indexé
     * @param dateOut date de sortie du locataire (can be null)
     * @return Tableau de loyers à afficher dans la JTable
     */
    public ArrayList<ShowableRent> getRentSchedule(ArrayList<RentOwed> rentOweds, GregorianCalendar dateOut){
        ArrayList<ShowableRent> schedule = new ArrayList<>();
        int rentCount = rentOweds.size();
        GregorianCalendar today = new GregorianCalendar();
        GregorianCalendar endDate = new GregorianCalendar();
        GregorianCalendar nextMonth = rentOweds.get(0).getDate();

        for (RentOwed rent : rentOweds) {
            if (rentCount > 1){
                endDate = rentOweds.get(rentOweds.indexOf(rent) + 1).getDate();
                do {
                    schedule.add(new ShowableRent(rent, (GregorianCalendar) nextMonth.clone()));
                    nextMonth.add(GregorianCalendar.MONTH, 1);
                } while(nextMonth.compareTo(endDate) < 0);
            }
            else {
                do{
                    schedule.add(new ShowableRent(rent, (GregorianCalendar) nextMonth.clone()));
                    nextMonth.add(GregorianCalendar.MONTH, 1);
                    if (dateOut != null && dateOut.compareTo(nextMonth) >= 0)
                        break;
                } while (today.compareTo(nextMonth) >= 0);
            }
            rentCount--;
        }

        return schedule;
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
