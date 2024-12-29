package tn.esprit.examen.stationSkiSpringBoot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long numInscription;
    int numSemaine;
    @ManyToOne
    @JsonIgnore
    private Skieur skieur;
    @ManyToOne
    @JsonIgnore
    private Cours cours;
}
