package stream.address;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 10.09.2019
 */
public class ProfileTest {
    @Test
    public void whenListProfilesThenListAddresses() {
        Address client1 = new Address("Новгород", "Молодежная", 47, 12);
        Address client2 = new Address("Ярославль", "Угличская", 37, 32);
        Address client3 = new Address("Москва", "Широкая", 257, 3);
        Address client4 = new Address("Москва", "Широкая", 257, 3);
        Address client5 = new Address("Ярославль", "Угличская", 37, 32);
        List<Profile> profiles = List.of(
                new Profile(client1),
                new Profile(client2),
                new Profile(client3),
                new Profile(client4),
                new Profile(client5));
        List<Address> expected = new Profile().collect(profiles);
        List<Address> result = List.of(
                client3,
                client1,
                client2);
        assertThat(result, is(expected));
    }
}