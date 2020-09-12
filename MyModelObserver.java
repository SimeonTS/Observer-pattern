import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class MyModelObserver{
    public final String FIRSTNAME = "firstName";
    public static final String LASTNAME = "lastName";

    private final List<Person> persons = new ArrayList<Person>();
    private final List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();

    public class Person {

        private String firstName;

        private String lastName;

        public Person(final String firstName, final String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {

            return firstName;
        }

        public void setFirstName(final String firstName) {
            notifyListeners(this, FIRSTNAME, this.firstName, this.firstName = firstName);

        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(final String lastName) {
            notifyListeners(this, LASTNAME, this.lastName, this.lastName = lastName);
        }
    }

    public List<Person> getPersons() {
        return persons;
    }

    public MyModelObserver() {
        // За тестване:
        persons.add(new Person("Lars", "Vogel"));
        persons.add(new Person("Jim", "Knopf"));
    }

    private void notifyListeners(final Object object, final String property, final String oldValue,
            final String newValue) {
        for (final PropertyChangeListener name : listener) {
            name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
        }
    }

    public void addChangeListener(final PropertyChangeListener newListener) {
        listener.add(newListener);
    }

}