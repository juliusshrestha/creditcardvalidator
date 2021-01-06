package com.credit;
import com.credit.utils.TypeChecker;
import com.credit.validator.Validator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        /* Reads card numbers from credit.txt file
         * and stored in an Array CreditCardNumbers
         */
        Path filePath = Paths.get("src/com/credit/credit.txt");
        Scanner scanner = new Scanner(filePath);
        ArrayList<String> CreditCardNumbers = new ArrayList<>();
        while (scanner.hasNext()) {
            CreditCardNumbers.add(scanner.next());
        }

        // Store length of the array
        int count = CreditCardNumbers.toArray().length;

        // Filepath to store valid and invalid card separately
        File file1= new File("valid_cards.txt");
        File file2= new File("invalid_numbers.txt");
        FileWriter fw1 = new FileWriter(file1);
        FileWriter fw2 = new FileWriter(file2);
        PrintWriter pw1 = new PrintWriter(fw1);
        PrintWriter pw2 = new PrintWriter(fw2);

        /*
         * If the card is valid by Luhn Algorithm then it is stored in valid_cards.txt file
         * otherwise the card is stored in invalid_numbers.txt file
         */
        for (int i=0; i<count;i++){

            Validator v = new Validator(CreditCardNumbers.get(i));
            boolean validity= v.validate();
            if(validity){
                pw1.println("Card No.: "+ CreditCardNumbers.get(i) + "    " + " Issued By: "+TypeChecker.checkType(CreditCardNumbers.get(i)));
            }
            else {
                pw2.println("Card No.: "+ CreditCardNumbers.get(i));
            }
        }
        // stopping write operation
        pw1.close();
        pw2.close();
    }
}
