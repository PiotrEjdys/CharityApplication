package pl.coderslab.charity.model;

import java.util.Random;

public class RandomToken {
    public static String generateRandom() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // first not 0 digit
        sb.append(random.nextInt(9) + 1);

        // rest of 11 digits
        for (int i = 0; i < 11; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}
