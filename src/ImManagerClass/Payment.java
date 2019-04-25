package ImManagerClass;

import java.util.GregorianCalendar;

public class Payment
{
    private double amount;
    private GregorianCalendar date;

    public Payment (double amount, GregorianCalendar date)
    {
        setAmount(amount);
        setDate(date);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}
