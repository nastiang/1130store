package ru.store.store1130.db.model;

public enum OrderType {
    PURCHASED("Покупка"),
    RETURNED("Возврат");

    private String text;

    OrderType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
