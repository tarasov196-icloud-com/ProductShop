package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchableItems;

    public SearchEngine() {
        this.searchableItems = new ArrayList<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public List<Searchable> search(String searchString) {
        List<Searchable> results = new ArrayList<>();

        if (searchString == null || searchString.trim().isEmpty()) {
            return results; // возвращаем пустой список
        }

        String lowerSearchString = searchString.toLowerCase();

        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(lowerSearchString)) {
                results.add(item);
            }
        }

        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : searchableItems) {
            if (item != null) {
                String searchTerm = item.getSearchTerm().toLowerCase();
                String searchLower = search.toLowerCase();
                int count = countSubstringOccurrences(searchTerm, searchLower);

                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }

        if (maxCount <= 0 || bestMatch == null) {
            throw new BestResultNotFound(search);
        }
        return bestMatch;
    }

    public int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        if (substringLength == 0) {
            return 0;
        }

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substringLength;
        }
        return count;
    }

//    public List<Product> removeProductsByName(String name) {
//        List<Product> removedProducts = new ArrayList<>();
//
//
//        var iterator = searchableItems.iterator();
//
//        while (iterator.hasNext()) {
//            Searchable item = iterator.next();
//            if (item instanceof Product) {
//                Product product = (Product) item;
//                if (product.getName().equalsIgnoreCase(name)) {
//                    removedProducts.add(product);
//                    iterator.remove();
//                }
//            }
//        }
//
//        return removedProducts;
//    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchableItems=" + searchableItems +
                '}';
    }
}