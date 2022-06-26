package com.example.springboot.day4assignment.AppTest;

import com.example.springboot.day4assignment.Entities.Spid;
import com.example.springboot.day4assignment.Entities.Status;
import com.example.springboot.day4assignment.Entities.User;
import com.example.springboot.day4assignment.Service.SpidService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SpidService.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SpidTest {

    @Mock
    SpidService spidService;

    @BeforeAll
    void setUp() {
        Spid spid = new Spid();
        User user = new User();
        user.setId(1);
        spid.setId(1);
        spid.setStatus(Status.PENDING);

        when(spidService.changeSpidStatus(spid)).thenReturn(spid);
        when(spidService.getSpidByUserId(user)).thenReturn(List.of(spid));
    }

    @Test
    public void testDabase() {
        Spid spid = new Spid();
        spid.setId(1);
        spid.setStatus(Status.READY_FOR_REVIEW);
        spid.setUser(new User());
        spid.getUser().setId(1);
        spid.getUser().setName("test");
        spid.getUser().setEmail("test@test.com");
        assertEquals(Status.READY_FOR_REVIEW, spid.getStatus());
    }

}
