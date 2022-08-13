package br.com.letscode.model;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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
    public Response insertClient(ClienteForm cliente) {
        Cliente novoCliente = cliente.converter();
        clienteService.cadastraCliente(novoCliente);
        URI uri = UriBuilder.fromPath("/client/details/{id}").build(novoCliente.getId());
        return Response.created(uri).build();
    }

    // @PUT("/{id}")
    // public void alteraDados(@PathVariable Long id, @RequestBody ClienteForm form)
    // {
    // Optional<Cliente> optional = Cliente.findByIdentificador(id);
    // if(optional.isPresent()){
    // Cliente cliente = form.alterarDados(id, clienteRepository);

    // }

    // o clientForm é pra pegar no corpo da requisição e não da url

    // @POST(" ")
    // public Cliente cadastrar(String vatnumber,String nome,String email,int idade)
    // {
    // Cliente entity = new Cliente();
    // entity.setNome(nome);
    // entity.setIdade(idade);
    // entity.setVatnumber(vatnumber);
    // entity.setEmail(email);
    // clienteRepository.persist(entity);

    // }

    // @DELETE
    // @Path("/{id}")
    // public void deletar(@PathParam Long id) {
    //     clienteRepository.deleteById(id);
    // }

}