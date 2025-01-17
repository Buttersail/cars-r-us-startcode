package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @BeforeEach
    void setUp() {

        memberRepository.save(new Member("xxx", "xxx@abc.dk", "test123", "xxx", "yyy", "xxx 123", "xxxbro", "1234"));
        memberRepository.save(new Member("zzz", "zzz@abc.dk", "test123", "zzz", "xxx", "zzz 123", "zzzbro", "1234"));
    }

    @Test
    public void testCount() {
        assertEquals(2, memberRepository.count());
    }
}