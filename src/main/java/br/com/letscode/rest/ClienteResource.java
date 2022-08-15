package br.com.letscode.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.com.letscode.dto.ClienteDto;
import br.com.letscode.form.ClienteForm;
import br.com.letscode.model.Cliente;
import br.com.letscode.service.ClienteService;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
@ApplicationScoped
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    @GET
    @Path( "/lista" )
    public List<ClienteDto> lista() {
        List<Cliente> clientes = clienteService.listaClientes();
        return ClienteDto.converter(clientes);
    }

    @POST
    public Response insertClient(@Valid ClienteForm clienteForm) {
        Cliente novoCliente = clienteForm.converter();
        clienteService.cadastraCliente(novoCliente);
        URI uri = UriBuilder.fromPath("/cliente/{id}").build(novoCliente.getId());
        return Response.created(uri).build();
    }

    @PUT
    @Path("/{id}")
    public Response alteraDados(@PathParam("id") Long id, @Valid @RequestBody ClienteForm clienteForm) {  
    Cliente cliente = clienteService.alteraDados(clienteForm, id);
    if (cliente != null) {
        return Response.status(Response.Status.OK).entity(new ClienteDto(cliente)).build();
    }
    return Response.status(Response.Status.NOT_FOUND).build();
    
    }
    // o clientForm é pra pegar no corpo da requisição e não da url
  
    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        Cliente cliente = clienteService.deletaCliente(id);
        if (cliente != null) {
            return Response.status(Response.Status.OK).entity(new ClienteDto(cliente)).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path( "/{id}" )
    public Cliente buscaPorId(@PathParam("id") Long id) {
        Cliente cliente = clienteService.buscaCliente(id);
        return cliente;
    }
    
}