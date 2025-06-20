package study.projects_spring.firstendpoint.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class TestLogController {
    private final Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());
    @GetMapping("/test")
    public String testLog(){
        logger.info("This is an INFO log");
        logger.debug("This is an DEBUG log");
        logger.warn("This is an WARN log");
        logger.error("This is an ERROR log");
        return "Logs generated succesfully!";
    }

}
