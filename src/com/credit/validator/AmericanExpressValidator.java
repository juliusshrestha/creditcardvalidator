package com.credit.validator;

import java.util.List;

import static com.credit.utils.CreditCardParser.*;

/*
 * American Express :
 *  IIN range = 34,37
 * length = 15
 *
 */
public class AmericanExpressValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public AmericanExpressValidator(String creditCardNumber) {
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

        if (creditCardNumberList.size() == 15) {
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
        int[] IINRange = {34, 37};
        int IIN = parseIIN(creditCardNumberList, 2);

        if (IIN == IINRange[0] || IIN == IINRange[1] ){
            hasAllowedIINRange = true;
        }


        return hasAllowedIINRange;
    }
}
