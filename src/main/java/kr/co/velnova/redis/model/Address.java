package kr.co.velnova.redis.model;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }
}