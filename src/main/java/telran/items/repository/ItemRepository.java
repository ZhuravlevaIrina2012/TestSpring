package telran.items.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.items.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
