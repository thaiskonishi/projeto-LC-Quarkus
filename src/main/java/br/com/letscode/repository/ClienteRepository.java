package br.com.letscode.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.letscode.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    // public List<Cliente> findByid(Long id){
    // return list("id", id);
    // }

    // Nao precisa, pq o panache ja faz as querys
    public List<Cliente> nome(String nome) {
        return list("select c from Cliente c where c.nome = ?l", nome);// ?1 indica
        // que devolve o primeiro
    }

    public Cliente findByIdentificador(Long id) {
        return find("from Cliente where id = :id", Parameters.with("id",
                id)).firstResult();
    }

    // public Cliente deleteById(Long id) {
    // return delete("where id = :id", Parameters.with("id", id));
    // }
}
