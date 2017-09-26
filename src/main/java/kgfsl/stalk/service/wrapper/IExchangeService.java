package kgfsl.stalk.service.wrapper;

import java.util.List;

import kgfsl.stalk.entity.Exchange;

public interface IExchangeService {

	List<Exchange> findAll();

	List<Exchange> getActiveExchanges();

}
