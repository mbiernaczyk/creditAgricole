package com.packt.ticketMachine.tickets;

/**
 * Created by Drakles on 13.09.2017.
 */
public class TimeTicket extends Ticket {
    //private int time;
    private TypeOfTimeTicket typeOfTimeTicket;

    public enum TypeOfTimeTicket {
        HALFHOUR("Bilet 30 minutowy",Prices.getTime30Minutes()),
        HOUR("Bilet 60 minutowy",Prices.getTime60Minutes()),
        ONEANDHALFHOUR("Bilet 90 minutowy",Prices.getTime90Minutes()),
        TWENTYFOURHOURS("Bilet 24 godzinny",Prices.getTime24Hours());

        private final String name;
        private final double price;

        TypeOfTimeTicket(String name, double price){
            this.name=name;
            this.price=price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public TimeTicket( boolean relief,TypeOfTimeTicket typeOfTimeTicket) {
        super(relief);
        //this.time = time;
        this.typeOfTimeTicket = typeOfTimeTicket;

    }

    @Override
    public double getPrice() {

        return super.relief ? this.typeOfTimeTicket.getPrice()*0.65:this.typeOfTimeTicket.getPrice();

    }

}
