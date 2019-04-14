package ru.elena.testwork.dao;

import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.elena.testwork.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testDeleteAll() {
        User user = new User(0, "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
        entityManager.persist(user);
        userRepository.deleteAll();
        User reuser = userRepository.findById(1L).orElse(null);
        assertEquals(null, reuser);
    }

    @Test
    public void testSave() {
        User user = new User(0, "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
        User u = entityManager.persist(user);
        User reuser = userRepository.findById(u.getId()).orElse(null);
        assertEquals(u, reuser);

    }

    @Test
    public void testFindAll() {
        userRepository.deleteAll();
        User user = user = new User(0, "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
        User u = entityManager.persist(user);
        List<User> users = (List<User>) userRepository.findAll();
        User reuser = users.get(0);
        assertEquals(u, reuser);

    }
}
