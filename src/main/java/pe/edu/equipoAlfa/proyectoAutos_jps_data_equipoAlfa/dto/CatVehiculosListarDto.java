package pe.edu.equipoAlfa.proyectoAutos_jps_data_equipoAlfa.dto;

public record CatVehiculosListarDto(
        Integer id_cat,
        String Marca,
        Boolean activo,
        String Tipo,
        String Descripcion
) {
}