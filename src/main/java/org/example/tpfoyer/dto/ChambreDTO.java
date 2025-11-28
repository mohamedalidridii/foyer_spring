package org.example.tpfoyer.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.tpfoyer.entities.TypeChambre;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChambreDTO {
     long id;
     long numeroChambre;
     TypeChambre typeChambre;

}
