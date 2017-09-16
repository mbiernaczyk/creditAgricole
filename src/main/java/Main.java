import com.packt.ticketMachine.tickets.Ticket;
import com.packt.ticketMachine.tickets.TimeTicket;
import userInterface.Cart;
import userInterface.UserInterface;

import java.util.ArrayList;

/**
 * Created by Drakles on 14.09.2017.
 */
public class Main {
    public static void main(String[] args){
        UserInterface userInterface = new UserInterface(new Cart(new ArrayList<Ticket>()));
        userInterface.start();

        //TimeTicket bilecik = new TimeTicket(false, TimeTicket.TypeOfTimeTicket.TWENTYFOURHOURS);

        //System.out.println(bilecik.getPrice());

    }
}
