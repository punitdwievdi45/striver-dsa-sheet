package script;

import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*";
    private static final SecureRandom secureRandom = new SecureRandom();



    public static String generatePassword() {
        StringBuilder stringBuilder = new StringBuilder();

        // Generate 3 random digits
        for (int i = 0; i < 3; i++) {
            stringBuilder.append(generateRandomCharacter(NUMBERS));
        }

        // Generate 4 random characters
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(generateRandomCharacter(LOWERCASE_LETTERS + UPPERCASE_LETTERS));
        }

        // Generate 1 random special character
        stringBuilder.append(generateRandomCharacter(SPECIAL_CHARACTERS));

        // Shuffle the password characters randomly
        char[] passwordCharacters = stringBuilder.toString().toCharArray();
        for (int i = 0; i < passwordCharacters.length; i++) {
            int randomIndex = secureRandom.nextInt(passwordCharacters.length);
            char temp = passwordCharacters[i];
            passwordCharacters[i] = passwordCharacters[randomIndex];
            passwordCharacters[randomIndex] = temp;
        }

        return new String(passwordCharacters);
    }

    private static String generateRandomCharacter(String characters) {
        int randomIndex = secureRandom.nextInt(characters.length());
        return String.valueOf(characters.charAt(randomIndex));
    }
}
