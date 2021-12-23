public class Basket {

    private static int count = 0;
    private String items = "";
    private static int totalPrice = 0;
    private int limit;

    private static int totalPriceProduct = 0;
    private static int totalCountProduct = 0;


    public Basket() {
        //increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static void increaseTotalCountProduct(int count){
        Basket.totalCountProduct = Basket.totalCountProduct + count;
    }
    public static void increaseTotalPriceProduct(int totalPrice){
        Basket.totalPriceProduct = Basket.totalPrice + totalPrice;
    }
    public static double averagePriceProduct(int totalValueProduct, int totalCountProduct){
        return (double) Basket.totalPriceProduct / Basket.totalCountProduct;
    }
    public static double averagePriceBasket(){
        return (double) Basket.totalPriceProduct / Basket.count;
    }


    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count += count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {

        increaseTotalCountProduct(count);
        increaseTotalPriceProduct(price);
        increaseCount(1);

        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
            count + " шт. - " + price;
        totalPrice = totalPrice + count * price;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print() {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
        System.out.println("Общее количество товаров: " + totalCountProduct);
        System.out.println("Общая стоимость всех товаров: " + totalPriceProduct);
        System.out.print("Средняя цена товара во всех корзинах: ");
        System.out.format("%.2f",Basket.averagePriceProduct(totalPriceProduct,totalCountProduct));
        System.out.println();
        System.out.print("Средняя стоимость корзины: ");
        System.out.format("%.2f",Basket.averagePriceBasket());
    }
}
