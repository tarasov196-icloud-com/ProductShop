package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {


        SimpleProduct product1 = new SimpleProduct("Ноутбук", 114000);
        SimpleProduct product3 = new SimpleProduct("Наушники", 6500);
        FixPriceProduct product4 = new FixPriceProduct("Мышь");
        FixPriceProduct product5 = new FixPriceProduct("Клавиатура");
        DiscountedProduct product6 = new DiscountedProduct("Монитор", 31000, 25);
        SimpleProduct product2 = new SimpleProduct("Смартфон", 155000);

        ProductBasket basket = new ProductBasket();


        basket.addProduct(product1);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        basket.addProduct(product6);
        basket.addProduct(product2);


        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.totalCostBasket());

        System.out.println("Есть ли 'Наушники' в корзине? " + basket.containsProductByName("Наушники"));

        System.out.println("Есть ли 'Монитор' в корзине? " + basket.containsProductByName("Монитор"));

        basket.clearBasket();
        System.out.println("\nКорзина после очистки:");

        basket.printBasket();

        System.out.println("Общая стоимость пустой корзины: " + basket.totalCostBasket());

        System.out.println("Есть ли 'Ноутбук' в пустой корзине? " + basket.containsProductByName("Ноутбук"));

        SearchEngine test1 = new SearchEngine(10);

        Article article1 = new Article("Как начать программировать на Java", "Java — один из самых популярных языков программирования. В этой статье мы рассмотрим основы синтаксиса, установку JDK и напишем первую программу.");
        Article article2 = new Article("Искусственный интеллект: будущее уже здесь", "Нейросети и машинное обучение меняют мир. Узнайте, как ИИ применяется в медицине, финансах и повседневной жизни.");
        Article article3 = new Article("Здоровый образ жизни: с чего начать?", "Правильное питание, спорт и режим сна — ключевые составляющие здоровья. В этой статье — простые шаги к улучшению качества жизни.");
        Article article4 = new Article("Криптовалюты: инвестиции или риск?", "Биткоин, Ethereum и другие цифровые активы привлекают инвесторов. Разбираем плюсы и минусы вложений в криптовалюты.");
        Article article5 = new Article("Путешествия по России: топ-5 мест", "От Байкала до Камчатки — в России множество удивительных мест. Мы собрали лучшие направления для вашего следующего путешествия.");
        Article article6 = new Article("Как улучшить продуктивность на работе", "Тайм-менеджмент, правильное планирование и полезные привычки помогут вам успевать больше. Читайте советы в нашей статье.");

        test1.add(article1);
        test1.add(article2);
        test1.add(article3);
        test1.add(article4);
        test1.add(article5);
        test1.add(article6);
        test1.add(product1);
        test1.add(product2);
        test1.add(product3);
        test1.add(product4);
        test1.add(product5);

        SearchEngine searchEngine = new SearchEngine(20);

        searchEngine.add(new SimpleProduct("Ноутбук Lenovo IdeaPad", 65000));
        searchEngine.add(new SimpleProduct("Смартфон Samsung Galaxy S23", 89990));
        searchEngine.add(new FixPriceProduct("Беспроводная мышь"));
        searchEngine.add(new FixPriceProduct("Проводная клавиатура"));
        searchEngine.add(new DiscountedProduct("Игровой монитор", 34990, 15));
        searchEngine.add(new SimpleProduct("Наушники Sony WH-1000XM4", 29990));
        searchEngine.add(new DiscountedProduct("Фитнес-браслет", 5990, 10));

        searchEngine.add(new Article("Обзор ноутбуков 2023",
                "Лучшие ноутбуки этого года: Lenovo, Asus, HP"));
        searchEngine.add(new Article("Новости технологий",
                "Samsung анонсировала новую линейку смартфонов"));
        searchEngine.add(new Article("Руководство по выбору наушников",
                "Как выбрать лучшие беспроводные наушники"));
        searchEngine.add(new Article("Игровые мониторы",
                "ТОП-5 игровых мониторов 2023 года"));

        System.out.println("=== Поиск по слову 'ноутбук' ===");
        Searchable[] results1 = searchEngine.search("ноутбук");
        System.out.println(Arrays.toString(results1));
        printSearchResults(results1);

        System.out.println("\n=== Поиск по слову 'Samsung' ===");
        Searchable[] results2 = searchEngine.search("Samsung");
        System.out.println(Arrays.toString(results2));
        printSearchResults(results2);

        System.out.println("\n=== Поиск по слову 'беспроводные' ===");
        Searchable[] results3 = searchEngine.search("беспроводные");
        System.out.println(Arrays.toString(results3));
        printSearchResults(results3);

        System.out.println("\n=== Поиск по слову '2023' ===");
        Searchable[] results4 = searchEngine.search("2023");
        System.out.println(Arrays.toString(results4));
        printSearchResults(results4);

        System.out.println("\n=== Поиск по несуществующему слову 'планшет' ===");
        Searchable[] results5 = searchEngine.search("планшет");
        System.out.println(Arrays.toString(results5));
        printSearchResults(results5);
    }

    private static void printSearchResults(Searchable[] results) {
        System.out.println("Найдено результатов: " + countNonNull(results));
        for (Searchable item : results) {
            if (item != null) {
                System.out.println("- " + item.getStringRepresentation());
            }
        }
    }

    private static int countNonNull(Searchable[] array) {
        int count = 0;
        for (Searchable item : array) {
            if (item != null) count++;
        }
        return count;

    }
}



