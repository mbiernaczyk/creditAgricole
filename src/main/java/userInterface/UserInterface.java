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

    private Cart cart;

    public UserInterface(Cart cart) {
        this.cart = cart;
    }

    public void start() {
        System.out.println("Witom Pana użytkownika\n");

        boolean stopWorking = false;
        while (!stopWorking) {
            displayMenu();

            Scanner in = new Scanner(System.in);

            try {

                int choose = in.nextInt();
                    switch (choose) {

                        case 0:
                            cart.displayCart();
                            break;

                        case 1:
                            displayTimeTickets();

                            choose = in.nextInt();

                            if (choose >= 1 && choose <= 4) {

                                addTimeTicketToCart(getTotalQuantityFromUser(), getQuantityOfReliefTicketsFromUser(), choose);

                            } else {
                                throw new InvalidArgumentException(new String[]{"Podano niepoprawną wartość"});
                            }
                            break;

                        case 2:
                            displaySingleTickets();

                            choose = in.nextInt();

                            if (choose == 1 || choose == 2) {
                                addSingleTicketToCart(getTotalQuantityFromUser(), getQuantityOfReliefTicketsFromUser(), choose);

                            } else {
                                throw new InvalidArgumentException(new String[]{"Podano niepoprawną wartość"});
                            }
                            break;

                        case 3:
                            //TO DO PŁĄTNOŚC
                            break;

                        case 4:
                            cart.removeAllTickets();
                            stopWorking = true;
                            break;

                        default:
                        throw new InvalidArgumentException(new String[]{"Podano niepoprawną wartość"});
                    }
            } catch (InvalidArgumentException e) {
                System.out.println(e.getRealMessage());
                System.out.println("Spróbuj ponownie");
            }

        }
    }

    private void addSingleTicketToCart(int totalQuantity, int quantityOfReliefTickets, int choose) {
        try {
            if (quantityOfReliefTickets > 0) {
                for (int i = 0; i < quantityOfReliefTickets; i++) {
                    cart.addTicket(new SingleTicket(true, choose));
                }
            }
            for (int i = 0; i < totalQuantity - quantityOfReliefTickets; i++) {
                cart.addTicket(new SingleTicket(false, choose));
            }

            System.out.println("Dodawno do koszyka");

        } catch (IllegalArgumentException e) {
            System.out.println("Błąd systemu - " + e.getMessage() + " skontaktuj się z obsługą techniczną");
        }
    }


    private void addTimeTicketToCart(int totalQuantityOfTickets, int quantityOfReliefTickets, int choose) {

        try {
            if (quantityOfReliefTickets > 0) {
                for (int i = 0; i < quantityOfReliefTickets; i++) {
                    cart.addTicket(new TimeTicket(true, choose));
                }
                for (int i = 0; i < totalQuantityOfTickets - quantityOfReliefTickets; i++) {
                    cart.addTicket(new TimeTicket(false, choose));
                }
            }else {
                for (int i = 0; i < totalQuantityOfTickets; i++) {
                    cart.addTicket(new TimeTicket(false, choose));
                }
            }

            System.out.println("Dodawno do koszyka");

        } catch (IllegalArgumentException e) {
            System.out.println("Błąd systemu - " + e.getMessage() + " skontaktuj się z obsługą techniczną");
        }
    }

    private int getTotalQuantityFromUser() {
        System.out.println("Podaj ilość");
        Scanner in = new Scanner(System.in);
        int quantity = in.nextInt();

        return quantity;
    }

    private int getQuantityOfReliefTicketsFromUser() {

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

    private void displayMenu() {

        System.out.println("wybierz 0 aby wyświetlić koszyk");

        System.out.println("Wybierz 1 aby wybrać bilet czasowy");
        System.out.println("Wybierz 2 aby wybrać bilety jednorazowe");

        System.out.println("Wybierz 3 aby przejść do płatności");

        System.out.println("Wybierz 4 aby zrezygnować z zakupu");

    }

}
