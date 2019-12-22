package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private int age;
    private String car;
    private String work;
    public User() {
    }

    public User(String name, String surname, String patronymic, int age) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
    }

    public User(long id, String name, String surname, String patronymic, int age) {
        this(name, surname, patronymic, age);
        this.id = id;
    }

    public User(long id, String car, String work, String name, String surname, String patronymic, int age) {
        this(id, name, surname, patronymic, age);
        this.car = car;
        this.work = work;
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

    public void setCar(String car) {
        this.car = car;
    }

    public String getWork() {
        return work;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                name.equals(user.name) &&
                surname.equals(user.surname) &&
                patronymic.equals(user.patronymic) &&
                Objects.equals(car, user.car) &&
                Objects.equals(work, user.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, age, car, work);
    }
}
