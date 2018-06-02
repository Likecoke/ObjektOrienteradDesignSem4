package se.kth.processSale.integration;




public class ProductCatalogueTest {
    ProductCatalogue productCatalogue;
    @Before
    public void setUp() throws Exception {
        productCatalogue = new ProductCatalogue();
    }

    @After
    public void tearDown() throws Exception {
        productCatalogue = null;


    }

    @Test
    public void searchItemNotInCatalogue() throws Exception {
        String searchString = null;
        //String searchString = "abc1000";
        ItemDTO foundItem = productCatalogue.searchItem(searchString);
        boolean result = foundItem == null;
        boolean expectedResult = true;
        assertEquals("Inncorrect identifier returned item in catalogue", result, expectedResult);

    }
    @Test
    public void searchItemThatExistsInCatalogue() throws Exception {
        String searchString = "abc1000";
        ItemDTO foundItem = productCatalogue.searchItem(searchString);
        if(foundItem == null){
            fail("Item that exists in catalogue wasn't found by search");
        }
        else{
            boolean result = foundItem.getIdentifier().equals(searchString);
            boolean expectedResult = true;
            assertEquals("Search returned incorrect Item", result, expectedResult);
        }


    }

}