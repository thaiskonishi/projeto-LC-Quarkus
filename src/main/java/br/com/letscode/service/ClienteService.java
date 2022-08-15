package br.com.letscode.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.letscode.form.ClienteForm;
import br.com.letscode.model.Cliente;
import br.com.letscode.repository.ClienteRepository;

@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> listaClientes() {
        return clienteRepository.listAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void cadastraCliente(Cliente cliente) {
        clienteRepository.persist(cliente);
    }

    @PUT
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente alteraDados(ClienteForm clienteForm, Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findByIdOptional(id);
        if (clienteOptional.isPresent()) {
            clienteOptional.get().setNome(clienteForm.getNome());
            clienteOptional.get().setEmail(clienteForm.getEmail());
            clienteOptional.get().setIdade(clienteForm.getIdade());
            clienteOptional.get().setVatnumber(clienteForm.getVatnumber());
            clienteOptional.get().setIdcategoria(clienteForm.getIdCategoria());
            return clienteOptional.get();
        }
        return null;
    }

    @DELETE
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Cliente deletaCliente(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findByIdOptional(id);
        if (clienteOptional.isPresent()) {
            clienteRepository.deleteById(id);
            return clienteOptional.get();
        }
        return null;

    }

}
