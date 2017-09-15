package com.packt.ticketMachine.tickets;

/**
 * Created by Drakles on 13.09.2017.
 */
public class SingleTicket extends Ticket {

    private TypeOfSingleTicket type;

    public enum TypeOfSingleTicket{
        NORMAL("bilet normalny",Prices.getSingleNormal()),
        SPECIAL("bilet specjalny",Prices.getSingleSpecial()),;

        private final String name;
        private final double price;

        TypeOfSingleTicket(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    public SingleTicket(boolean relief, TypeOfSingleTicket type) {
        super(relief);
        this.type = type;
    }

    @Override
    public double getPrice() {
        return super.relief ? this.type.getPrice()*0.65 : this.type.getPrice();
    }
}
