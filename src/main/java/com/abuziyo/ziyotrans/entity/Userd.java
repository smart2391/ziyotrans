//package com.abuziyo.ziyotrans.entity;
//
//import com.sun.istack.NotNull;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Set;
//
//@Entity
//@Table(name = "clean_user")
//public class Userd implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private Long id;
//    @NotNull
//    private String userName;
//    private String password;
//    private String email;
//
//    @ManyToMany
//    @JoinTable(
//            name = "user_role",
//            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id") },
//            inverseJoinColumns = {@JoinColumn(name = "role_name",referencedColumnName = "name") }
//    )
//    private Set<Roled> roles;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Set<Roled> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Roled> roles) {
//        this.roles = roles;
//    }
//}
