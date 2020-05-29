package com.example.learnfromcodinginflow;

public class ItemExample {
    private int imageId;
    private String textone;
    private String textidtwo;

    public ItemExample(int imageId, String textone, String textidtwo) {
        this.imageId = imageId;
        this.textone = textone;
        this.textidtwo = textidtwo;
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
