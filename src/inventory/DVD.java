package inventory;
public class DVD extends Product {
private int length;
private int ageRating;
private String filmStudio;
public DVD(int number, String name, int qty, double price, int length, int rating, String
studio)
{
super(number, name, qty, price);
this.length = length;
this.ageRating = rating;
this.filmStudio = studio;
}
public DVD(int number, String name, int qty, double price)
{
super(number, name, qty, price);
}
public double getInventoryValue()
{
return (1.05 * (super.getPrice() * super.getQtyInStock()));
}
public int getLength() {
return length;
}
public void setLength(int length) {
this.length = length;
}
public int getAgeRating() {
return ageRating;
}
public void setAgeRating(int ageRating) {
this.ageRating = ageRating;
}
public String getFilmStudio() {
return filmStudio;
}
public void setFilmStudio(String filmStudio) {
    this.filmStudio = filmStudio;
}
public String toString()
{
return "\n\nNúmero do Item : " + getItemNumber()
+ "\nNome : " + getName()
+ "\nDuração do Filme : " + getLength()
+ "\nClassificação Etária : " + getAgeRating()
+ "\nEstúdio Cinematográfico : " + getFilmStudio()
+ "\nQuantidade em estoque: " + getQtyInStock()
+ "\nPreço : " + getPrice()
+ "Valor do Estoque : " + getInventoryValue()
+ "\nStatus do Produto : " + (getActive()?"Ativo":"Descontinuado");
}
}