package ru.store.store1130.db.model;

public enum OrderType {
<<<<<<< HEAD
    PURCHASED("покупка"),
    RETURNED("возврат");
=======
    PURCHASED("Покупка"),
    RETURNED("Возврат");
>>>>>>> ec464703dd103f1c910233be4690ebd74c3a9bba

    private String text;

    OrderType(String text) {
        this.text = text;
    }

    public String getText() {
<<<<<<< HEAD
        return this.text;
=======
        return text;
>>>>>>> ec464703dd103f1c910233be4690ebd74c3a9bba
    }
}
