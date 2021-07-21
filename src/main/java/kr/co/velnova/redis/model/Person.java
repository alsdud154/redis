package kr.co.velnova.redis.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@ToString
@Getter
@RedisHash("people")
public class Person {
    @Id
    String id;
    String firstname;
    String lastname;
    Address address;

    @Builder
    public Person(String id, String firstname, String lastname, Address address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }
}
