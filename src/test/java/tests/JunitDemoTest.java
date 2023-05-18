package tests;

import org.junit.jupiter.api.*;
import org.junit.platform.suite.api.Suite;

@Suite
//аннотация нужна для сборки тестов в сьют
public class JunitDemoTest {

    @BeforeAll
    public static void junitBeforeAll() {
        System.out.println("I'm before all");
    }

    @BeforeEach
    public void junitBeforeEach() {
        System.out.println("I'm before each");
    }

    @Test
    @Disabled("Not implemented")
    public void junitTest() {
        System.out.println("I'm Junit Test #1");
    }

    @Test
    @Tag("QA")
    @DisplayName("Junit Test 2")
    public void junit2Test() {
        Assertions.assertEquals(2, 3);
        System.out.println("I'm Junit Test #2");
    }

    @AfterEach
    public void junitAfterEach() {
        System.out.println("I'm after each");
    }

    @AfterAll
    public static void junitAfterAll() {
        System.out.println("I'm after all");
    }
}
