package com.credit.validator;

import java.util.List;

import static com.credit.utils.CreditCardParser.*;
/*
 * Maestro format:
 * length = 16 - 19
 * IIN range = 5018, 5020, 5038, 5893, 6304, 6759 - 6763
 */
public class MaestroValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public MaestroValidator(String creditCardNumber) {
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
        int[] IINRange = {5018, 5020, 5038, 5893, 6304, 6759 ,6763};
        int IIN = parseIIN(creditCardNumberList, 4);


            if (IIN == IINRange[0] ||IIN == IINRange[1] || IIN == IINRange[2] || IIN == IINRange[3] || IIN == IINRange[4] ) {
                hasAllowedIINRange = true;

            }




        if (!hasAllowedIINRange) {
            for (int i = IINRange[5]; i <= IINRange[6]; i++) {
                if (IIN == i) {
                    hasAllowedIINRange = true;
                    break;
                }
            }
        }

        return hasAllowedIINRange;
    }
}
