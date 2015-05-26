package us.edu.mum.ots.service.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 *
 * @author bipin
 */
@ContextConfiguration(locations = "classpath:spring-config/core-context.xml")
public abstract class BaseTest extends AbstractTestNGSpringContextTests {
    
}
