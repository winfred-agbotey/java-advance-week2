package com.mawulidev.structural.adapter.example2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// A simple CSV reader that does not implement the DataSource interface.
public class CSVReader {
    private final String filePath;

    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    public List<String[]> getCSVContent() {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Simple CSV parsing (no quote handling).
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
