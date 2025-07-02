import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

        public class App {
            public static void main(String[] args) {

                Product product1 = new Product("Ноутбук", 114000);
                Product product2 = new Product("Смартфон", 155000);
                Product product3 = new Product("Наушники", 6500);
                Product product4 = new Product("Мышь", 2500);
                Product product5 = new Product("Клавиатура", 3200);
                Product product6 = new Product("Монитор", 31000);

                ProductBasket basket = new ProductBasket();

                basket.addProduct(product1);
                basket.addProduct(product2);
                basket.addProduct(product3);
                basket.addProduct(product4);
                basket.addProduct(product5);

                basket.addProduct(product6);

                System.out.println("Содержимое корзины:");
                basket.printBasket();

                System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

                System.out.println("Есть ли 'Наушники' в корзине? " + basket.containsProductByName("Наушники"));

                System.out.println("Есть ли 'Монитор' в корзине? " + basket.containsProductByName("Монитор"));

                basket.clearBasket();
                System.out.println("\nКорзина после очистки:");

                basket.printBasket();

                System.out.println("Общая стоимость пустой корзины: " + basket.getTotalPrice());

                System.out.println("Есть ли 'Ноутбук' в пустой корзине? " + basket.containsProductByName("Ноутбук"));

            }
        }