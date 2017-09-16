package com.packt.ticketMachine.tickets;

/**
 * Created by Drakles on 13.09.2017.
 */
public class TimeTicket extends Ticket {

    private TypeOfTimeTicket type;

    public TimeTicket(boolean relief, int codeOfType) throws Exception {
        super(relief);

        switch (codeOfType) {
            case 1:
                TicketsContainer.decreaseTimeHalfHour();
                this.type = TypeOfTimeTicket.HALFHOUR;
                break;
            case 2:
                TicketsContainer.decreaseTimeOneHour();
                this.type = TypeOfTimeTicket.HOUR;
                break;
            case 3:
                TicketsContainer.decreaseOneAndHalfHour();
                this.type = TypeOfTimeTicket.ONEANDHALFHOUR;
                break;
            case 4:
                TicketsContainer.decreaseTwentyfourHours();
                this.type = TypeOfTimeTicket.TWENTYFOURHOURS;

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

    public enum TypeOfTimeTicket {
        HALFHOUR("bilet 30 minutowy", Prices.getTime30Minutes()),
        HOUR("bilet 60 minutowy", Prices.getTime60Minutes()),
        ONEANDHALFHOUR("bilet 90 minutowy", Prices.getTime90Minutes()),
        TWENTYFOURHOURS("bilet 24 godzinny", Prices.getTime24Hours());

        private final String name;
        private final double price;

        TypeOfTimeTicket(String name, double price) {
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
