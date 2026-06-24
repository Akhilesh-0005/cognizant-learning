// ============================================================
//  Exercise 2: E-commerce Platform Search Function
//  Algorithms: Linear Search & Binary Search
// ============================================================

// ── Product Class ──
class Product {
    int    productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId   = productId;
        this.productName = productName;
        this.category    = category;
    }

    @Override
    public String toString() {
        return "Product { ID=" + productId +
               ", Name='" + productName +
               "', Category='" + category + "' }";
    }
}

// ── Search Algorithms ──
class SearchAlgorithms {

    // ── Linear Search — O(n) ──
    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == targetId) {
                return i;   // found at index i
            }
        }
        return -1;          // not found
    }

    // ── Binary Search — O(log n) — array must be sorted by productId ──
    public static int binarySearch(Product[] products, int targetId) {
        int low  = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (products[mid].productId == targetId) {
                return mid;
            } else if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;          // not found
    }
}

// ── Test Class ──
public class EcommercePlatformSearch {

    public static void main(String[] args) {
        System.out.println("=== E-commerce Platform Search Function ===\n");

        // ── Unsorted array for Linear Search ──
        Product[] products = {
            new Product(103, "Laptop",      "Electronics"),
            new Product(101, "Smartphone",  "Electronics"),
            new Product(105, "Headphones",  "Accessories"),
            new Product(102, "Desk Chair",  "Furniture"),
            new Product(104, "Coffee Mug",  "Kitchen")
        };

        // ── Sorted array for Binary Search (sorted by productId) ──
        Product[] sortedProducts = {
            new Product(101, "Smartphone",  "Electronics"),
            new Product(102, "Desk Chair",  "Furniture"),
            new Product(103, "Laptop",      "Electronics"),
            new Product(104, "Coffee Mug",  "Kitchen"),
            new Product(105, "Headphones",  "Accessories")
        };

        int searchId = 104;

        // ── Linear Search ──
        System.out.println("--- Linear Search (O(n)) ---");
        long startLinear = System.nanoTime();
        int linearResult = SearchAlgorithms.linearSearch(products, searchId);
        long endLinear   = System.nanoTime();

        if (linearResult != -1) {
            System.out.println("Found   : " + products[linearResult]);
            System.out.println("At Index: " + linearResult);
        } else {
            System.out.println("Product ID " + searchId + " not found.");
        }
        System.out.println("Time    : " + (endLinear - startLinear) + " ns");

        // ── Binary Search ──
        System.out.println("\n--- Binary Search (O(log n)) ---");
        long startBinary = System.nanoTime();
        int binaryResult = SearchAlgorithms.binarySearch(sortedProducts, searchId);
        long endBinary   = System.nanoTime();

        if (binaryResult != -1) {
            System.out.println("Found   : " + sortedProducts[binaryResult]);
            System.out.println("At Index: " + binaryResult);
        } else {
            System.out.println("Product ID " + searchId + " not found.");
        }
        System.out.println("Time    : " + (endBinary - startBinary) + " ns");

        // ── Analysis ──
        System.out.println("\n--- Time Complexity Analysis ---");
        System.out.println("Linear Search : Best O(1) | Average O(n) | Worst O(n)");
        System.out.println("Binary Search : Best O(1) | Average O(log n) | Worst O(log n)");
        System.out.println("\nConclusion: Binary Search is faster for large sorted datasets.");
        System.out.println("            Linear Search works on unsorted data.");
    }
}
