package testresources;

import com.lpnu.iot.cornerstoneondemand.structure.repositories.CSVRepository;

public class TestingRepository extends CSVRepository<TestingResource> {

    public TestingRepository() {
        super("test/test.csv", "tests");
    }

    @Override
    public TestingResource newResource() {
        return new TestingResource();
    }
}