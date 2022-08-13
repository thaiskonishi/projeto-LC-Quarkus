package br.com.letscode.model;

import br.com.letscode.model.ClienteRepository;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@Path("/cliente/lista")
@RegisterRestClient(configKey = "quarkus-api")
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

}
