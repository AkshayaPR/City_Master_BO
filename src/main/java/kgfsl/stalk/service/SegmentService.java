package kgfsl.stalk.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.Segment;
import kgfsl.stalk.entity.wrapper.SegmentWrapper;
import kgfsl.stalk.repository.SegmentRepository;
import kgfsl.stalk.service.wrapper.ISegmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SegmentService extends Base4EyeService<Segment, String> implements ISegmentService {

	@Autowired
	private SegmentRepository repository;

	public Segment findByCode(String segment) {
		return repository.findByCode(segment);
	}

	@Override
	public Base4EyeRepository<Segment, String> getMainRepository() {
		return repository;
	}

	@Override
	public boolean findIfRecordExists(Segment model) throws CustomException {
		return model.getId() == 0 && repository.findByCode(model.getCode()) != null;
	}

	private Set<String> getSelectionColumns() {
		Set<String> columns = new HashSet<>();
		columns.add("name");
		columns.add("code");
		return columns;
	}

	public List<Map<String, Object>> getSegmentList_CodeAndName() throws Exception {
		return dynamicFilter.select(Segment.class, getSelectionColumns());
	}

	@Override
	public List<Segment> getActiveSegments() {
		return repository.findByActive(true);
	}

	public List<SegmentWrapper> getSegmentWrapper() {
		return repository.findByActive(true).stream().map(m -> converter(m)).collect(Collectors.toList());
	}

	private SegmentWrapper converter(Segment segment) {
		SegmentWrapper wrapper = new SegmentWrapper();
		wrapper.setCode(segment.getCode());
		wrapper.setName(segment.getName());
		return wrapper;
	}
}
