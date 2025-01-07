package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testcontainers.couchbase.BucketDefinition;
import org.testcontainers.couchbase.CouchbaseContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class TestContainersTest {

    @Container
    private static final CouchbaseContainer container = new CouchbaseContainer("couchbase/server:7.6.4")
            .withStartupAttempts(2)
            .withBucket(new BucketDefinition("qc"))
            .withReuse(false);

    @Test
    public void test() {
        Assertions.assertTrue(container.isRunning());
    }

}

