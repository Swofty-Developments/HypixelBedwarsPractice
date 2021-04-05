package net.swofty.hypixelbedwarspractice.Utils;

import java.util.Random;

public class API {

    public static String scolorize(String input) {
        return input.replace("&", "§");
    }

    public String colorize(String input) {
        return input.replace("&", "§");
    }

    public static String getAlphaNumericString(int n)
    {
        int lowerLimit = 97;

        int upperLimit = 122;

        Random random = new Random();

        StringBuffer r = new StringBuffer(n);

        for (int i = 0; i < n; i++) {

            int nextRandomChar = lowerLimit
                    + (int)(random.nextFloat()
                    * (upperLimit - lowerLimit + 1));
            r.append((char)nextRandomChar);
        }

        return r.toString();
    }
}
