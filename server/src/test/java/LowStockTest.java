import static org.junit.jupiter.api.Assertions.*;
import models.Inventory;
import models.Item;
import org.junit.jupiter.api.Test;
import java.util.List;

// Unit test verifying the low stock items are returned from /low-stock endpoint
public class LowStockTest {

    Inventory inventory;
    @Test
    public void testLowStock() {
        // Send a request to the /low-stock endpoint
        List<Item> lowStockItems = inventory.getItemsUnderPercentCapacity(0.25);

        // Verify that only items with a quantity less than 25% of the capacity are returned
        for (Item item : lowStockItems) {
            assertTrue(item.getStock() < 0.25 * item.getCapacity());
        }
    }
}
