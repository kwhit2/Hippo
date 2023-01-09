import static org.junit.jupiter.api.Assertions.*;

import models.Distributor;
import models.Inventory;
import models.Item;
import org.junit.jupiter.api.Test;
import java.util.List;

// Acceptance tests based on Randy's requirements
public class RandyRequirementsTest {

    Inventory inventory;
    Distributor distributorA;
    Distributor distributorB;
    @Test
    public void testRandyRequirements() {
        // Verify that the application displays items that are almost out of stock
        List<Item> lowStockItems = Inventory.getItemsUnderPercentCapacity(0.25);
        assertTrue(lowStockItems.size() > 0);

        // Verify that the user can input the quantity of items to re-order
        submitSetRestockCost(lowStockItems.get(0), 10);
        int savedQuantity = getQuantityFromDatabase(lowStockItems.get(0));
        assertEquals(10, savedQuantity);

        // Verify that the application determines the lowest total cost of re-ordering items
        double costFromSupplierA = distributorA.getCheapestCost(lowStockItems.toString());
        double costFromSupplierB = distributorB.getCheapestCost(lowStockItems.toString());
        double lowestCost = Math.min(costFromSupplierA, costFromSupplierB);
        assertEquals(lowestCost, getLowestCost(lowStockItems));
    }
}
