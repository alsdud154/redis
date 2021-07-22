package kr.co.velnova.redis.repository;

import kr.co.velnova.redis.model.Name;
import kr.co.velnova.redis.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface NameRedisRepository extends CrudRepository<Name, String> {
    long countByName(String name);
}
