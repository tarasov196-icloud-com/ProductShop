package org.skypro.skyshop.search;

import java.util.Set;
import java.util.TreeSet;
import java.util.*;
import java.util.Comparator;

public class SearchEngine {
    private final Set<Searchable> searchableItems;

    public SearchEngine() {
        this.searchableItems = new HashSet<>();
    }

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    // Компаратор для сортировки по длине имени, затем по имени
    public static class SearchableNameLengthComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lengthCompare = Integer.compare(o1.getName().length(), o2.getName().length());
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            return o1.getName().compareTo(o2.getName());
        }
    }


    public Map<String, List<Searchable>> searchAndSortByName(String searchString) {
        Map<String, List<Searchable>> groupedResults = new HashMap<>();

        if (searchString == null || searchString.trim().isEmpty()) {
            return groupedResults;
        }

        String lowerSearchString = searchString.toLowerCase();

        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(lowerSearchString)) {
                String contentType = item.getContentType();
                groupedResults.putIfAbsent(contentType, new ArrayList<>());
                groupedResults.get(contentType).add(item);
            }
        }

        Comparator<Searchable> comparator = new SearchableNameLengthComparator();
        for (List<Searchable> list : groupedResults.values()) {
            list.sort(comparator);
        }

        return groupedResults;
    }


    public List<Searchable> search(String searchString) {
        List<Searchable> results = new ArrayList<>();

        if (searchString == null || searchString.trim().isEmpty()) {
            return results;
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
        String searchLower = search.toLowerCase();

        for (Searchable item : searchableItems) {
            if (item != null) {
                String searchTerm = item.getSearchTerm().toLowerCase();
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

    private int countSubstringOccurrences(String str, String substring) {
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
                "searchableItems=" + searchableItems +
                '}';
    }


    public static class BestResultNotFound extends Exception {
        public BestResultNotFound(String search) {
            super("Best result not found for search: " + search);
        }
    }
}