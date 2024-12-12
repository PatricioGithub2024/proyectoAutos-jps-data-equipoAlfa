package pe.edu.equipoAlfa.proyectoAutos_jps_data_equipoAlfa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatVehiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cat;
    private String Marca;
    private String Tipo;
    private String Descripcion;


    @ToString.Exclude
    @OneToMany(mappedBy = "cat_vehiculos")
    private List<Vehiculos> vehiculos;

}
