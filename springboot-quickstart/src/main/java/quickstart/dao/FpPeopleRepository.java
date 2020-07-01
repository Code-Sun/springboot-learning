package quickstart.dao;

import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import quickstart.entity.FpPeople;

@Api(tags = "801 员工表持久层")
@RepositoryRestResource
public interface FpPeopleRepository extends JpaRepository<FpPeople, Integer> {
}