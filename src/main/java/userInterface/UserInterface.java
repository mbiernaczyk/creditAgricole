package userInterface;

import com.packt.ticketMachine.tickets.Prices;

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

    private void printSingleTickets() {
        System.out.println("Wybrano bilety jednorazowe");

        System.out.println("Wybierz 1 aby wybrać bilet normalny " + Prices.getSingleNormal() + "zł");
        System.out.println("Wybierz 2 aby wybrać bilet specjalny " + Prices.getSingleSpecial() + "zł");

    }

    private void printTimeTickets() {
        System.out.println("Wybrano bilety czasowe");

        System.out.println("Wybierz 1 aby wybrać bilet 30 minutowy " + Prices.getTime30Minutes() + "zł");
        System.out.println("Wybierz 2 aby wybrać bilet 60 minutowy " + Prices.getTime60Minutes() + "zł");
        System.out.println("Wybierz 3 aby wybrać bilet 90 minutowy " + Prices.getTime90Minutes() + "zł");
        System.out.println("Wybierz 4 aby wybrać bilet 24 godzinny " + Prices.getTime24Hours() + "zł");

    }

    private void printmenu() {
        System.out.println("Wybierz jaki bilet chcesz kupić");

        System.out.println("Wybierz 1 aby wybrać bilet czasowy");
        System.out.println("Wybierz 2 aby wybrać bilety jednorazowe");
    }

}
