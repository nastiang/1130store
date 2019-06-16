package ru.store.store1130.db.model;

public enum SalesOrderStatus {
    INPROGRESS("в процессе"),
    SUBMITED("забронирован"),
    PAYED("оплачен"),
    CLOSED("закрыт"),
    DELETED("удален");

    private String text;

    SalesOrderStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
