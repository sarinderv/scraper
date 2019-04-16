package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import controllers.JobController;
import models.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
                    //sender().tell(msg, self());
                })
                .build();
    }

    public static class Message {
        public final Job job;

        public Message(Job job) {
            this.job = job;
        }
    }
}