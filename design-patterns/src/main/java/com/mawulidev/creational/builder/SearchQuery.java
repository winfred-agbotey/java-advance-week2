package com.mawulidev.creational.builder;

import java.time.LocalDate;

public class SearchQuery {
    private final String query;       // required
    private final String category;    // optional
    private final LocalDate startDate;// optional
    private final LocalDate endDate;  // optional
    private final String sortBy;      // optional

    private SearchQuery(Builder builder) {
        this.query     = builder.query;
        this.category  = builder.category;
        this.startDate = builder.startDate;
        this.endDate   = builder.endDate;
        this.sortBy    = builder.sortBy;
    }

    // Getters for inspection
    public String getQuery()      { return query; }
    public String getCategory()   { return category; }
    public LocalDate getStartDate(){ return startDate; }
    public LocalDate getEndDate()  { return endDate; }
    public String getSortBy()     { return sortBy; }

    @Override
    public String toString() {
        return "SearchQuery{" +
                "query='" + query + '\'' +
                ", category='" + category + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", sortBy='" + sortBy + '\'' +
                '}';
    }

    // Builder for SearchQuery
    public static class Builder {
        // Required field
        private final String query;
        // Optional fields with default values (if any)
        private String category;
        private LocalDate startDate;
        private LocalDate endDate;
        private String sortBy;

        public Builder(String query) {
            if (query == null || query.isEmpty()) {
                throw new IllegalArgumentException("Query text must not be null or empty");
            }
            this.query = query;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public Builder startDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder sortBy(String sortBy) {
            this.sortBy = sortBy;
            return this;
        }

        public SearchQuery build() {
            // Optional: add validation logic here if needed
            return new SearchQuery(this);
        }
    }
}