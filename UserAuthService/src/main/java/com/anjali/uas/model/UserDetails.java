package com.anjali.uas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {
    @Id
    private String userId;
    private String userName;
    private String pw;
//    @Enumerated(EnumType.STRING)
    private String role;
    private String userNIC;
    private String userAddress;
    private String userDOB;
    private String userPhone;
    private String userEmail;
    private String gender;
    private String userNICimageLocation;
    private String userImageLocation;
    private boolean isValidated;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return pw;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
