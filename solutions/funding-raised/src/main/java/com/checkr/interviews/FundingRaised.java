package com.checkr.interviews;

import java.util.*;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class FundingRaised {
    static String[] fields = new String[] { "permalink", "company_name", "number_employees", "category", "city",
            "state", "funded_date", "raised_amount", "raised_currency", "round" };

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<String[]> csvData = new ArrayList<String[]>();

        CSVReader reader = new CSVReader(new FileReader("startup_funding.csv"));
        String[] row = null;

        while ((row = reader.readNext()) != null) {
            csvData.add(row);
        }

        reader.close();
        csvData.remove(0);

        List<String[]> filteredRows = new ArrayList<>(csvData);

        for (int fieldIndex = 0; fieldIndex < fields.length; fieldIndex++) {
            List<String[]> newFilteredRows = new ArrayList<>();

            if (options.containsKey(fields[fieldIndex])) {
                for (String[] csvRow : filteredRows) {
                    if (csvRow[fieldIndex].equals(options.get(fields[fieldIndex]))) {
                        newFilteredRows.add(csvRow);
                    }
                }
                filteredRows = newFilteredRows;
            }
        }

        List<Map<String, String>> output = new ArrayList<Map<String, String>>();
        for (String[] filteredRow : filteredRows) {
            output.add(lineToMap(filteredRow));
        }

        return output;
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
