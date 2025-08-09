package util;
import org.openqa.selenium.WebElement;

import java.util.Random;
public class Utilty {



    public class RandomDataGenerator {
        private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        private static final Random random = new Random();

        public static String generateRandomString(int minLength, int maxLength) {
            int length = random.nextInt(maxLength - minLength + 1) + minLength;
            StringBuilder sb = new StringBuilder(length);

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(CHARACTERS.length());
                sb.append(CHARACTERS.charAt(index));
            }

            return sb.toString();
        }

        public class CredentialsHolder {
            public static String email;
            public static String password;
        }

        public static int generateRandom(int min , int max ) {
            Random random = new Random();
            return random.nextInt(max) + min;  // nextInt(5) gives 0-4, +1 makes it 1-5
        }





    }

}
