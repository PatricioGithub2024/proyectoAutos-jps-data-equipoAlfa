package pe.edu.equipoAlfa.proyectoAutos_jps_data_equipoAlfa.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import pe.edu.equipoAlfa.proyectoAutos_jps_data_equipoAlfa.dto.ClientesDetallesDto;
import pe.edu.equipoAlfa.proyectoAutos_jps_data_equipoAlfa.dto.*;
import pe.edu.equipoAlfa.proyectoAutos_jps_data_equipoAlfa.entity.Clientes;
import pe.edu.equipoAlfa.proyectoAutos_jps_data_equipoAlfa.repository.ClienteRepository;
import pe.edu.equipoAlfa.proyectoAutos_jps_data_equipoAlfa.service.MaintenanceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClientesListarDto> getAllClients() {
        List<ClientesListarDto> clients = new ArrayList<>();
        Iterable<Clientes> iterable = clienteRepository.findAll();
        iterable.forEach(cliente -> {
            ClientesListarDto clientesListar = new ClientesListarDto(
                    cliente.getIdUsuario(),
                    cliente.getNombre(),
                    cliente.getApellidos(),
                    cliente.getDireccion(),
                    cliente.getCorreo(),
                    cliente.getTelefono(),
                    cliente.getFechaRegistro()
            );
            clients.add(clientesListar);
        });
        return clients;
    }

    @Override
    public ClientesDetallesDto getClienteDetalleById(Integer id) {

        Optional<Clientes> optional = clienteRepository.findById(id);
        return optional.map(cliente -> new ClientesDetallesDto(
                cliente.getIdUsuario(),
                cliente.getCorreo(),
                cliente.getUsername(),
                cliente.getNombre(),
                cliente.getApellidos(),
                cliente.getContrasenia(),
                cliente.getTelefono(),
                cliente.getDireccion(),
                cliente.getFechaRegistro()
        )).orElse(null);
    }

    @Override
    public void registrarCliente(ClientesRegistrarDto clientesRegistrarDto) {

        Clientes cliente = new Clientes();
        cliente.setCorreo(clientesRegistrarDto.correo());
        cliente.setUsername(clientesRegistrarDto.username());
        cliente.setNombre(clientesRegistrarDto.nombre());
        cliente.setApellidos(clientesRegistrarDto.apellidos());
        cliente.setContrasenia(clientesRegistrarDto.contrasenia());
        cliente.setTelefono(clientesRegistrarDto.telefono());
        cliente.setDireccion(clientesRegistrarDto.direccion());
        clienteRepository.save(cliente);

    }

    @Override
    public ClientesEditarDto getClientesEditarById(int id) {
        Optional<Clientes> optional = clienteRepository.findById(id);

        return optional.map(
                clientes -> new ClientesEditarDto(
                        clientes.getIdUsuario(),
                        clientes.getCorreo(),
                        clientes.getUsername(),
                        clientes.getNombre(),
                        clientes.getApellidos(),
                        clientes.getContrasenia(),
                        clientes.getTelefono(),
                        clientes.getDireccion(),
                        clientes.getFechaRegistro())

        ).orElse(null);

    }

    @Override
    public void postClientesEditarById(int id, ClientesEditarDto clientesEditarDto) {

        // Buscar por Id
        Clientes clientes = clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("cliente no encontrado"));

        // Actualizar
        clientes.setCorreo(clientesEditarDto.correo());
        clientes.setUsername(clientesEditarDto.username());
        clientes.setNombre(clientesEditarDto.nombre());
        clientes.setApellidos(clientesEditarDto.apellidos());
        clientes.setContrasenia(clientesEditarDto.contrasenia());
        clientes.setTelefono(clientesEditarDto.telefono());
        clientes.setDireccion(clientesEditarDto.direccion());
        clientes.setFechaRegistro(new Date());

        // Guardar en DB
        clienteRepository.save(clientes);

    }

    @Override
    public void postClientesBorrarById(int id, ClientesBorrarDto clientesBorrarDto) {

        Optional<Clientes> optional = clienteRepository.findById(id);

        Clientes client = optional.orElseThrow(() -> new EntityNotFoundException("Cliente no existente"));

        clienteRepository.delete(client);

    }

//    @Override
//    public ClientesDetallesDto getClientById(Integer id) {
//        Optional<Clientes> optional = clienteRepository.findById(id);
//        return optional.map(cliente -> new ClientesDetallesDto(
//                cliente.getUsername(),
//                cliente.getContrasenia()
//        )).orElse(null);
//    }

}
