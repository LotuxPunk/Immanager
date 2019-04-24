package ImManagerClass;

import java.util.GregorianCalendar;

public class Rent_Owed
{
    private double rent;
    private double charge;
    private GregorianCalendar date;
    private Contract contract;

    public Rent_Owed(double rent, double charge, GregorianCalendar date) {
        setRent(rent);
        setCharge(charge);
        setDate(date);
    }


    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}
