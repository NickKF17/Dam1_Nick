package com.entonos.ejercicios;

public class UtilidadesString {

    public static String compareStrings(String str1, String str2) {
        if (str1.equals(str2)) {
            return "The strings are equal.";
        } else {
            return "The strings are not equal.";
        }
    }

    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    public static boolean isPalindrome(String str) {
        return str.equals(reverseString(str));
    }

    public static boolean isEmpty(String str) {
        return str.isEmpty();
    }

    public static int countCharacters(String str) {
        return str.length();
    }

    public static String[] splitString(String str, char splitChar) {
        return str.split(Character.toString(splitChar));
    }
    
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
    
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }
    
    public static String substituteCharacter(String str, char oldChar, char newChar) {
        return str.replace(oldChar, newChar);
    }

    public static String arrayToString(String[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
