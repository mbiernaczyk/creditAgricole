package userInterface;

import com.packt.ticketMachine.tickets.Prices;
import com.packt.ticketMachine.tickets.SingleTicket;
import com.packt.ticketMachine.tickets.TimeTicket;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.Scanner;

/**
 * Created by Drakles on 13.09.2017.
 */
public class UserInterface {

    public void start() {
        System.out.println("Witom Pana użytkownika");

        boolean stopWorking = false;
        while (!stopWorking) {
            displaymenu();

            Scanner in = new Scanner(System.in);

            try {

                int choose =  in.nextInt();
                if(choose == 1 || choose == 2) {
                    switch (choose) {

                        case 1:
                            displayTimeTickets();

                            choose = in.nextInt();

                            if (choose >= 1 && choose <= 4) {

                                userChooseTimeTicket(choose);
                            } else {
                                throw new InvalidArgumentException(new String[]{"Nie poprawna wartość"});
                            }
                            break;

                        case 2:
                            displaySingleTickets();

                            choose = in.nextInt();

                            if(choose == 1 || choose == 2){
                                userChooseSingleTicket(choose);
                            }else {
                                throw new InvalidArgumentException(new String[]{"Nie poprawna wartość"});
                            }
                            break;

                    }
                }else {
                    throw new InvalidArgumentException(new String[]{"Nie poprawna wartość"});
                }
            } catch (InvalidArgumentException e) {
                System.out.println(e.getRealMessage());
                System.out.println("Spróbuj ponownie");
            }

        }
    }

    private void userChooseSingleTicket(int choose) {
    }

    private void userChooseTimeTicket(int choose) {



    }

    private int getQuantityFromUser(){
        System.out.println("Podaj ilość");
        Scanner in = new Scanner(System.in);
        int quantity = in.nextInt();

        return quantity;
    }

    private int getQuantityOfReliefTicketsFromUser(){

        System.out.println("Podaj ilość biletów ulgowych");
        Scanner in = new Scanner(System.in);
        int quantityOfRelief = in.nextInt();
        return quantityOfRelief;
    }


    private void displaySingleTickets() {
        System.out.println("Wybrano bilety jednorazowe");

        System.out.println("Wybierz 1 aby wybrać" + SingleTicket.TypeOfSingleTicket.NORMAL.getName() + Prices.getSingleNormal() + "zł");
        System.out.println("Wybierz 2 aby wybrać" + SingleTicket.TypeOfSingleTicket.SPECIAL.getName() + Prices.getSingleSpecial() + "zł");

    }

    private void displayTimeTickets() {
        System.out.println("Wybrano bilety czasowe");

        System.out.println("Wybierz 1 aby wybrać" + TimeTicket.TypeOfTimeTicket.HALFHOUR.getName() + Prices.getTime30Minutes() + "zł");
        System.out.println("Wybierz 2 aby wybrać" + TimeTicket.TypeOfTimeTicket.HOUR.getName() + Prices.getTime60Minutes() + "zł");
        System.out.println("Wybierz 3 aby wybrać" + TimeTicket.TypeOfTimeTicket.ONEANDHALFHOUR.getName() + Prices.getTime90Minutes() + "zł");
        System.out.println("Wybierz 4 aby wybrać" + TimeTicket.TypeOfTimeTicket.TWENTYFOURHOURS.getName() + Prices.getTime24Hours() + "zł");

    }

    private void displaymenu() {
        System.out.println("Wybierz jaki bilet chcesz kupić");

        System.out.println("Wybierz 1 aby wybrać bilet czasowy");
        System.out.println("Wybierz 2 aby wybrać bilety jednorazowe");
    }

}
