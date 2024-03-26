package testresources;

import com.lpnu.iot.cornerstoneondemand.structure.repositories.CSVRepository;

public class TestingRepository extends CSVRepository<TestingResource> {

    public TestingRepository() {
        super("test/test.csv");
    }

    @Override
    protected TestingResource createNewResource() {
        return new TestingResource();
    }
}