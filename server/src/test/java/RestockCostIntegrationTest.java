import static org.junit.jupiter.api.Assertions.*;
import models.Inventory;
import models.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// Integration test to verify front end accepts form submission with items to restock
public class RestockCostIntegrationTest {

    Inventory inventory;
    @Test
    public void testRestockCost() {
        // Set up the items and quantities to restock
        List<Item> itemsToRestock = new ArrayList<>();
        itemsToRestock.add(new Item("SKU1", 1, 10, 100));
        itemsToRestock.add(new Item("SKU2", 2, 20, 200));
        itemsToRestock.add(new Item("SKU3", 3, 30, 300));
        itemsToRestock.add(new Item("SKU4", 4, 40, 400));

        // Submit the form with the items and quantities to restock
        submitSetRestockCost();
    }
}
