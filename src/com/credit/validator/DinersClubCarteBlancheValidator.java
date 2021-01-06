package com.credit.validator;

import java.util.List;

import static com.credit.utils.CreditCardParser.*;
/*
 * Discover format:
 * length = 14
 * IIN range = 300-305
 */
public class DinersClubCarteBlancheValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public DinersClubCarteBlancheValidator(String creditCardNumber) {
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

        if (creditCardNumberList.size() == 14) {
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
        int[] IINRange = {300, 305};
        int IIN = parseIIN(creditCardNumberList, 3);


        if (!hasAllowedIINRange) {
            for (int i = IINRange[0]; i <= IINRange[1]; i++) {
                if (IIN == i) {
                    hasAllowedIINRange = true;
                    break;
                }
            }
        }



        return hasAllowedIINRange;
    }
}
