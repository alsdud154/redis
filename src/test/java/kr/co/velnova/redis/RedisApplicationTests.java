package kr.co.velnova.redis;

import kr.co.velnova.redis.model.Address;
import kr.co.velnova.redis.model.Name;
import kr.co.velnova.redis.model.Person;
import kr.co.velnova.redis.repository.NameRedisRepository;
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

    @Autowired
    private NameRedisRepository nameRedisRepository;

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


        long count = redisRepository.count();

        System.out.println("count = " + count);


        assertThat(findPerson.isPresent()).isEqualTo(Boolean.TRUE);
        assertThat(findPerson.get().getFirstname()).isEqualTo(person.getFirstname());


        Name name = new Name(null, "name");

        nameRedisRepository.save(name);

        nameRedisRepository.findAll()
                        .forEach(System.out::println);

        long count1 = nameRedisRepository.count();
        System.out.println("count1 = " + count1);

    }

}
