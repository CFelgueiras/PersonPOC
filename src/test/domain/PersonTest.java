package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setId() {
        Person p1 = new Person();
        p1.setId(50L);
        Long id = 50L;
        assertEquals(id, p1.getId());
    }

    @Test
    public void incorrectId() {
        Person p1 = new Person();
        assertThrows(IllegalArgumentException.class, () -> {
            p1.setId(-10L);
        });
    }

    @Test
    void setNullName() {
        Person p1 = new Person();
        assertThrows(NullPointerException.class, () -> {
            p1.setName(null);
        });
    }

    @Test
    void setName() {
        Person p1 = new Person();
        p1.setName("Claudio");
        String name = "Claudio";
        assertEquals(name, p1.getName());
    }

    @Test
    void setAge() {
        Person p1 = new Person();
        p1.setAge(20);
        int age = 20;
        assertEquals(age, p1.getAge());
    }
    @Test
    void setWrongAge() {
        Person p1 = new Person();
        assertThrows(IllegalArgumentException.class, () -> {
            p1.setAge(-15);
        });
    }
}
