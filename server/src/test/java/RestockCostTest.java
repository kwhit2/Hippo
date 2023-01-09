import static org.junit.jupiter.api.Assertions.*;

import models.Distributors;
import models.Distributor;
import models.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// Unit test verifying the restock cost is calculated correctly from /restock-cost endpoint
public class RestockCostTest {

    Distributors distributors;

    Distributor distributor;
    @Test
    public void testRestockCost() {
        // Set up the items and quantities to restock
        List<Item> itemsToRestock = new ArrayList<>();
        itemsToRestock.add(new Item("SKU1", 1, 10, 100));
        itemsToRestock.add(new Item("SKU2", 2, 20, 200));
        itemsToRestock.add(new Item("SKU3", 3, 30, 300));
        itemsToRestock.add(new Item("SKU4", 4, 40, 400));

        // Send a request to the /restock-cost endpoint
        double cost = distributors.getRestockCost(itemsToRestock.toString());

        // Verify that the lowest total cost is calculated correctly
        double expectedCost = 0;
        for (Item item : itemsToRestock) {
            double lowestPrice = distributor.getCheapestCost(item.getName());
            expectedCost += lowestPrice * item.getStock();
        }
        assertEquals(expectedCost, cost, 0.01);
    }
}
