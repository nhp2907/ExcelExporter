package com.company.model;

public class Style {

    String font;
    int[] borders; // 0 1 2 3 - left top right bot
    int alignment;

    public Style(){

    }

    public Style(String font, int... borders){
        this.font = font;
        this.borders = borders;
    }

    public void setAlignment(ColumnAlignment alignment) {

    }
}


class Border {

}

class Color {

}