package com.indychkov.rutoenpassword;

public class PasswordHelper {
    private final String[] Russians;
    private final String[] Latins;

    public PasswordHelper(String[] russians, String[] latins) {
        if (russians.length != latins.length) {
            throw new IllegalArgumentException();
        }

        Russians = russians;
        Latins = latins;
    }

    public String convert(CharSequence source) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            String key = String.valueOf(Character.toLowerCase(c));

            for (int dict = 0; dict < Russians.length; dict++) {
                if (key.equals(Russians[dict])) {
                    result.append(Character.isUpperCase(c)?
                            Latins[dict].toUpperCase() : Latins[dict]);
                }
            }

            if (result.length() <= i) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public int getQuality(CharSequence password){
        return Math.min(password.length(), 10);
    }
}
