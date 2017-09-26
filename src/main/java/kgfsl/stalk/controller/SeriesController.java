package kgfsl.stalk.controller;



//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.Series;
//import kgfsl.stalk.entity.wrapper.SegmentWrapper;
import kgfsl.stalk.service.SeriesService;

@RestController
@RequestMapping("/scrip/series")
public class SeriesController extends AbstractMasterController<Series, String> {
	
	@Autowired
	private SeriesService service;

	@Override
	public Base4EyeService<Series, String> getMCService() {
		return service;
	}
	
	@RequestMapping(value = "/findBySeriesCode", method = RequestMethod.POST)
	public Series findBySeriesCode() throws Exception {
		return  service.findBySeriesCode();
	}
	
}
