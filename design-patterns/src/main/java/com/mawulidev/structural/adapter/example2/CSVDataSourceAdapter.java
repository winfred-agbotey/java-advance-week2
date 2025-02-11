package com.mawulidev.structural.adapter.example2;


import java.util.List;

// Adapter that makes CSVReader conform to the DataSource interface.
public class CSVDataSourceAdapter implements DataSource {
    private final CSVReader csvReader;

    public CSVDataSourceAdapter(String filePath) {
        this.csvReader = new CSVReader(filePath);
    }

    @Override
    public List<String[]> readData() {
        return csvReader.getCSVContent();
    }
}