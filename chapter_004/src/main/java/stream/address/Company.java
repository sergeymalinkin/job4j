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
        return profiles.stream().map(this::getAddress).collect(Collectors.toList());
    }

    /**
     * @param profile profile.
     * @return address
     */
    private Address getAddress(Profile profile) {
        return new Address(
                profile.getAddress().getCity(),
                profile.getAddress().getStreet(),
                profile.getAddress().getHome(),
                profile.getAddress().getApartment());
    }
}
