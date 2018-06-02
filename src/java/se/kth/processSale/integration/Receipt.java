package se.kth.processSale.integration;


import se.kth.processSale.model.ChangeDTO;
import se.kth.processSale.model.SaleDTO;
import se.kth.processSale.util.Node;


/**
 * Class responsible for creating a receipt from a sale and sending it to printer
 */
public class Receipt {
    private String receipt;
    private Printer printer;

    /**
     * Create and store receipt from the given saleInformation
     * @param saleInformationDTO Contains information about a completed sale
     * @param printer reference to printer system
     */
    public Receipt(SaleInformationDTO saleInformationDTO, Printer printer){
        this.printer =printer;
        double totalWithoutTaxes = saleInformationDTO.getTaxAndTotal().getTotalWithoutTaxes();
        double totalWithTaxes = saleInformationDTO.getTaxAndTotal().getTotalWithTaxApplied();
        ChangeDTO change = saleInformationDTO.getReturnedChange();
        SaleDTO sale = saleInformationDTO.getFinishedSale();
        Node<ItemDTO> itemList = sale.getItemList();
        receipt= "Receipt\n";
        receipt+="Items: \n";
        if(itemList != null){
            receipt+=itemList.toString();
        }
        receipt+="Total: "+totalWithoutTaxes+"\n";
        receipt+="Tax: "+(totalWithTaxes-totalWithoutTaxes)+"\n";
        receipt+="Total with Tax: "+totalWithTaxes+"\n";
        receipt+="Amount payed: "+change.getAmountPayed()+"\n";
        receipt+="Change returned: "+change.getChange()+" kr\n";




    }

    /**
     * Send the receipt to the printer
     */
    public void sendReceipt(){
        this.printer.printReceipt(new ReceiptDTO(this.receipt));
    }

}
