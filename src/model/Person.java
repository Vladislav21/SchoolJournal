package model;

public interface Person {

    String getFirstName();

    String getLastName();

    String getAttachmentToClassOrSubject();

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setAttachmentToClassOrSubject(String name);

    int getId();

}
