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

    public User(long id, String name, String surname, String patronymic, int age) {
        this.id = id;
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

    public String getCar() {
        return car;
    }

    public String getWork() {
        return work;
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
