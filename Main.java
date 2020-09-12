

public class Main {

    public static void main(String[] args) {
        MyModelObserver model = new MyModelObserver();
        MyObserver observer = new MyObserver(model);
        // сменяме името
        for (MyModelObserver.Person person : model.getPersons()) {
            person.setLastName(person.getLastName() + "1");
        }
        
        for (MyModelObserver.Person person : model.getPersons()) {
            person.setFirstName(person.getFirstName() + "1");
        }
    }
}