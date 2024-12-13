package inventory;
public class Product {
private int itemNumber; 
private String name; 
private int qtyInStock; 
private double price; 
private boolean active = true; 
public Product()
{
}
public Product(int number, String name, int qty, double price)
{
this.itemNumber = number;
this.name = name;
this.qtyInStock = qty;
this.price = price;
}
public void addToInventory(int quantity)
{
if(this.active)
this.qtyInStock += quantity;
else
System.out.println("Não é possível adicionar estoque a uma linha descontinuada!");

}
public void deductFromInventory(int quantity)
{
this.qtyInStock -= quantity;
}
public int getItemNumber() {
return itemNumber;
}

public void setItemNumber(int itemNumber) {
this.itemNumber = itemNumber;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public int getQtyInStock() {
return qtyInStock;
}
public void setQtyInStock(int qtyInStock) {
this.qtyInStock = qtyInStock;
}
public double getPrice() {
return price;
}
public void setPrice(double price) {
this.price = price;
}
public boolean getActive() {
return active;
}
public void setActive(boolean active) {
this.active = active;
}
public double getInventoryValue()
{
return price * qtyInStock;
}
public String toString()
{
return "\n\nNúmero do Item : " + this.itemNumber
+ "\nNome : " + this.name
+ "\nQuantidade em estoque: " + this.qtyInStock
+ "\nPreço : " + this.price
+ "Valor do Estoque : " + getInventoryValue()
+ "\nStatus do Produto : " + (this.active?"Ativo":"Descontinuado");
}
}
