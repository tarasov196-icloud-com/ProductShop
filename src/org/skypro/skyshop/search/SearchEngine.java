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

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.isEmpty()) {
            throw new BestResultNotFound(search);
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        for (int i = 0; i < currentIndex; i++) {
            Searchable item = searchableItems[i];
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

        if (maxCount <= 0) {
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

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchableItems=" + Arrays.toString(searchableItems) +
                ", currentIndex=" + currentIndex +
                '}';
    }
}
