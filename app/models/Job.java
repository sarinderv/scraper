package models;


public class Job {

    public int id;
    public Status status = new Status();
    public Results results = new Results();
    public Request request;

    public Job(Request request) {
        this.request = request;
    }

    public static class Request {
        public String[] urls;
    }

    public static class Status {
        public int id;
        public int inprogress = 0;
        public int completed = 0;
    }

    public static class Results {
    }

    public static class JobId {
        public JobId(int id) {
            this.id = id;
        }
        public int id;
    }

    public String toString() {
        return "job id=" + this.id;
    }
}
