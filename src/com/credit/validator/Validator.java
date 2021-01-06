package com.credit.validator;


/*
 * Validator used to consume credit card number

 */
public class Validator {
    private String creditCardNumber;

    /*
     * @param String representation of credit card number
     */
    public Validator(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }


    /*
     * Validate credit card number using Luhn algorithm
     * @throws InvalidCardException if card does not pass
     * test.
     */
    public boolean validate() {
        LuhnValidator luhnValidator = new LuhnValidator();
        boolean isValid = luhnValidator.validate(creditCardNumber);


        return isValid;
    }


}