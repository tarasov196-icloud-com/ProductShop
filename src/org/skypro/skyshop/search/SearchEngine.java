package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searchableItems;
    private int currentIndex;

    public SearchEngine(int capacity) {
        this.searchableItems = new Searchable[capacity];
        this.currentIndex = 0;
    }

    public void add(Searchable item) {
        if (currentIndex < searchableItems.length) {
            searchableItems[currentIndex] = item;
            currentIndex++;
        } else {
            System.out.println("В поисковом движке нет места");
        }
    }

    public Searchable[] search(String searchString) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        if (searchString == null || searchString.trim().isEmpty()) {
            return results;
        }

        String lowerSearchString = searchString.toLowerCase();

        for (int i = 0; i < currentIndex && foundCount < 5; i++) {
            Searchable item = searchableItems[i];
            if (item != null && item.getSearchTerm().toLowerCase().contains(lowerSearchString)) {
                results[foundCount] = item;
                foundCount++;
            }
        }

        return results;
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchableItems=" + Arrays.toString(searchableItems) +
                ", currentIndex=" + currentIndex +
                '}';
    }
}