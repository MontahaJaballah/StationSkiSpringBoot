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
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long numCours;
    int niveau;
    Float prix;
    int Creneau;
    @Enumerated(EnumType.STRING)
    TypeCours typeCours;
    @Enumerated(EnumType.STRING)
    Support support;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "cours",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Inscription> inscriptions;}
