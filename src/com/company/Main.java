package com.company;

public class Main {

    public static void main(String[] args) {
	    /*Tests
        System.out.println(isQuestionMarks("aa6?9"));
        System.out.println("arrb6???4xxbl5???eee5");
        System.out.println("acc?7??sss?3rr1??????5");
        System.out.println("5??aaaaaaaaaaaaaaaaaaa?5?5");
        System.out.println("9???1???9???1???9");
        */
    }

    //Method 1: Finds pairs of numbers and determines if they are equal to 10. Uses helper method to check for question marks
    public static boolean isQuestionMarks(String testString){

        int digit1 = 0, digit2 = 0;
        int placeFound1 = -1, placeFound2 = -1;

        boolean pairsTrue = false;

        for (int i = 0; i < testString.length(); i++) {

            //Iterating through String until two numbers are found
            //Recording the place in the string each number is found

            if (placeFound1 == -1 && Character.isDigit(testString.charAt(i))) {
                placeFound1 = i;
                digit1 = Character.getNumericValue(testString.charAt(i));
                System.out.println("digit1 = " + digit1);
                if( i != testString.length() -1){
                    continue;
                }

            }

            if (Character.isDigit(testString.charAt(i))) {
                placeFound2 = i;
                digit2 = Character.getNumericValue(testString.charAt(i));
                System.out.println("digit2 = " + digit2);
            }


            if (digit1 != -1 && digit2 != -1) {
                //Add up numbers and check if they are equal to 10
                //If so get the substring of those places

                if (digit1 + digit2 == 10) {
                    if (threeQuestionMarks(testString.substring(placeFound1, placeFound2))) {
                        //This remembers the location of the last number found by digit2 becoming digit1 and
                        //can then be compared to the next number found
                        //This is required to work with multiple pairs of numbers
                        digit1 = digit2;
                        placeFound1 = placeFound2;

                        //Checks if a pair is true. This allows us to exit the method later before returning false
                        //As far as I know, I don't need to keep track of every pairs result. As a single failure will exit the method
                        pairsTrue = true;
                        continue;
                    } else {
                        return false;
                    }
                }
            }else{
                continue;
            }


        }
        System.out.println("End Is Question Marks method");
        System.out.println();
        System.out.println("digit1 = " + digit1);
        System.out.println("digit2 = " + digit2);

        if(pairsTrue){
            return true;
        }

        return false;

    }



    //Method 2: Helper method that determines if there are exactly three question marks in a string

    public static boolean threeQuestionMarks(String string){
        int totalMarks = 0;

        System.out.println("Testing question marks.");

    //Iterate through the substring, check question marks
        for(int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '?'){
                totalMarks++;
            }
        }

        //Return false if there was not three question marks

        if(totalMarks == 3){
            System.out.println("Question marks true");
            return true;

        }else{
            System.out.println("Question marks false");
            return false;

        }

    }


}
