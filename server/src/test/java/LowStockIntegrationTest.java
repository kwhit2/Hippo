import static org.junit.jupiter.api.Assertions.*;
import models.Inventory;
import models.Item;
import org.junit.jupiter.api.Test;
import java.util.List;

// Integration test to verify front end displays low stock items correctly
public class LowStockIntegrationTest {

    Inventory inventory;
    @Test
    public void testLowStockIntegration() {
        // Send a request to the /low-stock endpoint
        List<Item> lowStockItems = inventory.getItemsUnderPercentCapacity(0.25);

        // Verify that the frontend correctly displays the low-stock items
        assertEquals(lowStockItems, getDisplayedLowStockItems());
    }
}
