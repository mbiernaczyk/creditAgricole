package com.packt.ticketMachine.tickets;

/**
 * Created by Drakles on 13.09.2017.
 */
public class SingleTicket extends Ticket {

    private TypeOfSingleTicket type;

    public SingleTicket(boolean relief, int codeOfType) throws Exception {
        super(relief);

        switch (codeOfType) {
            case 1:
                TicketsContainer.decreaseSingleNormal();
                this.type = TypeOfSingleTicket.NORMAL;
                break;
            case 2:
                TicketsContainer.decreaseSingleSpecial();
                this.type = TypeOfSingleTicket.SPECIAL;
                break;
            default:
                throw new IllegalArgumentException("Nie poprawny kod biletu");
        }
    }

    @Override
    public double getPrice() {
        return super.relief ? this.type.getPrice() * 0.65 : this.type.getPrice();
    }

    public String getName() {
        return type.getName();
    }

    public enum TypeOfSingleTicket {
        NORMAL("bilet normalny", Prices.getSingleNormal()),
        SPECIAL("bilet specjalny", Prices.getSingleSpecial()),;

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
}
