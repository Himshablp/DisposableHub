package com.nexxen.identityService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "new_user_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetail implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Password is required")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @Builder.Default
    @Column(nullable = false)
    private boolean enabled = true;

    // Add role or authorities if needed
    @Column(nullable = false)
    @Builder.Default
    private String role = "ROLE_USER";

    // UserDetails interface methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> role);
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
}

