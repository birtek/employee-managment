package pl.szydlowski.springbootcrudapi.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ValidatorPage {
    private  ValidatorPage(){};

    private static final int FIRST_INDEX = 1;

        static int validatePage(String page) {
        if (page == null) {
            return FIRST_INDEX - 1;
        }
        if (isaNumber(page)) {
            int currentPage = Integer.parseInt(page);
            if (currentPage > FIRST_INDEX ) {
                return currentPage - 1;
            }
        }
        return FIRST_INDEX - 1;
    }

    private static boolean isaNumber(String page) {
        String regex = "[+-]?[0-9][0-9]*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(page);
        return matcher.find() && matcher.group().equals(page);
    }
}
