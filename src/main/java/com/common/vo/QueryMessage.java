package com.common.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 用于Controller层和Business进行数据交互
 */
public class QueryMessage {

    @Getter @Setter private String queryCode;

    @Getter @Setter private String resultMessage;

    @Getter @Setter private Object queryObject;

    public QueryMessage(){

    }

    public QueryMessage(String queryCode, String resultMessage) {
        this.queryCode = queryCode;
        this.resultMessage = resultMessage;
    }

    public QueryMessage(String queryCode, String resultMessage, Object queryObject) {
        this.queryCode = queryCode;
        this.resultMessage = resultMessage;
        this.queryObject = queryObject;
    }
}
