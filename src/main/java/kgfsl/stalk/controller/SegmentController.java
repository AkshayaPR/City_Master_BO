package kgfsl.stalk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.Segment;
import kgfsl.stalk.entity.wrapper.SegmentWrapper;
import kgfsl.stalk.service.SegmentService;

@RestController
@RequestMapping("/master/segment")
public class SegmentController extends AbstractMasterController<Segment, String> {

	@Autowired
	private SegmentService service;

	@RequestMapping(value = "/getmainactive", method = RequestMethod.GET)
	public List<Segment> getActiveSegments() {
		return service.getActiveSegments();
	}

	@Override
	public Base4EyeService<Segment, String> getMCService() {
		return service;
	}

	@RequestMapping(value = "/segmentlist/getsegmentcodeandnamelist", method = RequestMethod.GET)
	public List<SegmentWrapper> getSegmentCodeAndNameList() throws Exception {
		return service.getSegmentWrapper();
	}

}
