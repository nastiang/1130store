package ru.store.store1130.db.model;

public enum OrderType {
    PURCHASED("покупка"),
    RETURNED("возврат");

    private String text;

    OrderType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
