package demo.utils;

public final class PriceValidator {
    private PriceValidator(){}

    private final static String PRICE_RGX = "\\d+\\.\\d+\n";

    public static boolean isPriceValid(Double price){
        return Rounder.round(price).toString().isEmpty() || Rounder.round(price) <= 0.00;
    }
}
