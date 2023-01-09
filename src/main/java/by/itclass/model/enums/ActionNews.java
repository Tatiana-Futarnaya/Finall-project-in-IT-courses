package by.itclass.model.enums;

import by.itclass.model.db.jdbc.SQLRequest;

public enum ActionNews {
    ADD(SQLRequest.INSERT_NEWS),
    EDIT(SQLRequest.UPDATE_NEWS);

    private String sql;

    ActionNews(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }
}
