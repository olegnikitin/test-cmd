package com.mobility;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {

    private static final Pattern UPPER_CASE_PATTERN = Pattern.compile("^([A-Z]+).+$");
    private static final Pattern NUMBER_PATTERN = Pattern.compile(".*\\d.*");

    public App(List<String> inputList) {
        for (String value : inputList) {
            if (isValidLength(value) && isUpperCased(value) && containsNumber(value) && containsSpecialSymbols(value) && notContainsSpaces(value))
                System.out.println("PASS");
            else
                System.out.println("FAIL");
        }
    }

    public static void main(String[] args) {
        new App(Arrays.asList("Am@Z1ng4", "Bob_42#", "Alf", "ABC 7D_"));
    }

    private boolean isValidLength(String value) {
        int size = value.length();
        return size >= 4 && size <= 32;
    }

    private boolean isUpperCased(String value) {
        return UPPER_CASE_PATTERN.matcher(value).matches();
    }

    private boolean containsNumber(String value) {
        return NUMBER_PATTERN.matcher(value).matches();
    }

    private boolean containsSpecialSymbols(String value) {
        return StringUtils.containsAny(value, '@', '#', '_', '-');
    }

    private boolean notContainsSpaces(String value) {
        return !value.contains(" ");
    }
}
