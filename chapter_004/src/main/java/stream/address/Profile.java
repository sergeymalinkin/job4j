package stream.address;

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

    Address getAddress() {
        return address;
    }
}

