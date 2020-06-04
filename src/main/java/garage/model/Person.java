package garage.model;

import garage.util.LocalDateAdapter;
import javafx.beans.property.*;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * Model class for a Person.
 */
public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty garageNumber;
    private final StringProperty phone;
    private final ObjectProperty<LocalDate> birthday;
    private final ObjectProperty<LocalDate> paymentDate;

    public Person() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param firstName - first name
     * @param lastName - last name
     */
    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.garageNumber = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
        this.birthday = new SimpleObjectProperty<>();

        this.paymentDate = new SimpleObjectProperty<>(LocalDate.now());
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }


    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }


    public String getGarageNumber() {
        return garageNumber.get();
    }

    public void setGarageNumber(String garageNumber) {
        this.garageNumber.set(garageNumber);
    }

    public StringProperty garageNumberProperty() {
        return garageNumber;
    }


    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }


    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate paymentDate) {
        this.birthday.set(paymentDate);
    }


    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getPaymentDate() {
        return paymentDate.getValue();
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate.set(paymentDate);
    }

}