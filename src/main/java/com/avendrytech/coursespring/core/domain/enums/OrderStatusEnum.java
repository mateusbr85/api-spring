package com.avendrytech.coursespring.core.domain.enums;

public enum OrderStatusEnum {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final int code;

    OrderStatusEnum(int code) {
      this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatusEnum fromCode(int code) {
        for(OrderStatusEnum status : OrderStatusEnum.values()) {
            if(status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("invalid code: " + code);
    }
}
