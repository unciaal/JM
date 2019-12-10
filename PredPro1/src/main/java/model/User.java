package model;

public class User {
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private int age;
    private String car;
    private String work;

    public User(String name, String surname, String patronymic, int age) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", car='" + car + '\'' +
                ", work='" + work + '\'' +
                '}';
    }
}
