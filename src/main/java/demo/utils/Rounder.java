package demo.utils;

import java.text.DecimalFormat;

public class Rounder {

    public static Double round (Double d){

        return Double.parseDouble(new DecimalFormat("#.##").format(d));
    }
}
