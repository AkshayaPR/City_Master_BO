package kgfsl.stalk.service.wrapper;

import java.util.List;

import kgfsl.stalk.entity.Segment;

public interface ISegmentService {

	List<Segment> findAll();

	List<Segment> getActiveSegments();

}
