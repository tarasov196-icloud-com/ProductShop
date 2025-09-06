package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.content.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {


        SearchEngine searchEngine1 = new SearchEngine();

        searchEngine1.add(new SimpleProduct("Ноутбук Lenovo IdeaPad", 65000));
        searchEngine1.add(new SimpleProduct("Смартфон Samsung Galaxy S23", 89990));
        searchEngine1.add(new FixPriceProduct("Беспроводная мышь"));
        searchEngine1.add(new FixPriceProduct("Проводная клавиатура"));
        searchEngine1.add(new DiscountedProduct("Игровой монитор", 34990, 15));
        searchEngine1.add(new SimpleProduct("Наушники Sony WH-1000XM4", 29990));
        searchEngine1.add(new DiscountedProduct("Фитнес-браслет", 5990, 10));
        searchEngine1.add(new DiscountedProduct("Ноутбук для детей", 5990, 10));





                searchEngine1.add(new Article("Обзор ноутбуков 2023",
                "Лучшие ноутбуки этого года: Lenovo, Asus, HP"));
        searchEngine1.add(new Article("Новости технологий",
                "Samsung анонсировала новую линейку смартфонов"));
        searchEngine1.add(new Article("Руководство по выбору наушников",
                "Как выбрать лучшие беспроводные наушники"));
        searchEngine1.add(new Article("Игровые мониторы",
                "ТОП-5 игровых мониторов 2023 года"));

        System.out.println("Сортировка Мар");

        Map<String, List<Searchable>> SortedResultsNoutbuk = searchEngine1.searchAndSortByName("Ноутбук");
        for (Map.Entry<String,List<Searchable>>entry: SortedResultsNoutbuk.entrySet()){
            for (Searchable item : entry.getValue()) {
                System.out.println(item.getStringRepresentation());
            }
        }


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
