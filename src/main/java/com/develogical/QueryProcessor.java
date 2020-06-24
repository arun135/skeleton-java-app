package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if(query.toLowerCase().contains("largest")){
            int num = findLargest(query);
            return num+" is the largest number";
        }
        else if (query.toLowerCase().contains("romeo and juliet")) {
            return "William Shakespeare";
        }
        else if (query.toLowerCase().contains("what is your name")) {
            return "Arunkumr Shivanna";
        }
        return "Not Found";
    }

    private int findLargest(String query) {
        if (query != null & query.isEmpty()) {
            try {
                int a = new Integer(query.substring(query.indexOf(":") + 1, query.indexOf(",")).trim()).intValue();
                int b = new Integer(query.substring(query.indexOf(",") + 1, query.length()).trim()).intValue();

                if(a>b)
                    return a;
                else return b;
            }catch(Exception e){

            }
        }
        return -1;
    }
}


//q=27b4d540: which of the following numbers is the largest: 340, 76
//        q=2ac72710: what is 4 plus 13"
//        q=2de2b540: which of the following numbers is the largest: 85, 792"
//        q=3110d8a0: what is 0 plus 12"
//        q=344c6750: what is 7 plus 9"