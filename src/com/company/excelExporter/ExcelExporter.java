package com.company.excelExporter;

import com.company.model.Person;
import com.company.model.Style;
import com.company.model.Workbook;
import com.company.model.Worksheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelExporter<T> {

    private final Worksheet sheet = new Worksheet();
    private final List<Column<T, ? extends Object>> columns = new ArrayList<>();
    private List<T> items = new ArrayList<>();
    private CellStyleFactory<T> cellStyleFactory;
    public ExcelExporter() {
    }

    public void setCellStyleFactory(CellStyleFactory<T> cellStyleFactory) {
        this.cellStyleFactory = cellStyleFactory;
    }

    public void setColumns(Column<T, Object>... columns) {
        this.columns.addAll(Arrays.asList(columns));
    }

    public List<Column<T, ?>> getColumns() {
        return columns;
    }

    public void save(String fileName) {
        // write header

        for (int i = 0; i < columns.size(); i++) {
            sheet.getCells(0, i).setValue(columns.get(i).getHeader());
        }


        // write data to workbook
        int rowIndex = 1;
        for (T item : items) {
            for (int i = 0; i < columns.size(); i++) {
                sheet.getCells(rowIndex, i).setValue(columns.get(i).getCellValueFactory().apply(item));
                if (cellStyleFactory != null) {
                    sheet.getCells(rowIndex, i).setStyle(cellStyleFactory.createStyle(rowIndex, i, item));
                }
            }
            rowIndex++;
        }

        // format with style
        for (int columnIndex = 0; columnIndex < columns.size(); columnIndex++) {
            var  column = columns.get(columnIndex);
            if (column.getStyle() != null) {
                for (int i = 1; i <= items.size(); i++) {
                    sheet.getCells(rowIndex, columnIndex).setStyle(column.getStyle());
                }
            }
        }

    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setStyle(int rowIndex, Style style) {
        // for cell in row.getCells();
        //     cell.setStyle(Style);
    }

    public void setStyle(int row, int column, Style style) {
        sheet.getCells(row, column).setStyle(style);
    }


    public void setBorderStyle(int[] sides, Style borderStyle) {
    }
}
