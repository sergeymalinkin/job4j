package stream.address;
<<<<<<< HEAD
import java.util.Objects;
/**
 * @author Sergey Malinkin (sloyz@ya.ru)
 * @version 1
 * @since 10.09.2019
 */
class Address {
<<<<<<< HEAD
    private final String city;
    private final String street;
    private final int home;
    private final int apartment;
=======
    Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  {
            return true;
        }
        if (o == null || getClass() != o.getClass())  {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }
    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", city, street, home, apartment);
    }
}
