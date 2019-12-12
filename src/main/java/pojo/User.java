package pojo;

import javax.persistence.*;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long idUser;

    private String name;
    private String login;
    private int age;
    private String email;
    private String password;



}
