package com.credit.validator;

import java.util.List;

import static com.credit.utils.CreditCardParser.*;
/*
 * Discover format:
 * length = 16 - 19
 * IIN range = 6304, 6706, 6771, 6709
 */
public class LaserValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public LaserValidator(String creditCardNumber) {
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

        if (creditCardNumberList.size() >= 16 && creditCardNumberList.size() <= 19) {

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
        int[] IINRange = {6304, 6706, 6771, 6709};

        int IIN = parseIIN(creditCardNumberList, 4);


        if (IIN == IINRange[0] || IIN == IINRange[1] ||IIN == IINRange[2] || IIN == IINRange[3] ) {
            hasAllowedIINRange = true;
        }



        return hasAllowedIINRange;
    }
}
