
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// E-commerce Cart Simulation
// Concepts: Collections (ArrayList, HashMap), OOP, Polymorphism
// Requirements: Add/remove items, calculate total, apply discount, list cart items.
// Filename: ShoppingCartApp.java


public class ShoppingCartApp {
    private HashMap<String, Product> store = new HashMap<>();
    private HashMap<Product, Float> cart = new HashMap<>();
    private ArrayList<String> prodList =new ArrayList<>();

    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
    }

    private void addProduct(){
        System.out.print("Enter Product Name : ");
        String name = sc.nextLine();
        System.out.printf("Enter %s Price : ",name);
        float price = sc.nextFloat();
        System.out.printf("Enter %s Quantity : ",name);
        int quantity = sc.nextInt();
        Product product = new Product(name, price,quantity);
        store.put(name, product);
        System.out.print("Product added sucessfully.");
    }

    private void buyProduct(){
        System.out.print("Enter Product Number : ");
        int productId = sc.nextInt();
        System.out.printf("Enter %s Quantity : ",name);
        int quantity = sc.nextInt();
        Product p1 = 
    }



}


class Product {
    String productName;
    float productPrice;
    int availableQuantity;
    int buyQuantity = 0;
    int discount;

    public Product(String productName, float price, int availableQuantity) {
        this.productName = productName;
        this.productPrice = price;
        this.availableQuantity = availableQuantity;
    }

    public Product(String productName, float price) {
        this(productName, price, 0);
    }
}