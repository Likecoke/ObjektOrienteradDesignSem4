package se.kth.processSale.integration;

/**
 * Data transfer object that stores the receipt of a sale
 */
public class ReceiptDTO {
    private  String receipt;

    /**
     * Create an instance of ReceiptDTO storing the given receipt
     * @param receipt Represents the receipt of a sale
     */
    public ReceiptDTO(String receipt){
        this.receipt = receipt;

    }

    /**
     *
     * @return the receipt of the sale
     */
    public String getReceipt() {
        return receipt;
    }
}
