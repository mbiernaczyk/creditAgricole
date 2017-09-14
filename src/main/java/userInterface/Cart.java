package userInterface;

import com.packt.ticketMachine.tickets.Ticket;

import java.util.ArrayList;

/**
 * Created by Drakles on 13.09.2017.
 */
public class Cart {
    private ArrayList<Ticket> ticketsList;

    public Cart(ArrayList<Ticket> ticketsList) {
        this.ticketsList = ticketsList;
    }

    public void addTicket(Ticket newTicket){
        ticketsList.add(newTicket);
    }

    public void removeTicket(Ticket ticketToRemove){
        ticketsList.remove(ticketToRemove);
    }
}
