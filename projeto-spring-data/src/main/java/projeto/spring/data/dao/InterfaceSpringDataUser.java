package projeto.spring.data.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import projeto.spring.data.model.UsuarioSpringData;

import java.util.List;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long> {

    @Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
    public List<UsuarioSpringData> buscaPorNome(String nome);

    @Query(value = "select p from UsuarioSpringData p where p.nome = :paramnome")
    public UsuarioSpringData buscaPorNomeParam(@Param("paramnome") String paramnome);

    @Modifying
    @Transactional
    @Query("delete from UsuarioSpringData u where u.nome = ?1")
    public void deletePorNome(String nome);
}



