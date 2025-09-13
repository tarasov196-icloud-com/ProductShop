package org.skypro.skyshop.search;

import java.util.Set;
import java.util.TreeSet;
import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchableItems;

    public SearchEngine() {
        this.searchableItems = new HashSet<>();
    }

    public void add(Searchable item) {
        if (item != null) {
            searchableItems.add(item);
        }
    }

    public static class SearchableNameLengthComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lenComp = Integer.compare(o1.getName().length(), o2.getName().length());
            if (lenComp != 0) {
                return lenComp;
            }
            return o1.getName().compareTo(o2.getName());
        }
    }

    public Set<Searchable> search(String searchString) {
        Comparator<Searchable> comparator = new SearchableNameLengthComparator();

        if (searchString == null || searchString.trim().isEmpty()) {
            return new TreeSet<>(comparator);
        }

        String lowerSearchString = searchString.toLowerCase();

        return searchableItems.stream()
                .filter(Objects::nonNull)
                .filter(item -> item.getSearchTerm() != null && item.getSearchTerm().toLowerCase().contains(lowerSearchString))
                .collect(Collectors.toCollection(() -> new TreeSet<>(comparator)));
    }

    public Map<String, List<Searchable>> searchAndSortByName(String searchString) {
        Map<String, List<Searchable>> groupedResults = new HashMap<>();

        if (searchString == null || searchString.trim().isEmpty()) {
            return groupedResults;
        }

        String lowerSearchString = searchString.toLowerCase();

        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm() != null && item.getSearchTerm().toLowerCase().contains(lowerSearchString)) {
                String contentType = item.getContentType() != null ? item.getContentType() : "unknown";
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

    public List<Searchable> searchList(String searchString) {
        List<Searchable> results = new ArrayList<>();

        if (searchString == null || searchString.trim().isEmpty()) {
            return results;
        }

        String lowerSearchString = searchString.toLowerCase();

        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm() != null && item.getSearchTerm().toLowerCase().contains(lowerSearchString)) {
                results.add(item);
            }
        }

        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.trim().isEmpty()) {
            throw new BestResultNotFound(search);
        }

        String searchLower = search.toLowerCase();
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : searchableItems) {
            if (item != null && item.getSearchTerm() != null) {
                int count = countSubstringOccurrences(item.getSearchTerm().toLowerCase(), searchLower);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }

        if (maxCount == 0 || bestMatch == null) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

    private int countSubstringOccurrences(String str, String substring) {
        if (substring.isEmpty() || str.isEmpty()) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
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