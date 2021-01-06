package com.credit.utils;

import com.credit.CreditCardType;
import com.credit.validator.*;

/*
 * Type checker checking credit card types: VISA, AMERICAN EXPXRESS,
 * DISCOVER  MASTERCARD, ...
 */
public class TypeChecker {
    /*
     * @param a String representation of the credit card number
     * @return CreditCardType enumerable
     */
    public static CreditCardType checkType(String creditCardNumber) {
        CreditCardType type = null;

        // Instantiate credit card validators and set type on match
        while (type == null) {
            boolean isThisType;

            VisaValidator visaValidator = new VisaValidator(creditCardNumber);
            isThisType = visaValidator.validate();

            if (isThisType) {
                type = CreditCardType.VISA;
                break;
            }

            AmericanExpressValidator americanExpressValidator = new AmericanExpressValidator(creditCardNumber);
            isThisType = americanExpressValidator.validate();

            if (isThisType) {
                type = CreditCardType.AMERICAN_EXPRESS;
                break;
            }

            MasterCardValidator masterCardValidator = new MasterCardValidator(creditCardNumber);
            isThisType = masterCardValidator.validate();

            if (isThisType) {
                type = CreditCardType.MASTERCARD;
                break;
            }

            DiscoverValidator discoverValidator = new DiscoverValidator(creditCardNumber);
            isThisType = discoverValidator.validate();

            if (isThisType) {
                type = CreditCardType.DISCOVER;
                break;
            }

            VisaElectronValidator visaElectronValidator = new VisaElectronValidator(creditCardNumber);
            isThisType = visaElectronValidator.validate();

            if (isThisType) {
                type = CreditCardType.VISA_ELECTRON;
                break;
            }

            MaestroValidator maestroValidator = new MaestroValidator(creditCardNumber);
            isThisType = maestroValidator.validate();

            if (isThisType) {
                type = CreditCardType.MAESTRO;
                break;
            }

            JCBValidator jcbValidator = new JCBValidator(creditCardNumber);
            isThisType = jcbValidator.validate();

            if (isThisType) {
                type = CreditCardType.JCB;
                break;
            }

            DinersClubInternationalValidator dinersClubInternationalValidator = new DinersClubInternationalValidator(creditCardNumber);
            isThisType = dinersClubInternationalValidator.validate();

            if (isThisType) {
                type = CreditCardType.DINERS_CLUB_INTERNATIONAL;
                break;
            }

            DinersClubCarteBlancheValidator dinersClubCarteBlancheValidator = new DinersClubCarteBlancheValidator(creditCardNumber);
            isThisType = dinersClubCarteBlancheValidator.validate();

            if (isThisType) {
                type = CreditCardType.DINNERS_CLUB_CARTE_BLANCHE;
                break;
            }

            DinersClubValidatorUSAandCanada dinersClubValidatorUSAandCanada = new DinersClubValidatorUSAandCanada(creditCardNumber);
            isThisType = dinersClubValidatorUSAandCanada.validate();

            if (isThisType) {
                type = CreditCardType.DINERS_CLUB_USA_AND_CANADA;
                break;
            }

            InstaPaymenttValidator instaPaymenttValidator = new InstaPaymenttValidator(creditCardNumber);
            isThisType = instaPaymenttValidator.validate();

            if (isThisType) {
                type = CreditCardType.INSTAPAYMENT;
                break;
            }

            LaserValidator laserValidator = new LaserValidator(creditCardNumber);
            isThisType = laserValidator.validate();

            if (isThisType) {
                type = CreditCardType.LASER;
                break;
            }

            // If credit card type does not match, mark as "other"
            if (type == null) {
                type = CreditCardType.UNKNOWN;
                break;
            }

        }

        return type;
    }
}
