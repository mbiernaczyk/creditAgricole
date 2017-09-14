package com.packt.ticketMachine.tickets;

/**
 * Created by Drakles on 13.09.2017.
 */
public class TimeTicket extends Ticket {
    private int time;


    public TimeTicket( boolean relief, int time) {
        super(relief);
        this.time = time;

    }

    @Override
    public double getPrice() {

        double price = 0;

        switch (time){
            case 30:
                price = Prices.time30Minutes;
                break;
            case 60:
                price= Prices.time60Minutes;
                break;
            case 90:
                price= Prices.time90Minutes;
                break;
            case 24:
                price= Prices.time24Hours;
                break;
        }
        return price;
    }
}
