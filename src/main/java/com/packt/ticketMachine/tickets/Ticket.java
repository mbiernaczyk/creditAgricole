package com.packt.ticketMachine.tickets;

public abstract class Ticket {

    boolean relief;

    public boolean isRelief() {
        return relief;
    }

    public void setRelief(boolean relief) {
        this.relief = relief;
    }

    public Ticket(boolean relief) {
        this.relief = relief;
    }

    abstract public double getPrice();

    public abstract String getName();

}
