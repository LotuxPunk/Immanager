package com.immanager.model;

public class PaymentResult {
    private Payment payment;
    private Person person;

    public PaymentResult(Payment payment, Person person) {
        setPayment(payment);
        setPerson(person);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
