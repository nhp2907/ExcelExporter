package com.company.model;

public class Worksheet {
    Cell[][] cells;


    public Cell getCells(int row, int column){
        return cells[row][column];
    }
}

