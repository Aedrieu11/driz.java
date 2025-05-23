import java.util.*;
import java.text.*;

public class aedrieusupermarket {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#,##0.00");

        String storeName = "ABC Supermarket";
        String productName = "";
        double unitPrice = 0.0;
        int quantity = 0;
        double cost = 0.0;
        double totalCost = 0.0;
        int totalQuantity = 0;
        String continueBuying = "";
        int discountType = 0;
        String discountName = "";
        double discountPercent = 0.0;
        double discountAmount = 0.0;
        double vat = 0.0;
        double totalWithVat = 0.0;
        double lessVat = 0.0;
        double amountDue = 0.0;
        double payment = 0.0;
        double change = 0.0;

        ArrayList<String> productNames = new ArrayList<>();
        ArrayList<Double> productPrices = new ArrayList<>();
        ArrayList<Integer> productQuantities = new ArrayList<>();
        ArrayList<Double> productCosts = new ArrayList<>(); 

        do {
            System.out.print("Enter Product Name: ");
            productName = sc.nextLine();

            System.out.print("Enter Unit Price: ");
            String strUnitPrice = sc.nextLine();
            unitPrice = Double.parseDouble(strUnitPrice);

            System.out.print("Enter Quantity: ");
            String strQuantity = sc.nextLine();
            quantity = Integer.parseInt(strQuantity);

            cost = unitPrice * quantity;

            totalCost += cost;

            totalQuantity += quantity;

            productNames.add(productName);
            productPrices.add(unitPrice);
            productQuantities.add(quantity);
            productCosts.add(cost);

            System.out.print("Continue buying? Yes/No: ");
            continueBuying = sc.nextLine();

        } while (continueBuying.equalsIgnoreCase("Yes"));

        System.out.println("\nSelect Type of Discount:");
        System.out.println("1 - None");
        System.out.println("2 - Senior Citizen (20%)");
        System.out.println("3 - Suki Card (10%)");
        System.out.println("4 - PWD (15%)");
        System.out.print("Enter choice (1-4): ");
        String strDiscountType = sc.nextLine();
        discountType = Integer.parseInt(strDiscountType);

        switch (discountType) {
            case 1:
                discountPercent = 0.0;
                discountName = "None";
                break;
            case 2:
                discountPercent = 0.20;
                discountName = "Senior Citizen";
                break;
            case 3:
                discountPercent = 0.10;
                discountName = "Suki";
                break;
            case 4:
                discountPercent = 0.15;
                discountName = "PWD";
                break;
            default:
                discountPercent = 0.0;
                discountName = "None";
        }

        vat = totalCost * 0.12;

        totalWithVat = totalCost + vat;

        lessVat = totalCost - vat;

        discountAmount = totalWithVat * discountPercent;

        amountDue = totalWithVat - discountAmount;

        do {
            System.out.println("\nAmount Due: " + df.format(amountDue));
            System.out.print("Enter Payment: ");
            String strPayment = sc.nextLine();
            payment = Double.parseDouble(strPayment);

            if (payment < amountDue) {
                System.out.println("Payment is insufficient. Please enter a higher amount.");
            }

        } while (payment < amountDue);

        change = payment - amountDue;

        System.out.println("\n" + storeName);
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-20s %-15s %-10s %-15s\n", "Product Name", "Unit Price", "Quantity", "Cost");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < productNames.size(); i++) {
            System.out.printf("%-20s %-15s %-10d %-15s\n", 
                    productNames.get(i), 
                    df.format(productPrices.get(i)), 
                    productQuantities.get(i), 
                    df.format(productCosts.get(i)));
        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("%-40s %d\n", "Products Bought:", totalQuantity);
        System.out.printf("%-40s %s\n", "12% VAT:", df.format(vat));
        System.out.printf("%-40s %s\n", "Less Vat:", df.format(lessVat));
        System.out.printf("%-40s %s\n", "Discount Type:", discountName);
        System.out.printf("%-40s %s\n", "Discount Amount:", df.format(discountAmount));
        System.out.printf("%-40s %s\n", "Amount Due:", df.format(amountDue));
        System.out.printf("%-40s %s\n", "Amount Paid:", df.format(payment));
        System.out.printf("%-40s %s\n", "Change:", df.format(change));
    }
}
