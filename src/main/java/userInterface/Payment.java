package userInterface;

import java.util.Scanner;

/**
 * Created by Drakles on 16.09.2017.
 */
public class Payment {

    Cart cart;

    public void receiveCoin(){

        double cashToPay = cart.calculateSum();
        boolean userNotResigned = true;

        while (cashToPay>=0 && userNotResigned) {

            System.out.println("wrzuć monetę");
            System.out.println("Aby anulować zakup wpisz 0");

            Scanner coinIn = new Scanner(System.in);

            double coinRecived = coinIn.nextDouble();

            if(recognized(coinRecived)){
                cashToPay -= coinRecived;
                if(cashToPay >= 0) {
                    System.out.format("%s %.2f \n", "Pozostało do zapłaty ", cashToPay);
                }
            } else if( coinRecived == 0) {
                userNotResigned = false;
                System.out.println("Zwrot monet - odbierz wrzucone monety");
                cart.removeAllTickets();
            }else {
                notRecognizedCoin();
                System.out.format("%s %.2f \n","Pozostało do zapłaty ",cashToPay);

            }

        }
        cart.printAllTickets();
        if(cashToPay<0){
            giveChangeToUser(cashToPay*-1);
        }
        System.out.println("Dziękujemy za skorzystanie z naszych usług \n");
    }

    private void giveChangeToUser(double cashToChange) {

    }

    private void notRecognizedCoin() {
        System.out.println("Nie rozpoznano monety");
        System.out.println("Pamietaj że automat przyjmuje tylko monety 10 gr 20 gr 50 gr 1 zł 2 zł 5 zł");
        System.out.println("symbolizowane przez liczby: 0,1 0,2 0,5 1 2 5");

        throwAwayReceivedCoin();
    }

    private void throwAwayReceivedCoin() {
        System.out.println("Wrzucona moneta została wyrzucona");
    }

    private boolean recognized(double coinRecived) {
        if(coinRecived == 0.1 || coinRecived == 0.2 || coinRecived == 0.5 || coinRecived == 1 || coinRecived == 2 || coinRecived == 5){
            return true;
        }else return false;
    }

    public Payment(Cart cart) {
        this.cart = cart;
    }
}
