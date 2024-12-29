package tn.esprit.examen.stationSkiSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Piste implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long numPiste;
    String nomPiste;
    int longueur;
    int pente;
    @Enumerated(EnumType.STRING)
    Couleur Couleur;
    @ManyToMany(mappedBy = "pistes" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Skieur> skieurs ;
}
