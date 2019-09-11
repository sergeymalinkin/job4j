package stream.address;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 10.09.2019
 */
class Company {
    /**
     * @param profiles profile.
     * @return stream.
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}
