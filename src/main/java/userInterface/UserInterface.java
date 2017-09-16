package userInterface;

import com.packt.ticketMachine.tickets.Prices;
import com.packt.ticketMachine.tickets.SingleTicket;
import com.packt.ticketMachine.tickets.TicketsContainer;
import com.packt.ticketMachine.tickets.TimeTicket;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.InputMismatchException;
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

        while (true) {
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
                        cart.displaySumToPay();
                        Payment payment = new Payment(cart);
                        payment.receiveCoin();
                        break;

                    case 4:
                        cart.removeAllTickets();
                        break;

                    default:
                        throw new InvalidArgumentException(new String[]{"Podano niepoprawną wartość"});
                }
            } catch (InvalidArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Spróbuj ponownie");
            }

        }
    }

    private void addSingleTicketToCart(int totalQuantity, int quantityOfReliefTickets, int choose) {
        try {
            switch (choose) {

                case 1:
                    if (totalQuantity < TicketsContainer.getSingleNormal()) {
                        if (quantityOfReliefTickets > 0) {
                            for (int i = 0; i < quantityOfReliefTickets; i++) {
                                cart.addTicket(new SingleTicket(true, choose));
                            }
                        }
                        for (int i = 0; i < totalQuantity - quantityOfReliefTickets; i++) {
                            cart.addTicket(new SingleTicket(false, choose));
                        }

                        System.out.println("Dodano do koszyka");
                    } else throw new Exception("Wymagana ilość biletów nie jest dostępna");
                    break;

                case 2:
                    if (totalQuantity < TicketsContainer.getSingleSpecial()) {
                        if (quantityOfReliefTickets > 0) {
                            for (int i = 0; i < quantityOfReliefTickets; i++) {
                                cart.addTicket(new SingleTicket(true, choose));
                            }
                        }
                        for (int i = 0; i < totalQuantity - quantityOfReliefTickets; i++) {
                            cart.addTicket(new SingleTicket(false, choose));
                        }

                        System.out.println("Dodano do koszyka");
                    } else throw new Exception("Wymagana ilość biletów nie jest dostępna");
                    break;


            }
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd systemu - " + e.getMessage() + " skontaktuj się z obsługą techniczną");
        } catch (InputMismatchException e){
            System.out.println("Nie poprawna wartość - spróbuj ponownie");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


    private void addTimeTicketToCart(int totalQuantityOfTickets, int quantityOfReliefTickets, int choose) {

        try {

            switch (choose) {

                case 1:
                    if (totalQuantityOfTickets < TicketsContainer.getTimeHalfHour()) {
                        if (quantityOfReliefTickets > 0) {
                            for (int i = 0; i < quantityOfReliefTickets; i++) {
                                cart.addTicket(new TimeTicket(true, choose));
                            }
                        }
                        for (int i = 0; i < totalQuantityOfTickets; i++) {
                            cart.addTicket(new TimeTicket(false, choose));
                        }
                        System.out.println("Dodawno do koszyka");
                    } else throw new Exception("Wymagana ilość biletów nie jest dostępna");
                    break;

                case 2:
                    if (totalQuantityOfTickets < TicketsContainer.getTimeOneHour()) {
                        if (quantityOfReliefTickets > 0) {
                            for (int i = 0; i < quantityOfReliefTickets; i++) {
                                cart.addTicket(new TimeTicket(true, choose));
                            }
                        }
                        for (int i = 0; i < totalQuantityOfTickets; i++) {
                            cart.addTicket(new TimeTicket(false, choose));
                        }
                        System.out.println("Dodawno do koszyka");
                    } else throw new Exception("Wymagana ilość biletów nie jest dostępna");
                    break;

                case 3:
                    if (totalQuantityOfTickets < TicketsContainer.getTimeOneAndHalfHour()) {
                        if (quantityOfReliefTickets > 0) {
                            for (int i = 0; i < quantityOfReliefTickets; i++) {
                                cart.addTicket(new TimeTicket(true, choose));
                            }
                        }
                        for (int i = 0; i < totalQuantityOfTickets; i++) {
                            cart.addTicket(new TimeTicket(false, choose));
                        }
                        System.out.println("Dodawno do koszyka");
                    } else throw new Exception("Wymagana ilość biletów nie jest dostępna");
                    break;

                case 4:
                    if (totalQuantityOfTickets < TicketsContainer.getTimeTwentyfourHours()) {
                        if (quantityOfReliefTickets > 0) {
                            for (int i = 0; i < quantityOfReliefTickets; i++) {
                                cart.addTicket(new TimeTicket(true, choose));
                            }
                        }
                        for (int i = 0; i < totalQuantityOfTickets; i++) {
                            cart.addTicket(new TimeTicket(false, choose));
                        }
                        System.out.println("Dodawno do koszyka");
                    } else throw new Exception("Wymagana ilość biletów nie jest dostępna");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd systemu - " + e.getMessage() + " skontaktuj się z obsługą techniczną");
        } catch (InputMismatchException e){
            System.out.println("Nie poprawna wartość - spróbuj ponownie");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private int getTotalQuantityFromUser() throws InputMismatchException {
        System.out.println("Podaj ilość");
        Scanner in = new Scanner(System.in);
        int quantity = in.nextInt();

        return quantity;
    }

    private int getQuantityOfReliefTicketsFromUser() throws InputMismatchException {

            System.out.println("Podaj ilość biletów ulgowych");
            Scanner in = new Scanner(System.in);
            int quantityOfRelief = in.nextInt();

            return quantityOfRelief;
    }


    private void displaySingleTickets() {
        System.out.println("Wybrano bilety jednorazowe\n");

        System.out.println("Wybierz 1 aby wybrać " + SingleTicket.TypeOfSingleTicket.NORMAL.getName() + " " + Prices.getSingleNormal() + " zł");
        System.out.println("Wybierz 2 aby wybrać " + SingleTicket.TypeOfSingleTicket.SPECIAL.getName() + " " + Prices.getSingleSpecial() + " zł");

    }

    private void displayTimeTickets() {
        System.out.println("Wybrano bilety czasowe\n");

        System.out.println("Wybierz 1 aby wybrać " + TimeTicket.TypeOfTimeTicket.HALFHOUR.getName() + " " + Prices.getTime30Minutes() + " zł");
        System.out.println("Wybierz 2 aby wybrać " + TimeTicket.TypeOfTimeTicket.HOUR.getName() + " " + Prices.getTime60Minutes() + " zł");
        System.out.println("Wybierz 3 aby wybrać " + TimeTicket.TypeOfTimeTicket.ONEANDHALFHOUR.getName() + " " + Prices.getTime90Minutes() + " zł");
        System.out.println("Wybierz 4 aby wybrać " + TimeTicket.TypeOfTimeTicket.TWENTYFOURHOURS.getName() + " " + Prices.getTime24Hours() + " zł");

    }

    private void displayMenu() {

        System.out.println("wybierz 0 aby wyświetlić koszyk");
        System.out.println("Wybierz 1 aby wybrać bilet czasowy");
        System.out.println("Wybierz 2 aby wybrać bilety jednorazowe");
        System.out.println("Wybierz 3 aby przejść do płatności");
        System.out.println("Wybierz 4 aby zrezygnować z zakupu");

    }

}
