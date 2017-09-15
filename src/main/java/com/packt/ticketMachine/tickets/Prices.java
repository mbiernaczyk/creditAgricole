package com.packt.ticketMachine.tickets;

/**
 * Created by Drakles on 14.09.2017.
 */
public class Prices {

    static final double time30Minutes = 3;
    static final double time60Minutes = 4.5;
    static final double time90Minutes = 6;
    static final double time24Hours = 11;

    static final double singleNormal = 3;
    static final double singleSpecial = 3.2;

    public static double getTime30Minutes() {return time30Minutes;}

    public static double getTime60Minutes() {
        return time60Minutes;
    }

    public static double getTime90Minutes() {
        return time90Minutes;
    }

    public static double getTime24Hours() {
        return time24Hours;
    }

    public static double getSingleNormal() {
        return singleNormal;
    }

    public static double getSingleSpecial() {
        return singleSpecial;
    }
}
