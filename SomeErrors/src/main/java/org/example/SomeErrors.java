import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class SomeErrors {

    public static void main(String[] args) {

        boolean control = true;

        String[] products = {null, null, null};
        int[] prices = {0, 0, 0};

        while (control) {
            System.out.println();
            System.out.println("1. Add a product with a price");
            System.out.println("2. Show products");
            System.out.println("3. Remove product");
            System.out.println("4. Search product");
            System.out.println("5. Show most expensive/cheapest product");
            System.out.println("6. Show total price");
            System.out.println("7. Show average price");
            System.out.println("8. Empty list");
            System.out.println("9. Terminate");

            Scanner input = new Scanner(System.in);
            System.out.print("\nMake a selection:");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addProduct(products, prices);
                    break;
                case 2:
                    seeProducts(products, prices);
                    break;
                case 3:
                    removeProduct(products, prices);
                    break;
                case 4:
                    searchProduct(products, prices);
                    break;
                case 5:
                    expensiveCheapProduct(products, prices);
                    break;
                case 6:
                    totalCostProduct(products, prices);
                    break;
                case 7:
                    averagePriceProduct(products, prices);
                    break;
                case 8:
                    emptyList(products, prices);
                    break;
                case 9:
                    control = false;
                    break;
                default:
                    System.out.println("Incorrect selection");
            }
        }
    }

    public static void addProduct(String[] products, int[] prices) {

        Scanner input = new Scanner(System.in);

        int emptyIndex = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                emptyIndex = i;
                break;
            }
        }
        if (emptyIndex == -1) {
            System.out.println("Your list is full! Please remove a product to be able to add another product!");
            return;
        }

        System.out.println("Enter a product");
        String product = input.nextLine();
        products[emptyIndex] = product;

        System.out.println("Enter price");
        int price = input.nextInt();
        prices[emptyIndex++] = price;

    }

    public static void seeProducts(String[] products, int[] prices) {

        for (int i = 0; i < products.length; i++) {
            // do not try to print products that are null
            if (products[i] == null){
                continue;
            }
            System.out.print("\nProduct: " + products[i]);
            System.out.println("\nPrice: " + prices[i]);
        }

    }

    public static void removeProduct(String[] products, int[] prices) {
        Scanner input = new Scanner(System.in);

        System.out.println("Which product do you want to remove?");
        String product = input.nextLine();
        for (int i = 0; i < products.length; i++){
            if (products[i] != null && product.equals(products[i])){
                products[i] = null;
                prices[i] = 0;
            }
        }

    }

    public static void searchProduct(String[] products, int[] prices) {
        Scanner input = new Scanner(System.in);

        System.out.println("Which product do you want to search?");
        String product = input.nextLine();

        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && product.equals(products[i])) {
                System.out.print("\nProduct: " + products[i]);
                System.out.println("\nPrice: " + prices[i]);
            }
        }
    }

    public static void expensiveCheapProduct(String[] products, int[] prices) {
        int indexExpensive = 0;
        int indexCheapest = 0;
        int numberOfProducts = 0;
        for (int i = 0; i < prices.length; i++) {
            if (products[i] == null){
                continue;
            }
            numberOfProducts++;
            if (prices[i] > prices[indexExpensive]) {
                indexExpensive = i;
            }
            if (prices[i] < prices[indexCheapest]) {
                indexCheapest = i;
            }
        }

        if (numberOfProducts == 0){
            return;
        }
        System.out.println("Most expensive product");
        System.out.println("product " + products[indexExpensive]);
        System.out.println("price " + prices[indexExpensive] + "\n");

        System.out.println("Cheapest product:");
        System.out.println("product " + products[indexCheapest]);
        System.out.println("price " + prices[indexCheapest] + "\n");
    }


    public static void totalCostProduct(String[] products, int[] prices) {
        int totalCost = 0;
        for (int i = 0; i < products.length; i++) {
            totalCost += prices[i];
        }

        System.out.println("Total price for all products " + totalCost);

    }

    public static void averagePriceProduct(String[] products, int[] prices) {
        double totalCost = 0;
        int numberOfProducts = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null){
                numberOfProducts++;
                totalCost += prices[i];
            }
        }
        if (numberOfProducts>0){
            System.out.printf("Average price for all products %.2f%n" , (totalCost / numberOfProducts));
        }
    }

    public static void emptyList(String[] products, int[] prices) {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
            prices[i] = 0;
        }

        System.out.println("The list is empty");
    }

}
