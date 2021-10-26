package com.checkr.interviews;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            Map<String, String> options = new HashMap<String, String>();
            options.put("company_name", "Facebook");
            options.put("round", "a");
            System.out.print(FundingRaised.where(options).size());
        } catch (IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }
}
