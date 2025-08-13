package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        SearchEngine searchEngine = new SearchEngine();


        searchEngine.add(new SimpleProduct("Ноутбук Lenovo IdeaPad", 65000));
        searchEngine.add(new SimpleProduct("Смартфон Samsung Galaxy S23", 89990));
        searchEngine.add(new Article("Обзор ноутбуков 2023",
                "Lenovo представил новые модели ноутбуков с улучшенными характеристиками."));
        searchEngine.add(new Article("Новости технологий",
                "Samsung анонсировала новую линейку смартфонов Galaxy с улучшенными камерами."));

        System.out.println("=== Поиск по слову 'ноутбук' ===");
        List<Searchable> results1 = searchEngine.search("ноутбук");
        printSearchResults(results1);

        System.out.println("\n=== Поиск по слову 'Samsung' ===");
        List<Searchable> results2 = searchEngine.search("Samsung");
        printSearchResults(results2);

        System.out.println("\n=== Поиск по слову 'беспроводные' ===");
        List<Searchable> results3 = searchEngine.search("беспроводные");
        printSearchResults(results3);

        System.out.println("\n=== Поиск по слову '2023' ===");
        List<Searchable> results4 = searchEngine.search("2023");
        printSearchResults(results4);

        System.out.println("\n=== Поиск по несуществующему слову 'планшет' ===");
        List<Searchable> results5 = searchEngine.search("планшет");
        printSearchResults(results5);
    }

    private static void printSearchResults(List<Searchable> results) {
        System.out.println("Найдено результатов: " + results.size());
        for (Searchable item : results) {
            if (item != null) {
                System.out.println("- " + item.getStringRepresentation());
            }
        }


// 1 решение

//        System.out.println("=== Сценарий 1: Успешный поиск ===");
//        try {
//            String searchQuery = "Lenovo";
//            Searchable result = searchEngine.findBestMatch(searchQuery);
//            System.out.println("Найден лучший результат для '" + searchQuery + "':");
//            System.out.println("- Тип: " + result.getContentType());
//            System.out.println("- Название: " + result.getName());
//            System.out.println("- Совпадений: " +
//                    searchEngine.countSubstringOccurrences(
//                            result.getSearchTerm().toLowerCase(),
//                            searchQuery.toLowerCase()));
//        } catch (BestResultNotFound e) {
//            System.out.println("Ошибка: " + e.getMessage());
//        }
//// 2 решение
//        System.out.println("\n=== Сценарий 2: Поиск с исключением ===");
//        String searchQuery = null;
//        try {
//            searchQuery = "Apple";
//            Searchable result = searchEngine.findBestMatch(searchQuery);
//            System.out.println("Найден лучший результат для '" + searchQuery + "':");
//            System.out.println("- Тип: " + result.getContentType());
//            System.out.println("- Название: " + result.getName());
//        } catch (BestResultNotFound e) {
//            System.out.println("Ошибка при поиске '" + searchQuery + "':");
//            System.out.println("-> " + e.getMessage());
//            System.out.println("Рекомендация: попробуйте изменить поисковый запрос");
//        }
//
//        try {
//            SimpleProduct goodProduct = new SimpleProduct("Правильный товар", 1000);
//            System.out.println("Создан продукт: " + goodProduct);
//
//
//            SimpleProduct badNameProduct = new SimpleProduct("", 500);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка создания продукта: " + e.getMessage());
//        }
//
//        try {
//            SimpleProduct badPriceProduct = new SimpleProduct("Товар с нулевой ценой", 0);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка создания продукта: " + e.getMessage());
//        }
//
//        try {
//            DiscountedProduct badDiscountProduct = new DiscountedProduct("Товар со скидкой", 1000, 150);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка создания продукта: " + e.getMessage());
//        }

//        try {
//            DiscountedProduct badBasePriceProduct = new DiscountedProduct("Товар с отрицательной ценой", -100, 10);
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка создания продукта: " + e.getMessage());
//        }
//
//        try {
//            Article goodArticle = new Article("Правильная статья", "Содержание статьи");
//            System.out.println("Создана статья: " + goodArticle.getTitle());
//
//            Article badTitleArticle = new Article("", "Содержание");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка создания статьи: " + e.getMessage());
//        }
//
//        try {
//            Article badTextArticle = new Article("Заголовок", "   ");
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка создания статьи: " + e.getMessage());
//        }

        ProductBasket basket = new ProductBasket();
//        try {
//            basket.addProduct(new SimpleProduct("Хороший товар", 1000));
//            basket.addProduct(new SimpleProduct("", 500));
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка добавления в корзину: " + e.getMessage());
//        }

        System.out.println("Итоговое содержимое корзины:");
        basket.printBasket();

        SimpleProduct product1 = new SimpleProduct("Ноутбук", 114000);
        SimpleProduct product7 = new SimpleProduct("Ноутбук Lenovo", 117800);
        SimpleProduct product3 = new SimpleProduct("Наушники", 6500);
        FixPriceProduct product4 = new FixPriceProduct("Мышь");
        FixPriceProduct product5 = new FixPriceProduct("Клавиатура");
        DiscountedProduct product6 = new DiscountedProduct("Монитор", 31000, 25);
        SimpleProduct product2 = new SimpleProduct("Смартфон", 155000);

        basket.addProduct(product1);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        basket.addProduct(product6);
        basket.addProduct(product7);
        basket.addProduct(product2);


        basket.printBasket();
        System.out.println("РАБОТА СО СПИСКАМИ");
        basket.removeProductsByName("Ноутбук Lenovo");
        basket.printBasket();

        List<Product> deletedProducts = basket.removeProductsByName("Ноутбук lenovo");
        System.out.println("Удалённые продукты:");
        for (Product p : deletedProducts) {
            System.out.println(p);
        }

        String productNameToRemove = "Продукт";

        List<Product> removedProducts = basket.removeProductsByName(productNameToRemove);
        if (removedProducts.isEmpty()) {
            System.out.println("Продукт '" + productNameToRemove + "' не найден в корзине.");
        } else {
            System.out.println("Удалены продукты:");
            for (Product p : removedProducts) {
                System.out.println(p);
            }
        }

        System.out.println("Содержимое корзины:");
        for (Product product : basket.getProducts()) {
            System.out.println(product);
        }

//        System.out.println("Общая стоимость корзины: " + basket.totalCostBasket());
//
//        System.out.println("Есть ли 'Наушники' в корзине? " + basket.containsProductByName("Наушники"));
//
//        System.out.println("Есть ли 'Монитор' в корзине? " + basket.containsProductByName("Монитор"));
//
//        basket.clearBasket();
//        System.out.println("\nКорзина после очистки:");
//
//        basket.printBasket();
//
//        System.out.println("Общая стоимость пустой корзины: " + basket.totalCostBasket());
//
//        System.out.println("Есть ли 'Ноутбук' в пустой корзине? " + basket.containsProductByName("Ноутбук"));

        SearchEngine test1 = new SearchEngine();

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

        SearchEngine searchEngine1 = new SearchEngine();

        searchEngine1.add(new SimpleProduct("Ноутбук Lenovo IdeaPad", 65000));
        searchEngine1.add(new SimpleProduct("Смартфон Samsung Galaxy S23", 89990));
        searchEngine1.add(new FixPriceProduct("Беспроводная мышь"));
        searchEngine1.add(new FixPriceProduct("Проводная клавиатура"));
        searchEngine1.add(new DiscountedProduct("Игровой монитор", 34990, 15));
        searchEngine1.add(new SimpleProduct("Наушники Sony WH-1000XM4", 29990));
        searchEngine1.add(new DiscountedProduct("Фитнес-браслет", 5990, 10));


        searchEngine1.add(new Article("Обзор ноутбуков 2023",
                "Лучшие ноутбуки этого года: Lenovo, Asus, HP"));
        searchEngine1.add(new Article("Новости технологий",
                "Samsung анонсировала новую линейку смартфонов"));
        searchEngine1.add(new Article("Руководство по выбору наушников",
                "Как выбрать лучшие беспроводные наушники"));
        searchEngine1.add(new Article("Игровые мониторы",
                "ТОП-5 игровых мониторов 2023 года"));


//        System.out.println("=== Поиск по слову 'ноутбук' ===");
//        Searchable[] results1 = searchEngine.search("ноутбук");
//        System.out.println(Arrays.toString(results1));
//        printSearchResults(results1);
//
//        System.out.println("\n=== Поиск по слову 'Samsung' ===");
//        Searchable[] results2 = searchEngine.search("Samsung");
//        System.out.println(Arrays.toString(results2));
//        printSearchResults(results2);
//
//        System.out.println("\n=== Поиск по слову 'беспроводные' ===");
//        Searchable[] results3 = searchEngine.search("беспроводные");
//        System.out.println(Arrays.toString(results3));
//        printSearchResults(results3);

//        System.out.println("\n=== Поиск по слову '2023' ===");
//        Searchable[] results4 = searchEngine.search("2023");
//        System.out.println(Arrays.toString(results4));
//        printSearchResults(results4);
//
//        System.out.println("\n=== Поиск по несуществующему слову 'планшет' ===");
//        Searchable[] results5 = searchEngine.search("планшет");
//        System.out.println(Arrays.toString(results5));
//        printSearchResults(results5);
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
