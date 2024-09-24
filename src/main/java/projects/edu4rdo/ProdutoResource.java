package projects.edu4rdo;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/produtos")
@Transactional
public class ProdutoResource {

    @Inject
    EntityManager em;

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Produto> getProdutos() {
        return em.createQuery("select p from Produto p", Produto.class).getResultList();

    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public void addProduto(Produto produto) {
       em.persist(produto);

    }

}


