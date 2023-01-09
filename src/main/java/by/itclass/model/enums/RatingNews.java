package by.itclass.model.enums;

import by.itclass.constants.AppConstant;

public enum RatingNews {
    UPP(AppConstant.UPP_RATING_VALUE),DOWN(AppConstant.DOWN_RATING_VALUE);

    private int value;

    RatingNews(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
