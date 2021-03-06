package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if(query.toLowerCase().contains("minus")){
            int num = findDifference(query);
            return num+" is the total sum";
        }
        else if(query.toLowerCase().contains("plus")){
            int num = getSum(query);
            return num+" is the total sum";
        }
        else if(query.toLowerCase().contains("largest")){
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

    private int findDifference(String query){
        if (query != null & !query.isEmpty()) {
            try {
                int a =
                        new Integer(query.substring(query.indexOf("is") + 3,
                                query.indexOf("minus")).trim()).intValue();
                int b =
                        new Integer(query.substring(query.indexOf("minus") + 5, query.length()).trim()).intValue();

                return a - b;
            }catch(Exception e){

            }
        }

        return -1;
    }

    private int findLargest(String query) {
        if (query != null & !query.isEmpty()) {
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

    private int getSum(String query){
        if (query != null & !query.isEmpty()) {
            try {
                int a = new Integer(query.substring(query.indexOf("is") + 3, query.indexOf("plus")).trim()).intValue();
                int b = new Integer(query.substring(query.indexOf("plus") + 4, query.length()).trim()).intValue();

                return a + b;
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
//%20what%20colour%20is%20a%20banana
//%20what%20is%2019%20minus%2015"