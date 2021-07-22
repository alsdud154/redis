package kr.co.velnova.redis.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@ToString
@Getter
@RedisHash("name")
public class Name {
    @Id
    String id;
    String name;

    @Builder
    public Name(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
