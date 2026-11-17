package ecommerce;

import java.util.Comparator;

public class ProductComparators {

    public static Comparator<Product> byName() {
        return (p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName());
    }

    public static Comparator<Product> byCode() {
        return (p1, p2) -> p1.getCode().compareTo(p2.getCode());
    }

    public static Comparator<Product> byPriceAscending() {
        return (p1, p2) -> p1.getPriceAfterDiscount().compareTo(p2.getPriceAfterDiscount());
    }

    public static Comparator<Product> byPriceDescending() {
        return (p1, p2) -> p2.getPriceAfterDiscount().compareTo(p1.getPriceAfterDiscount());
    }

    public static Comparator<Product> byCategoryAndPrice() {
        return Comparator.comparing(Product::getCategory)
                .thenComparing(Product::getPriceAfterDiscount);
    }

    public static Comparator<Product> byStockQuantity() {
        return (p1, p2) -> Integer.compare(p2.getStockQuantity(), p1.getStockQuantity());
    }

    public static Comparator<Product> byProfit() {
        return (p1, p2) -> p2.calculatePotentialProfit().compareTo(p1.calculatePotentialProfit());
    }

    public static Comparator<Product> byManufacturer() {
        return (p1, p2) -> {
            int result = p1.getManufacturer().compareToIgnoreCase(p2.getManufacturer());
            if (result != 0) return result;
            return p1.getName().compareToIgnoreCase(p2.getName());
        };
    }

    public static Comparator<Product> byRating() {
        return Comparator.comparingDouble(Product::getRating).reversed()
                .thenComparing(Product::getReviewCount, Comparator.reverseOrder());
    }

    public static Comparator<Product> byDaysInStock() {
        return (p1, p2) -> Integer.compare(p2.getDaysInStock(), p1.getDaysInStock());
    }

    public static Comparator<Product> byStatus() {
        return Comparator.comparing(Product::getStatus)
                .thenComparingInt(Product::getStockQuantity);
    }

    public static Comparator<Product> multiCriteria() {
        return Comparator.comparing(Product::getCategory)
                .thenComparing(Product::getRating, Comparator.reverseOrder())
                .thenComparing(Product::getPriceAfterDiscount)
                .thenComparing(p -> p.getName().toLowerCase());
    }
}