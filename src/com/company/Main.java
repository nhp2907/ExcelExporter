package com.company;

import com.company.excelExporter.Column;
import com.company.excelExporter.ExcelExporter;
import com.company.model.ColumnAlignment;
import com.company.model.Person;
import com.company.model.Style;
import com.company.model.Workbook;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here

        ExcelExporter<Person> excelExporter = new ExcelExporter<>();

        Style normalStyle;
        Style headerStyle;

        Column<Person, Object> nameColumn = new Column<>("Name");
        nameColumn.setCellValueFactory(Person::getName);
        nameColumn.setStyle(new Style());
        nameColumn.setAlignment(ColumnAlignment.LEFT);
        nameColumn.setCellStyleFactory((row, colum, item) -> {
            if (item.getName().equals("Phuc")) {
                return null;
            } else {
                return new Style();
            }
        });

        Column<Person, Integer> ageColumn = new Column<>("Age",
                Person::getAge);
        excelExporter.getColumns().add(new Column<>("Address", Person::getAddress));
        excelExporter.getColumns().addAll(Arrays.asList(nameColumn, ageColumn));


        excelExporter.setCellStyleFactory((int row, int column, Person item) -> {
            if (row == 0) {
                headerStyle.setAlignment(excelExporter.getColumns().get(column).getAlignment());
                return headerStyle;
            } else {
                return normalStyle;
            }

        });
        Style borderStyle = null;
        int[] sides = {0, 1, 2, 3};
        excelExporter.setBorderStyle(sides, borderStyle);
        excelExporter.save("C:/User/nhp2907/Desktop/persons.xlsx");
    }


}

