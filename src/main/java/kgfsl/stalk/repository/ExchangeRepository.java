package kgfsl.stalk.repository;

import org.springframework.stereotype.Repository;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.Exchange;

@Repository
public interface ExchangeRepository extends Base4EyeRepository<Exchange, String> {

	public Exchange findByCode(String code);

	public long countByCode(String code);

}
