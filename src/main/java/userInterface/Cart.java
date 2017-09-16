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

        if(ticketsList.size() <= 0){
            System.out.println("Nie dodano żadnych biletów do koszyka\n");
        }else {
            for (Ticket ticket : ticketsList) {
                System.out.format("%s %.2f %s %n", ticket.getName(), ticket.getPrice(), "zł");
            }
            displaySumToPay();
        }
    }

    public void removeAllTickets() {
        ticketsList.clear();
    }

    public double calculateSum(){
        double sum = 0;
        for (Ticket ticket : ticketsList) {
            sum += ticket.getPrice();
        }
        return sum;

    }

    public void displaySumToPay() {
        System.out.format("%s %.2f %s %n", "Do zapłaty ", calculateSum() ,"zł");

    }
}
