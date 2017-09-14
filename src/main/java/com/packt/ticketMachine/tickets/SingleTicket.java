package com.packt.ticketMachine.tickets;

/**
 * Created by Drakles on 13.09.2017.
 */
public class SingleTicket extends Ticket {
    private boolean special;

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public SingleTicket(boolean relief, boolean special) {
        super(relief);
        this.special = special;
    }

    @Override
    public double getPrice() {
        if (!special){
            return Prices.singleNormal;
        } else {
            return Prices.singleSpecial;
        }
    }
}
