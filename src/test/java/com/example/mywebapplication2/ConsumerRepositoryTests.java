package com.example.mywebapplication2;

import com.example.mywebapplication2.consumers.Consumer;
import com.example.mywebapplication2.consumers.ConsumerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class ConsumerRepositoryTests {
    @Autowired private ConsumerRepository repo;

    @Test
    public void testAddNew() {
        Consumer consumer = new Consumer();
        consumer.setC_email("kyle.email@email.com");
        consumer.setC_pw("password");
        consumer.setFirst_name("kyle");
        consumer.setId(10);
        consumer.setPerformer_id(1);

//        Consumer savedConsumer = repo.save(consumer);
        Consumer savedConsumer = repo.save(consumer);


        Assertions.assertThat(savedConsumer).isNotNull();
        Assertions.assertThat(savedConsumer.getId()).isGreaterThan(0);

    }
    @Test
    public void testListAll(){
        Iterable<Consumer> consumers = repo.findAll();
        Assertions.assertThat(consumers).hasSizeGreaterThan(0);
        for (Consumer consumer:consumers) {
            System.out.println(consumer);
        }
    }

    @Test
    public void testUpdate(){
        Integer consumerId = 1;
        Optional<Consumer> optionalConsumer = repo.findById(consumerId);
        Consumer consumer = optionalConsumer.get();
        consumer.setC_pw("test");
        repo.save(consumer);

        Consumer updatedConsumer = repo.findById(consumerId).get();
        Assertions.assertThat(updatedConsumer.getC_pw()).isEqualTo("test");

    }

    @Test
    public void testGet(){
        Integer consumerId = 933661;
        Optional<Consumer> optionalConsumer = repo.findById(consumerId);
        Assertions.assertThat(optionalConsumer).isPresent();
    }
    @Test
    public void testDelete(){
        Integer consumerId = 933661;
        repo.deleteById(consumerId);

        Optional<Consumer> optionalConsumer = repo.findById(consumerId);
        Assertions.assertThat(optionalConsumer).isNotPresent();
    }

}
