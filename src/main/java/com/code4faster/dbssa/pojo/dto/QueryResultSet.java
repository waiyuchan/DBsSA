package com.code4faster.dbssa.pojo.dto;

import java.util.List;

public class QueryResultSet {
    Integer total;
    List<?> queryResult;

    public Integer getTotal() {
        return total;
    }

    public QueryResultSet(Integer total, List<?> queryResult) {
        this.total = total;
        this.queryResult = queryResult;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(List<?> queryResult) {
        this.queryResult = queryResult;
    }
}
