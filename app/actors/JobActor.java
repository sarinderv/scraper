package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import models.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.CrawlService;

public class JobActor extends AbstractActor {

    private Logger logger = LoggerFactory.getLogger(JobActor.class);

    public static Props getProps() {
        return Props.create(JobActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Message.class, msg -> {
                    logger.info("got msg job={}", msg.job);
                    msg.crawlService.crawl(msg.job);
                })
                .build();
    }

    public static class Message {
        private final Job job;
        private final CrawlService crawlService;

        public Message(Job job, CrawlService crawlService) {
            this.job = job;
            this.crawlService = crawlService;
        }
    }
}