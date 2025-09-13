package org.skypro.skyshop.search;

import java.util.Comparator;

public interface Searchable {

    String getSearchTerm();

    String getContentType();

    String getName();

    default String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}