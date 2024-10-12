package com.exampleCP2.diplomados.Security;



import com.exampleCP2.diplomados.Model.Diplomado;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private Diplomado diplomado;

    public CustomUserDetails(Diplomado diplomado) {
        this.diplomado = diplomado;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // Aqui você pode implementar as roles se precisar
    }

    @Override
    public String getPassword() {
        return diplomado.getPassword();
    }

    @Override
    public String getUsername() {
        return diplomado.getUsername();
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
