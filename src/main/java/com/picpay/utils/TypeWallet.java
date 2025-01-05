package com.picpay.utils;

public enum TypeWallet {
    CONSUMER(1), MERCHANT(2);

    private int value;

    private TypeWallet(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
