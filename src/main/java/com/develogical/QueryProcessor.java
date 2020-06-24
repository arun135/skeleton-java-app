package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("what is your name")) {
            return "Arunkumr Shivanna";
        }
        return "Not Found";
    }
}
