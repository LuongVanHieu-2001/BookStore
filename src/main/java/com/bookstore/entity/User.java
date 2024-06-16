package com.bookstore.entity;

import com.bookstore.validator.ValidUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "TEN DANG NHAP KHONG DUOC DE TRONG")
    @Size(max = 50, message = "Ten dang nhap phai it hon 50 ki tu")
    @ValidUsername
    private String username;

    @Column(name = "password", length = 250, nullable = false )
    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;

    @Column(name = "email", length = 50 )
    @Size(max = 50, message = "Email phai it hon 50 ki tu")
    private String email;

    @Column(name = "name", length = 50, nullable = false)
    @NotBlank(message = "TEN CUA BAN KHONG DUOC DE TRONG")
    @Size(max = 50, message = "Ten CUA BAN phai it hon 50 ki tu")
    private String name;

    @OneToMany(mappedBy = "user", cascade =  CascadeType.ALL)
    private List<Book> books;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name =  "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;





}