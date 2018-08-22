package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        try {
            if (b == 0) {
                throw new ArithmeticException();
            }
        }
            catch (Exception e) {
                System.out.println("you cannot divide by zero, Error: " + e);
            }

            finally {
            System.out.println("you tried to divide, here is what you got: ");}
        return a / b;


    }



    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        double result = firstChallenge.divide(3, 0);

        System.out.println(result);

    }
}