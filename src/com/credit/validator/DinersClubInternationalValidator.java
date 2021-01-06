package com.credit.validator;

import java.util.List;

import static com.credit.utils.CreditCardParser.*;
/*
 * Diners Club International format:
 * length = 14
 * IIN range = 36
 */
public class DinersClubInternationalValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public DinersClubInternationalValidator(String creditCardNumber) {
        creditCardNumberList = parseNumber(creditCardNumber);
    }

    /*
     * Check the length of the card against the format
     * requirement.
     *
     * @return boolean of whether or not credit card
     * number meet requirement.
     */
    @Override
    boolean checkLength() {
        boolean hasAllowedLength = false;

        if (creditCardNumberList.size() >= 14) {
            hasAllowedLength = true;
        }

        return hasAllowedLength;
    }

    /*
     * Check that IIN meets IIN range requirement
     *
     * @return boolean of whether or not IIN matches
     * requirement
     */
    @Override
    boolean checkIINRanges() {
        boolean hasAllowedIINRange = false;
        int[] IINRange = {36};
        int IIN = parseIIN(creditCardNumberList, 2);int firstThree = parseIIN(creditCardNumberList, 3);


        if (!hasAllowedIINRange) {
            if (IIN == IINRange[0]) {
                hasAllowedIINRange = true;
            }
        }



        return hasAllowedIINRange;
    }
}
