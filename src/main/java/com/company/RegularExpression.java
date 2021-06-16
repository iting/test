package com.company;

public class RegularExpression {

    public RegularExpression() {

    }

    // . -> match any char
    // * -> match 0 or more
    // + -> match one or more
    public boolean isMatch(String source, String pattern) {
        if(pattern.isEmpty()) {
            return source.isEmpty();
        }
        boolean isFirstMatch = source.length()>=1 && (source.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');

        // .*
        if(pattern.length()>=2 && pattern.charAt(1) == '*') {
            boolean useIt = isFirstMatch && isMatch(source.substring(1), pattern);
            boolean notUseIt = isMatch(source, pattern.substring(2));
            return useIt || notUseIt;
        } else if(pattern.length()>=2 && pattern.charAt(1) == '+') {
            // one or more
            if(!isFirstMatch) {
                return false;
            }
            // why here?
            return isFirstMatch &&
                    (isMatch(source.substring(1), pattern.substring(2)) || isMatch(source.substring(1), pattern));
        }

        return isFirstMatch && isMatch(source.substring(1), pattern.substring(1));
    }
}
