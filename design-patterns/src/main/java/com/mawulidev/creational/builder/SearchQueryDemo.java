package com.mawulidev.creational.builder;

import java.time.LocalDate;

public class SearchQueryDemo {
    public static void main(String[] args) {
        // Build a simple search query with only the required query text
        SearchQuery simpleQuery = new SearchQuery.Builder("open source")
                .build();
        System.out.println(simpleQuery);

        // Build a more complex search query with multiple filters
        SearchQuery advancedQuery = new SearchQuery.Builder("design patterns")
                .category("programming")
                .startDate(LocalDate.of(2020, 1, 1))
                .endDate(LocalDate.of(2025, 12, 31))
                .sortBy("relevance")
                .build();
        System.out.println(advancedQuery);
    }
}
