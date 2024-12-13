package inventory;

public class CD extends Product {
private String artist;
private int numberOfSongs;
private String label;
public CD(int number, String name, int qty, double price, String artist, int numSongs, String
label)
{
super(number, name, qty, price);
this.artist = artist;
this.numberOfSongs = numSongs;
this.label = label;
}
public String getArtist() {
return artist;
}
public void setArtist(String artist) {
this.artist = artist;
}
public int getNumberOfSongs() {
return numberOfSongs;
}
public void setNumberOfSongs(int numberOfSongs) {
this.numberOfSongs = numberOfSongs;}

public String getLabel(){
    return label;

}
public void setLabel(String label) {
this.label = label;
}
public String toString()
{
return "\n\nNúmero do Item : " + getItemNumber()
+ "\nNome : " + getName()
+ "\nArtista : " + getArtist()
+ "\nMúsicas do Álbum :" + getNumberOfSongs()
+ "\nSelo de Gravação : " + getLabel()
+ "\nQuantidade em estoque: " + getQtyInStock()
+ "\nPreço : " + getPrice()
+ "Valor do Estoque : " + getInventoryValue()
+ "\nStatus do Produto : " + (getActive()?"Ativo":"Descontinuado");
}
}
