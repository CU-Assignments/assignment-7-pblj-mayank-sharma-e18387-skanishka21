<!DOCTYPE html>
<html>
<head>
    <title>Attendance Form</title>
</head>
<body>
    <h2>Student Attendance Form</h2>
    <form action="attendance" method="post">
        <label>Student Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Roll Number:</label><br>
        <input type="text" name="roll" required><br><br>

        <label>Status:</label><br>
        <select name="status" required>
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>

        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>
