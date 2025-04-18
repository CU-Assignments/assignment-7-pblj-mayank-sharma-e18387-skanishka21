public class StudentAttendance {
    private String name;
    private String roll;
    private String status;

    public StudentAttendance(String name, String roll, String status) {
        this.name = name;
        this.roll = roll;
        this.status = status;
    }

    public String getName() { return name; }
    public String getRoll() { return roll; }
    public String getStatus() { return status; }

    public void setName(String name) { this.name = name; }
    public void setRoll(String roll) { this.roll = roll; }
    public void setStatus(String status) { this.status = status; }
}
