package com.company.excelExporter;

import com.company.model.Style;

public interface CellStyleFactory<T> {
    Style createStyle(int row, int colum, T item);
}
