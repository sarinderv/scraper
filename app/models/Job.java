package models;


import java.util.HashMap;
import java.util.Map;

public class Job {

    public JobId id;
    private Status status;
    private Results results;
    private Request request;

    public Job(Request request) {
        this.request = request;
    }

    public static class Request {
        public String[] urls;
    }

    public static class Status {
        public int id;
        public Map<String, Integer> status = new HashMap<>();
    }

    public Status getStatus() {
        this.status = new Status();
        this.status.id = id.id;
        return status;
    }

    public static class Results {
    }

    public static class JobId {
        public JobId(int id) {
            this.id = id;
        }

        public int id;
    }

    public void setId(int id) {
        this.id = new JobId(id);
    }

    public String toString() {
        return "job id="+ this.id.id;
    }
}
