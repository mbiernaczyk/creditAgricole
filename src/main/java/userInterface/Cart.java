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

    public void displayCart() {

        double sum = 0;

        if(ticketsList.size() <= 0){
            System.out.println("Nie dodano żadnych biletów do koszyka");
            System.out.println("Do zapłaty "+ sum+"zł");
        }else {
            for (Ticket ticket : ticketsList) {
                System.out.println(ticket.getName() + ticket.getPrice() + "zł");
                sum += ticket.getPrice();
            }
            System.out.println("Do zapłaty "+ sum +"zł");
        }
    }

    public void removeAllTickets() {
        ticketsList.clear();
    }
}
