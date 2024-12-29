package tn.esprit.examen.stationSkiSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long numSkieur;
    String nomS;
    String prenomS;
    LocalDate dateNaissance;
    String ville;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Piste> pistes;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "skieur",fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Inscription> inscriptions;
    @OneToOne(cascade =CascadeType.ALL)
    private Abonnement abonnement;

}
