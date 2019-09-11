package stream.address;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 10.09.2019
 */
class Profile {
    private Address address;

    Profile(Address address) {
        this.address = address;
    }

    Profile() {
    }

    Address getAddress() {
        return address;
    }

    List<Address> collect(List<Profile> profiles) {
        Comparator<Address> comparator = Comparator.comparing(Address::getCity);
        return profiles.stream().map(Profile::getAddress).distinct().sorted(comparator).collect(Collectors.toList());
    }
}

