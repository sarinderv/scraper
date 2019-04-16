package services;

import actors.JobActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.pattern.Patterns;
import models.Job;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
public class JobService {

    private final AtomicInteger idGenerator = new AtomicInteger();
    private final HashMap<Integer, Job> jobs = new HashMap<>();
    private final ActorRef helloActor;

    @Inject
    public JobService(ActorSystem system) {
        helloActor = system.actorOf(JobActor.getProps());
    }

    public int add(Job job) {
        int id = idGenerator.incrementAndGet();
        jobs.put(id, job);
        job.setId(id);
        crawl(job);
        return id;
    }

    private void crawl(Job job) {
        Patterns.ask(helloActor, new JobActor.Message(job), 1000);
    }
}
