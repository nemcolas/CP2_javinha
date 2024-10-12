package com.exampleCP2.diplomados.Service;

import com.exampleCP2.diplomados.Model.Diplomado;
import com.exampleCP2.diplomados.Repository.DiplomadoRepository;
import com.exampleCP2.diplomados.Security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private DiplomadoRepository diplomadoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Diplomado diplomado = diplomadoRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Diplomado não encontrado: " + username));

        return new CustomUserDetails(diplomado);
    }
}