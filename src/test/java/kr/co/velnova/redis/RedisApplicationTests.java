package kr.co.velnova.redis;

import kr.co.velnova.redis.model.Address;
import kr.co.velnova.redis.model.Person;
import kr.co.velnova.redis.repository.PersonRedisRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private PersonRedisRepository redisRepository;

    @Test
    public void basicSave() {
        // given
        Address address = new Address("서울특별시 서울시청");
        Person person = new Person(null, "first", "last", address);

        // when
        Person savedPerson = redisRepository.save(person);

        // then
        Optional<Person> findPerson = redisRepository.findById(savedPerson.getId());



        redisRepository.findAll()
                .forEach(System.out::println);



        assertThat(findPerson.isPresent()).isEqualTo(Boolean.TRUE);
        assertThat(findPerson.get().getFirstname()).isEqualTo(person.getFirstname());
    }

}
