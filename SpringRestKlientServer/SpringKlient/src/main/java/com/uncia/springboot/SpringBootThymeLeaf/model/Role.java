package com.uncia.springboot.SpringBootThymeLeaf.model;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.core.GrantedAuthority;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@JsonAutoDetect
@JsonIgnoreProperties({"authority"})
public class Role implements GrantedAuthority {

    @JsonView
    private Integer id;
    @JsonView
    private String role;

    @JsonIgnore
    private Set<User> users = new HashSet<>();

    public Role() {
    }
    public Role(String roleName) {
        this.role = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if (users == null) {
            users = new HashSet<>();
        }
        users.add(user);
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return id.equals(role1.id) &&
                role.equals(role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
