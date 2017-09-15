package userInterface;

import com.packt.ticketMachine.tickets.Prices;
import com.packt.ticketMachine.tickets.TimeTicket;

import java.util.Scanner;

/**
 * Created by Drakles on 13.09.2017.
 */
public class UserInterface {

    public void start() {
        System.out.println("Witom Pana użytkownika");

        boolean stopWorking = false;

        printmenu();
        while (!stopWorking) {
            Scanner in = new Scanner(System.in);

            switch (in.nextInt()) {
                case 1:
                    printTimeTickets();

                    int choose = in.nextInt();

                    if(choose >= 1 && choose <= 4) {

                        userChooseTimeTicket(choose);
                    }
                    break;
                case 2:
                    printSingleTickets();
                    break;
                default:
                    System.out.println("Wybrano niepoprawną wartość");
                    printmenu();
            }

        }
    }

    private void userChooseTimeTicket(int choose) {
        System.out.println();
    }

    private void printSingleTickets() {
        System.out.println("Wybrano bilety jednorazowe");

        System.out.println("Wybierz 1 aby wybrać bilet normalny " + Prices.getSingleNormal() + "zł");
        System.out.println("Wybierz 2 aby wybrać bilet specjalny " + Prices.getSingleSpecial() + "zł");

    }

    private void printTimeTickets() {
        System.out.println("Wybrano bilety czasowe");

        System.out.println("Wybierz 1 aby wybrać"+ TimeTicket.TypeOfTimeTicket.HALFHOUR.getName() + Prices.getTime30Minutes() + "zł");
        System.out.println("Wybierz 2 aby wybrać"+ TimeTicket.TypeOfTimeTicket.HOUR.getName() + Prices.getTime60Minutes() + "zł");
        System.out.println("Wybierz 3 aby wybrać bilet 90 minutowy"+ TimeTicket.TypeOfTimeTicket.ONEANDHALFHOUR.getName() + Prices.getTime90Minutes() + "zł");
        System.out.println("Wybierz 4 aby wybrać bilet 24 godzinny"+ TimeTicket.TypeOfTimeTicket.TWENTYFOURHOURS.getName() + Prices.getTime24Hours() + "zł");

    }

    private void printmenu() {
        System.out.println("Wybierz jaki bilet chcesz kupić");

        System.out.println("Wybierz 1 aby wybrać bilet czasowy");
        System.out.println("Wybierz 2 aby wybrać bilety jednorazowe");
    }

}
