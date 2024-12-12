package pe.edu.equipoAlfa.proyectoAutos_jps_data_equipoAlfa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_vehi;
    private String nombre;
    private String detalles;
    private Date fecha_registro;
    private Integer stock;
    private Double precio;
    private Date last_update;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_cat")
    private CatVehiculos cat_vehiculos;

}
