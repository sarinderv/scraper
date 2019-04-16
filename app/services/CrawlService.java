package services;

import models.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CrawlService {
    private Logger logger = LoggerFactory.getLogger(CrawlService.class);

    @Inject
    public CrawlService() {

    }

    public void crawl(Job job) {
        for (String url : job.request.urls) {
            logger.info("about to crawl url={}", url);
            job.status.inprogress++;
        }
    }
}
