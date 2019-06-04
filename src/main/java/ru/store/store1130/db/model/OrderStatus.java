package ru.store.store1130.db.model;

public enum OrderStatus {
    INPROCESS("в обработке"),
    BOOKED("забронировано"),
    PAID("оплачено"),
    CLOSED("закрыто");

    private String text;

    OrderStatus (String text){
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
