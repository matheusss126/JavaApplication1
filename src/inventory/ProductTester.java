package inventory;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ProductTester {
public static void main(String[] args) {

Scanner in = new Scanner(System.in);
int maxSize, menuChoice;
maxSize = getNumProducts(in);
if(maxSize ==0) {

System.out.println("Não há produtos!");
}else {
Product[] products = new Product[maxSize];
addToInventory(products, in);
do {
menuChoice = getMenuOption(in);
executeMenuChoice(menuChoice, products, in);
}while(menuChoice!=0);
}}

static void executeMenuChoice(int choice, Product[] products, Scanner in) {
switch(choice) {
case 1: System.out.println("Exibir Lista de Produtos");
break;
case 2: System.out.println("Adicionar Estoque");
addInventory(products, in);
break;
case 3: System.out.println("Deduzir Estoque");
deductInventory(products, in);
break;
case 4: System.out.println("Descontinuar Estoque");
discontinueInventory(products, in);
break;
}
}
static void discontinueInventory(Product[] products, Scanner in) {
int productChoice;
productChoice=getProductNumber(products, in);

products[productChoice].setActive(false);}

static void deductInventory(Product[] products, Scanner in){
int productChoice;
int updateValue= -1;
productChoice=getProductNumber(products, in);
do {
try {
System.out.print("Quantos produtos deseja deduzir? ");
updateValue = in.nextInt();
if(updateValue <0)
System.out.println("Insira apenas valores positivos para deduzir do estoque");


if(updateValue > products[productChoice].getQtyInStock())
System.out.println("Não há estoque suficiente para remover essa quantidade; restam "+ products[productChoice].getQtyInStock() + "somente!");

}catch(InputMismatchException e) {
System.out.println("Tipo incorreto de dados inserido!");
in.nextLine();
}catch(Exception e) {
System.out.println(e);
in.nextLine();
}
}while(updateValue <0 ||updateValue > products[productChoice].getQtyInStock());


products[productChoice].deductFromInventory(updateValue);
}

static void addInventory(Product[] products, Scanner in) {
int productChoice;
int updateValue=-1;
productChoice=getProductNumber(products, in);
do {
try {
System.out.print("Quantos produtos deseja adicionar?");
updateValue = in.nextInt();
if(updateValue <0)
System.out.println("Insira apenas valores positivos para adicionar ao estoque");


}catch(InputMismatchException e) {
System.out.println("Tipo incorreto de dados inserido!");
in.nextLine();
}catch(Exception e) {
System.out.println(e);
in.nextLine();
}
}while(updateValue <0);

products[productChoice].addToInventory(updateValue);
}
static int getProductNumber(Product[] products, Scanner in) {
int productChoice=-1;

for(int i = 0; i< products.length; i++)
System.out.println(i + " : " + products[i].getName());

do{
try {

System.out.print("Insira o número do item do produto que deseja atualizar: ");
productChoice = in.nextInt();
if(productChoice <0 || productChoice > products.length-1)
System.out.println("Insira somente valores entre 0 e "
+ (products.length-1));

}catch(InputMismatchException e) {
System.out.println("Tipo incorreto de dados inserido!");
in.nextLine();
}catch(Exception e) {
System.out.println(e);
in.nextLine();
}
}while(productChoice<0 || productChoice > products.length-1);
return productChoice;
}
static int getMenuOption(Scanner in) {
int menuOption=-1;

do {
try {
System.out.println("""
                   
                   
                   1. Exibir Invent\u00e1rio
                   2. Adicionar Estoque
                   3. Deduzir Estoque
                   4. Descontinuar Produto
                   0. Sair""");
System.out.print("Insira uma opção de menu: ");
menuOption = in.nextInt();
}catch(InputMismatchException e) {
System.out.println("Tipo incorreto de dados inserido!");
in.nextLine();
}catch(Exception e) {
    System.out.println(e);
in.nextLine();
}
}while(menuOption <0 || menuOption >4);
return menuOption;
}
static int getNumProducts(Scanner in) {
int maxSize=-1;
do {
try{
System.out.println("Insira o número de produtos que gostaria de adicionar.");

System.out.print("Insira 0 (zero) se não quiser adicionar produtos: ");
maxSize = in.nextInt();
if(maxSize<0)
System.out.println("Valor Incorreto inserido");

}
catch(InputMismatchException e) {
System.out.println("Tipo incorreto de dados inserido!");
in.nextLine();
}catch(Exception e){
System.out.println(e);
in.nextLine();
}
}while(maxSize<0);
return maxSize;
}
static void addToInventory(Product[] products, Scanner in) {

int stockChoice=-1;
for(int i = 0; i<products.length; i++) {

do {
try {
System.out.println("\n1: CD\n2: DVD");
System.out.print("Insira o tipo de produto: ");
stockChoice = in.nextInt();
if(stockChoice <1 || stockChoice >2)
System.out.println("Somente os números 1 ou 2 são permitidos!");

}catch(InputMismatchException e) {
System.out.println("Tipo incorreto de dados inserido!");
in.nextLine();
}catch(Exception e) {
System.out.println(e);
in.nextLine();
}
}while(stockChoice <1 || stockChoice >2);
if(stockChoice==1)
addCDToInventory(products, in, i);
else
addDVDToInventory(products, in, i);

}
}
static void addCDToInventory(Product[] products, Scanner in, int i) {
int tempNumber;
String tempName;
int tempQty;
double tempPrice;
String tempArtist;
int tempNumSongs;
String tempLabel;
in.nextLine();


System.out.print("\n\nInsira o nome do CD: ");
tempName = in.nextLine();
System.out.print("Insira o nome do artista:");
tempArtist = in.nextLine();
System.out.print("Insira o nome do selo de gravação: ");
tempLabel = in.nextLine();
System.out.print("Insira o número de músicas:");
tempNumSongs = in.nextInt();
System.out.print("Insira a quantidade em estoque para este produto: ");
tempQty = in.nextInt();
System.out.print("Insira o preço para este produto: ");
tempPrice = in.nextDouble();
System.out.print("Insira o número do item: ");
tempNumber = in.nextInt();
products[i] = new CD(tempNumber, tempName, tempQty, tempPrice, tempArtist,tempNumSongs, tempLabel);
}
static void addDVDToInventory(Product[] products, Scanner in, int indexValue) {
int tempNumber;
String tempName;
int tempQty;
double tempPrice;
int tempLength;
int tempRating;
String tempStudio;
in.nextLine();

System.out.print("\n\nInsira o nome do DVD: ");
tempName = in.nextLine();
System.out.print("Insira o nome do estúdio cinematográfico: ");
tempStudio = in.nextLine();
System.out.print("Insira a classificação etária: ");
tempRating = in.nextInt();
System.out.print("Insira a duração em minutos: ");
tempLength = in.nextInt();
System.out.print("Insira a quantidade em estoque para este produto: ");
tempQty = in.nextInt();
System.out.print("Insira o preço para este produto: ");
tempPrice = in.nextDouble();
System.out.print("Insira o número do item: ");
tempNumber = in.nextInt();
products[indexValue] = new DVD(tempNumber, tempName, tempQty, tempPrice, tempLength,

tempRating, tempStudio);
}
static void displayInventory(Product[] products) {
for(Product product: products)
System.out.println(product);
}
}