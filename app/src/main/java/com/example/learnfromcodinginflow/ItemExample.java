package com.example.learnfromcodinginflow;

public class ItemExample {
    private int imageId;
    private String textone;
    private String textidtwo;

    public ItemExample(int mimageId, String text1, String text2) {
        imageId = mimageId;
        textone = text1;
        textidtwo = text2;
    }
    public void changeText(String text){
        textone=text;
    }


    public int getImageId() {
        return imageId;
    }

    public String getTextone() {
        return textone;
    }

    public String getTextidtwo() {
        return textidtwo;
    }
}
