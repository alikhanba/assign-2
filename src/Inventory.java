import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Inventory {
    private String location;
    private int totalCapacity;
    private List<Product> products;

    public Inventory(String location, int totalCapacity) {
        this.location = location;
        this.totalCapacity = totalCapacity;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        if(products.size()<totalCapacity){
            products.add(product);
        }
        else{
            System.out.println("Invetory is full");
        }
    }

    public void searchbyName(String name){
        System.out.println("searching for: "+name);
        for(Product product:products){
            if(product.getName().equalsIgnoreCase(name)){
                System.out.println(product);
                return;
            }
        }
    }

    public void filterLowStock(int threshold){
        System.out.println("filtering low stock");
        for(Product product:products){
            if(product.getQuantity()<threshold){
                System.out.println(product);
            }
        }
    }

    public void sortByPrice(){
        products.sort(Comparator.comparingDouble(Product::getPrice));
        System.out.println("Sorted by price");
        displayAll();
    }

    public void displayAll(){
        System.out.println("Inventory at location: "+location);
        for(Product product:products){
            System.out.println(product);
        }
    }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getTotalCapacity() { return totalCapacity; }
    public void setTotalCapacity(int totalCapacity) { this.totalCapacity = totalCapacity; }

    @Override
    public String toString() {
        return "Inventory{location='" + location + "', capacity=" + totalCapacity + "}";
    }
}