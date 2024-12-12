package pe.edu.equipoAlfa.proyectoAutos_jps_data_equipoAlfa.service;

import pe.edu.equipoAlfa.proyectoAutos_jps_data_equipoAlfa.dto.*;

import java.util.List;

public interface MaintenanceService {

    List<ClientesListarDto> getAllClients();
    ClientesDetallesDto getClienteDetalleById(Integer id);
    void registrarCliente(ClientesRegistrarDto clientesRegistrarDto);

    // Para Editar / Atualizar
    ClientesEditarDto getClientesEditarById(int id);
    public void postClientesEditarById(int id, ClientesEditarDto clientesEditarDto);

    //para Borrar
    public void postClientesBorrarById(int id, ClientesBorrarDto clientesBorrarDto);

}
