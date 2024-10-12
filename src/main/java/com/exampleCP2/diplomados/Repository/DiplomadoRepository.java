package com.exampleCP2.diplomados.Repository;


import com.example.demo.model.Diplomado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiplomadoRepository extends JpaRepository<Diplomado, Long> {

    Optional<Diplomado> findByUsername(String username);

    boolean existsByUsername(String username);
}
