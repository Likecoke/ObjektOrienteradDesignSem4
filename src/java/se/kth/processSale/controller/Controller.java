package se.kth.processSale.controller;

import se.kth.processSale.integration.*;
import se.kth.processSale.model.*;

/**
 * The controller class of the application
 */
public class Controller {
    private AccountingSystem accountingSystem;
    private InventorySystem invSystem;
    private ProductCatalogue productCatalogue;
    private ChangeCalculator changeCalc;
    CalculateTotalWithTax totalWithTax;
    private Printer printer;
    private Sale currentSale;
    private Receipt receipt;

    /**
     * Create a new instance of the Controller
     * @param accountingSystem represents an external accounting system
     * @param invSystem represents an external inventory system
     * @param productCatalogue Contains information about available items
     * @param printer Handles printing
     */
    public Controller(AccountingSystem accountingSystem, InventorySystem invSystem, ProductCatalogue productCatalogue,
                      Printer printer){
        this.accountingSystem = accountingSystem;
        this.invSystem = invSystem;
        this.productCatalogue = productCatalogue;
        this.printer = printer;

    }

    /**
     * Begins a new sale
     */
    public void beginSale(){
        this.currentSale = new Sale();

    }

    /**
     * Search for an item with the given identifier
     * @param identifier String that uniquely identifies the item
     * @return Information about the sale so far
     */
    public SaleDTO searchItem(String identifier){
        ItemDTO item = productCatalogue.searchItem(identifier);
        if(item == null){
            return currentSale.saleStatus();
        }
        else {
            currentSale.addItem(item);
            return currentSale.saleStatus();
        }

    }

    /**
     * Indicates that all items have been registered
     * @return Information about the total with and without tax of the sale
     */
    public TaxTotalDTO allItemsRegistered(){
        totalWithTax = new CalculateTotalWithTax(currentSale.saleStatus());
        //SaleDTO sale = currentSale.saleStatus();
        //sale.getItemList().copyList().printList();
        return  totalWithTax.getTotalWithTax();

    }

    /**
     * Enter payment amount and get back information about the change
     * @param payedAmount The amount payed by the customer
     * @return Information about the change given to the customer
     */
    public ChangeDTO enterPayment( double payedAmount){
        changeCalc = new ChangeCalculator(payedAmount, totalWithTax.getTotalWithTax());
        ChangeDTO change = changeCalc.getChange();
        SaleInformationDTO saleInformationDTO = new SaleInformationDTO(currentSale.saleStatus(), totalWithTax.getTotalWithTax(), change);
        invSystem.sendSaleInformation(saleInformationDTO);
        accountingSystem.sendSaleInformation(saleInformationDTO);
        receipt = new Receipt(saleInformationDTO, this.printer);
        receipt.sendReceipt();
        return change;
    }





}
