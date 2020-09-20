package com.company.excelExporter;

import com.company.model.ColumnAlignment;
import com.company.model.Person;
import com.company.model.Style;

import java.util.function.Function;

public class  Column<T, R> {
    private Function<T,R> cellValueFactory;
    private String header;
    private Style style;
    private ColumnAlignment alignment;
    public Column(String header){
        this.header = header;
    }

    private CellStyleFactory<T> cellStyleFactory;


    public Column(String header, Function<T,R> cellValueFactory){
        this.header = header;
        this.cellValueFactory = cellValueFactory;
    }

    public void setAlignment(ColumnAlignment alignment) {
        this.alignment = alignment;
    }

    public ColumnAlignment getAlignment() {
        return alignment;
    }

    public CellStyleFactory<T> getCellStyleFactory() {
        return cellStyleFactory;
    }

    public void setCellStyleFactory(CellStyleFactory<T> cellStyleFactory) {
        this.cellStyleFactory = cellStyleFactory;
    }

    public void setCellValueFactory(Function<T,R> cellValueFactory) {
        this.cellValueFactory = cellValueFactory;
    }

    Function<T, R> getCellValueFactory() {
        return cellValueFactory;
    }

    public String getHeader() {
        return header;
    }


    public void setStyle(Style style) {
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }
}
