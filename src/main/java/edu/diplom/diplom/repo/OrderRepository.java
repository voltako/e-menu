package edu.diplom.diplom.repo;


import edu.diplom.diplom.models.Zakaz;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Zakaz,Long> {
}
