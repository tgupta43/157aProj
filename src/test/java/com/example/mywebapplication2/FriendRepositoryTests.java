package com.example.mywebapplication2;

import com.example.mywebapplication2.consumers.Consumer;
import com.example.mywebapplication2.consumers.Friend;
import com.example.mywebapplication2.consumers.FriendRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class FriendRepositoryTests {
    @Autowired private FriendRepository repo;

    @Test
    public void testAddNewFriend() {
        Friend friend = new Friend();
        friend.setId(12345);
        friend.setConsumer_id(1234);

        Friend savedFriend  = repo.save(friend);
        Assertions.assertThat(savedFriend).isNotNull();
        Assertions.assertThat(savedFriend.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAll(){
        Iterable<Friend> friends = repo.findAll();
        Assertions.assertThat(friends).hasSizeGreaterThan(0);
        for (Friend friend:friends) {
            System.out.println(friend);
        }
    }
}
