package main.java.common.enums;

import lombok.Getter;

@Getter
public enum GroupType {
    POPULAR_GROUP("popular_group"),
    YOUR_GROUP("your_group"),
    MANAGING_GROUP("managing_group"),
    ALL("all"),
    JOINING_GROUP("joining_group"),
    INVITED_GROUP("invited_group"),
    PENDING_GROUP("pending_group"),
    OTHER("other");

    private String value;

    GroupType(String value) {
        this.value = value;
    }
}
