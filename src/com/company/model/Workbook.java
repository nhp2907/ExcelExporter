package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class Workbook {
    private final List<Worksheet> worksheets = new ArrayList<>();

    public Workbook(){}

    public List<Worksheet> getWorksheets() {
        return worksheets;
    }

    public void save(String fileName) {

    }

}
