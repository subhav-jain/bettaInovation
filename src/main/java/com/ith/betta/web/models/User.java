package com.ith.betta.web.models;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Authorities> authorities = new HashSet<>();

    private Set<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authorities> getAuthorities() {
        return authorities;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "authority", joinColumns = {@JoinColumn(name = "username")}, inverseJoinColumns = {@JoinColumn(name = "username")})
    private void setRole() {
        this.roles = roles;
    }

}
