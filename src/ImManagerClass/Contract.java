package ImManagerClass;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Contract
{
    private int id;
    private GregorianCalendar date_start;
    private GregorianCalendar date_end;
    private double warranty;
    private boolean cpasWarranty;
    private Person guarantee1;
    private Person guarantee2;
    private Person renter;
    private Apartment apartment;
    private String refEnregistrement;

    private ArrayList<Rent_Owed> rent_oweds;
    private ArrayList<Payment> payments;

    public Contract(int id, GregorianCalendar date_start, GregorianCalendar date_end, double warranty, boolean cpasWarranty, Person guarantee1, Person guarantee2, Person renter, Apartment apartment, String refEnregistrement) {
        this.id = id;
        setDate_start(date_start);
        setDate_end(date_end);
        setWarranty(warranty);
        setCpasWarranty(cpasWarranty);
        setGuarantee1(guarantee1);
        setGuarantee2(guarantee2);
        setRenter(renter);
        setApartment(apartment);
        setRefEnregistrement(refEnregistrement);
        rent_oweds= new ArrayList<Rent_Owed>();
        payments= new ArrayList<Payment>();
    }

    public GregorianCalendar getDate_start() {
        return date_start;
    }

    public void setDate_start(GregorianCalendar date_start) {
        this.date_start = date_start;
    }

    public GregorianCalendar getDate_end() {
        return date_end;
    }

    public void setDate_end(GregorianCalendar date_end) {
        this.date_end = date_end;
    }

    public double getWarranty() {
        return warranty;
    }

    public void setWarranty(double warranty) {
        this.warranty = warranty;
    }

    public boolean isCpasWarranty() {
        return cpasWarranty;
    }

    public void setCpasWarranty(boolean cpasWarranty) {
        this.cpasWarranty = cpasWarranty;
    }

    public Person getGuarantee1() {
        return guarantee1;
    }

    public void setGuarantee1(Person guarantee1) {
        this.guarantee1 = guarantee1;
    }

    public Person getGuarantee2() {
        return guarantee2;
    }

    public void setGuarantee2(Person guarantee2) {
        this.guarantee2 = guarantee2;
    }

    public Person getRenter() {
        return renter;
    }

    public void setRenter(Person renter) {
        this.renter = renter;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public String getRefEnregistrement() {
        return refEnregistrement;
    }

    public void setRefEnregistrement(String refEnregistrement) {
        this.refEnregistrement = refEnregistrement;
    }

    public void addRent_Owed(Rent_Owed rent)
    {
        rent_oweds.add(rent);
    }

    public void addPayment (Payment payment)
    {
        payments.add(payment);
    }
}
