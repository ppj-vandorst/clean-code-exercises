package com.checkr.interviews;

import java.util.*;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class FundingRaised {
    static String[] FILTERABLE_FIELDS = new String[] { "company_name", "city", "state", "round" };

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<Map<String, String>> rows = extractCsvData("startup_funding.csv");

        for (String field : FILTERABLE_FIELDS) {
            List<Map<String, String>> filteredRows = new ArrayList<>();

            if (options.containsKey(field)) {
                for (Map<String, String> row : rows) {
                    if (rowMatchesOption(row, field, options.get(field))) {
                        filteredRows.add(row);
                    }
                }
                rows = filteredRows;
            }
        }

        return rows;
    }

    private static boolean rowMatchesOption(Map<String, String> row, String optionKey, String optionValue) {
        return row.containsKey(optionKey) && row.get(optionKey).equals(optionValue);
    }

    public static Map<String, String> lineToMap(String[] line) {
        Map<String, String> mappedLine = new HashMap<String, String>();
        mappedLine.put("permalink", line[0]);
        mappedLine.put("company_name", line[1]);
        mappedLine.put("number_employees", line[2]);
        mappedLine.put("category", line[3]);
        mappedLine.put("city", line[4]);
        mappedLine.put("state", line[5]);
        mappedLine.put("funded_date", line[6]);
        mappedLine.put("raised_amount", line[7]);
        mappedLine.put("raised_currency", line[8]);
        mappedLine.put("round", line[9]);
        return mappedLine;
    }

    public static List<Map<String, String>> extractCsvData(String filePath) {
        try {
            CSVReader reader = new CSVReader(new FileReader(filePath));
            List<Map<String, String>> rows = new ArrayList<>();

            String[] row = null;
            while ((row = reader.readNext()) != null) {
                rows.add(lineToMap(row));
            }

            reader.close();
            rows.remove(0);
            return rows;
        } catch (IOException e) {
            throw new RuntimeException("Parsing of CSV failed", e);
        }
    }

    public static Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<String[]> csvData = new ArrayList<String[]>();
        CSVReader reader = new CSVReader(new FileReader("startup_funding.csv"));
        String[] row = null;

        while ((row = reader.readNext()) != null) {
            csvData.add(row);
        }

        reader.close();
        csvData.remove(0);
        Map<String, String> mapped = new HashMap<String, String>();

        for (int i = 0; i < csvData.size(); i++) {
            if (options.containsKey("company_name")) {
                if (csvData.get(i)[1].equals(options.get("company_name"))) {
                    mapped.put("permalink", csvData.get(i)[0]);
                    mapped.put("company_name", csvData.get(i)[1]);
                    mapped.put("number_employees", csvData.get(i)[2]);
                    mapped.put("category", csvData.get(i)[3]);
                    mapped.put("city", csvData.get(i)[4]);
                    mapped.put("state", csvData.get(i)[5]);
                    mapped.put("funded_date", csvData.get(i)[6]);
                    mapped.put("raised_amount", csvData.get(i)[7]);
                    mapped.put("raised_currency", csvData.get(i)[8]);
                    mapped.put("round", csvData.get(i)[9]);
                } else {
                    continue;
                }
            }

            if (options.containsKey("city")) {
                if (csvData.get(i)[4].equals(options.get("city"))) {
                    mapped.put("permalink", csvData.get(i)[0]);
                    mapped.put("company_name", csvData.get(i)[1]);
                    mapped.put("number_employees", csvData.get(i)[2]);
                    mapped.put("category", csvData.get(i)[3]);
                    mapped.put("city", csvData.get(i)[4]);
                    mapped.put("state", csvData.get(i)[5]);
                    mapped.put("funded_date", csvData.get(i)[6]);
                    mapped.put("raised_amount", csvData.get(i)[7]);
                    mapped.put("raised_currency", csvData.get(i)[8]);
                    mapped.put("round", csvData.get(i)[9]);
                } else {
                    continue;
                }
            }

            if (options.containsKey("state")) {
                if (csvData.get(i)[5].equals(options.get("state"))) {
                    mapped.put("permalink", csvData.get(i)[0]);
                    mapped.put("company_name", csvData.get(i)[1]);
                    mapped.put("number_employees", csvData.get(i)[2]);
                    mapped.put("category", csvData.get(i)[3]);
                    mapped.put("city", csvData.get(i)[4]);
                    mapped.put("state", csvData.get(i)[5]);
                    mapped.put("funded_date", csvData.get(i)[6]);
                    mapped.put("raised_amount", csvData.get(i)[7]);
                    mapped.put("raised_currency", csvData.get(i)[8]);
                    mapped.put("round", csvData.get(i)[9]);
                } else {
                    continue;
                }
            }

            if (options.containsKey("round")) {
                if (csvData.get(i)[9].equals(options.get("round"))) {
                    mapped.put("permalink", csvData.get(i)[0]);
                    mapped.put("company_name", csvData.get(i)[1]);
                    mapped.put("number_employees", csvData.get(i)[2]);
                    mapped.put("category", csvData.get(i)[3]);
                    mapped.put("city", csvData.get(i)[4]);
                    mapped.put("state", csvData.get(i)[5]);
                    mapped.put("funded_date", csvData.get(i)[6]);
                    mapped.put("raised_amount", csvData.get(i)[7]);
                    mapped.put("raised_currency", csvData.get(i)[8]);
                    mapped.put("round", csvData.get(i)[9]);
                } else {
                    continue;
                }
            }

            return mapped;
        }

        throw new NoSuchEntryException();
    }
}
