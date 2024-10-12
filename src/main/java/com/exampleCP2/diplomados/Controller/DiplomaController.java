package com.exampleCP2.diplomados.Controller;

import com.exampleCP2.diplomados.Repository.DiplomaRepository;
import com.exampleCP2.diplomados.Model.Diploma;
import com.exampleCP2.diplomados.DTO.DiplomaDTO;
import com.exampleCP2.diplomados.Model.Sexo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/diploma")
public class DiplomaController {

    @Autowired
    private DiplomaRepository diplomaRepository;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<String> getDiploma(@PathVariable UUID id) {
        Diploma diploma = diplomaRepository.findById(id).orElseThrow(() -> new RuntimeException("Diploma não encontrado"));

        DiplomaDTO dto = new DiplomaDTO();

        dto.setNomeDiplomado(diploma.getDiplomado().getNome());
        dto.setNacionalidade(diploma.getDiplomado().getNacionalidade());
        dto.setNaturalidade(diploma.getDiplomado().getNaturalidade());
        dto.setRg(diploma.getDiplomado().getRg());
        dto.setTipoCurso(diploma.getCurso().getTipo().name());
        dto.setNomeCurso(diploma.getCurso().getNome());
        dto.setDataConclusao(diploma.getDataConclusao());
        dto.setTituloReitor("Prof. Dr. " + diploma.getNomeReitor());
        dto.setCargoReitor(diploma.getSexoReitor() == Sexo.M ? "reitor" : "reitora");

        String textoDiploma = String.format(
                "O %s, %s da Universidade Javinha Legal, no uso de suas atribuições, confere a %s, de nacionalidade %s, natural de %s, portador do rg %s, o presente diploma de %s, do curso de %s, por ter concluído seus estudos nesta instituição de ensino no dia %s.",
                dto.getTituloReitor(), dto.getCargoReitor(), dto.getNomeDiplomado(), dto.getNacionalidade(),
                dto.getNaturalidade(), dto.getRg(), dto.getTipoCurso(), dto.getNomeCurso(),
                dto.getDataConclusao().toString()
        );

        return ResponseEntity.ok(textoDiploma);
    }
}