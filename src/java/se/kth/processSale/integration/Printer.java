package se.kth.processSale.integration;
/** Class that handles printing of receipts */
public class Printer {

    /**
     * Create an instance of the Printer
     */
    public Printer(){

    }

    /**
     * Print the given receipt
     * @param receipt receipt containing information about a sale
     */
    public void printReceipt(ReceiptDTO receipt){

        System.out.print(receipt.getReceipt());

    }
}
