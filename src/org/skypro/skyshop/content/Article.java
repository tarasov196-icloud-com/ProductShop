package org.skypro.skyshop.content;

import org.skypro.skyshop.search.Searchable;

public final class Article implements Searchable {
    private final String title;
    private final String text;

    public String getSearchTerm() {
        return title + " " + text;
    }

    public String getContentType() {
        return "ARTICLE";
    }

    public String getName() {
        return title;
    }

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }
}

