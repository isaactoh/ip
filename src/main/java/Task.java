public class Task {
    private String name;
    private boolean done = false;

    public Task(String name) {
        this.name = name;
    }

    public void mark() {
        this.done = true;
    }

    public void unmark() {
        this.done = false;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public String toString() {
        String check = done ? "[X]" : "[ ]";
        return check + " " + this.name;
    }
}