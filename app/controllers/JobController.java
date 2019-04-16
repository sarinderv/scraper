package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import services.JobService;

import javax.inject.Inject;

public class JobController {

    private Logger logger = LoggerFactory.getLogger(JobController.class);

    @Inject
    private JobService jobService;

    public Result create(Http.Request request) {
        JsonNode json = request.body().asJson();
        Job.Request jobRequest = Json.fromJson(json, Job.Request.class);
        Job newJob = new Job(jobRequest);
        int newJobId = jobService.add(newJob);
        logger.info("created new job {} with {} urls", newJobId, jobRequest.urls.length);
        return Results.created(Json.toJson(new Job.JobId(newJob.id)));
    }

    public Result read(long jobId) {
        return Results.status(Http.Status.NOT_IMPLEMENTED);
    }

    public Result update() {
        return Results.status(Http.Status.NOT_IMPLEMENTED);
    }

    public Result delete() {
        return Results.status(Http.Status.NOT_IMPLEMENTED);
    }
}
