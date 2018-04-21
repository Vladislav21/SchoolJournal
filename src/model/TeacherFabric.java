package model;

public class TeacherFabric implements PersonFabric {
    @Override
    public Person createPerson(int id, String firstName, String lastName, String attachmentToClassOrSubject) {
        return new Teacher(id, firstName, lastName, attachmentToClassOrSubject);
    }
}
