package com.packt.ticketMachine.tickets;

/**
 * Created by Drakles on 16.09.2017.
 */
public class TicketsContainer {

    // I assume the relief is printed on ticket by the machine so we don't have to have 2x more tickets in machine physically

    static int singleNormal = 100;
    static int singleSpecial = 100;

    static int timeHalfHour = 100;
    static int timeOneHour = 100;
    static int timeOneAndHalfHour = 100;
    static int timeTwentyfourHours = 100;

    public static int getSingleNormal() {
        return singleNormal;
    }

    public static void setSingleNormal(int singleNormal) {
        TicketsContainer.singleNormal = singleNormal;
    }

    public static void decreaseSingleNormal() throws Exception {
        if(singleNormal > 1) {
            singleNormal--;
        }else {
            throw new Exception("Niestety brakuje");
        }
    }

    public static int getSingleSpecial() {
        return singleSpecial;
    }

    public static void setSingleSpecial(int singleSpecial) {
        TicketsContainer.singleSpecial = singleSpecial;
    }

    public static void decreaseSingleSpecial() throws Exception {
        if(singleSpecial>1) {
            singleSpecial--;
        }else {
            throw new Exception("Niestety brakuje");
        }
    }

    public static int getTimeHalfHour() {
        return timeHalfHour;
    }

    public static void setTimeHalfHour(int timeHalfHour) {
        TicketsContainer.timeHalfHour = timeHalfHour;
    }

    public static void decreaseTimeHalfHour() throws Exception {
        if(timeHalfHour>1) {
            timeHalfHour--;
        }else {
            throw new Exception("Niestety brakuje");
        }
    }

    public static int getTimeOneHour() {
        return timeOneHour;
    }

    public static void setTimeOneHour(int timeOneHour) {
        TicketsContainer.timeOneHour = timeOneHour;
    }

    public static void decreaseTimeOneHour() throws Exception {
        if(timeOneHour>1) {
            timeOneHour--;
        }else {
            throw new Exception("Niestety brakuje");
        }
    }

    public static int getTimeOneAndHalfHour() {
        return timeOneAndHalfHour;
    }

    public static void setTimeOneAndHalfHour(int timeOneAndHalfHour) {
        TicketsContainer.timeOneAndHalfHour = timeOneAndHalfHour;
    }

    public static void decreaseOneAndHalfHour() throws Exception {
        if(timeOneAndHalfHour>1) {
            timeOneAndHalfHour--;
        }else {
            throw new Exception("Niestety brakuje");
        }
    }

    public static int getTimeTwentyfourHours() {
        return timeTwentyfourHours;
    }

    public static void setTimeTwentyfourHours(int timeTwentyfourHours) {
        TicketsContainer.timeTwentyfourHours = timeTwentyfourHours;
    }

    public static void decreaseTwentyfourHours() throws Exception {
        if(timeTwentyfourHours>1) {
            timeTwentyfourHours--;
        }else {
            throw new Exception("Niestety brakuje ");
        }
    }

}
