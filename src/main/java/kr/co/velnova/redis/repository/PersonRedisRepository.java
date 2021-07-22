package kr.co.velnova.redis.repository;

import kr.co.velnova.redis.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRedisRepository extends CrudRepository<Person, String> {
    long countPeopleByFirstname(String firstname);
}
