package com.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomHelpers {

    public static String getName(String context) {
        // Define the regex pattern
        Pattern pattern = Pattern.compile("(defined by convention class `)([\\w.]+)");
        Matcher matcher = pattern.matcher(context);

        // Use a StringBuffer for dynamic replacement
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            // Extract the full class path and the last word
            String fullClassPath = matcher.group(2);
            String lastWord = fullClassPath.substring(fullClassPath.lastIndexOf('.') + 1);

            // Replace with "defined by convention class <lastWord>"
            matcher.appendReplacement(result, matcher.group(1) + lastWord);
        }
        matcher.appendTail(result);

        return result.toString();
    }

}
