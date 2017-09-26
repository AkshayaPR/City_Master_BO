package kgfsl.stalk.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.State;

@Repository
public interface StateRepository extends Base4EyeRepository<State, String> {

	State findByCode(String code);

	List<State> findByCodeIn(List<String> code);

}
