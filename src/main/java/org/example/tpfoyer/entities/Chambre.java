package org.example.tpfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.tpfoyer.entities.Bloc;
import org.example.tpfoyer.entities.Reservation;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    long numeroChambre;

    @Enumerated(EnumType.STRING)
    TypeChambre typeChambre;

    @ManyToOne
    Bloc blocs;

    @OneToMany
            @JsonIgnore
    Set<Reservation> reservations=new HashSet<Reservation>();
}