package kgfsl.stalk.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.Segment;

@Repository
public interface SegmentRepository extends Base4EyeRepository<Segment, String> {

	public Segment findByCode(String code);

	public List<Segment> findByCodeIn(List<String> codes);

	public long countByCode(String value);

}
