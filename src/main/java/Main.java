import com.packt.ticketMachine.tickets.TimeTicket;
import userInterface.UserInterface;

/**
 * Created by Drakles on 14.09.2017.
 */
public class Main {
    public static void main(String[] args){
        //UserInterface userInterface = new UserInterface();
        //userInterface.start();

        TimeTicket bilecik = new TimeTicket(false, TimeTicket.TypeOfTimeTicket.TWENTYFOURHOURS);

        System.out.println(bilecik.getPrice());

    }
}
