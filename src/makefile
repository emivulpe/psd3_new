JFLAGS = -g
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        Admin.java \
        Attendance.java \
        CapacityException.java \
        Course.java \
	CourseDb.java \
	CourseStudent.java \
	DateParser.java \
	Day.java \
	Exporter.java \
	LabSession.java \
	Lecturer.java \
	Session.java \
	Student.java \
	StudentCourse.java \
	StudentDb.java \
	Time.java \
	Timetable.java \
	Tutor.java \
	User.java \
	UserAuth.java \
	Week.java \
	Main.java
MAIN = Main

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN)

clean:
	$(RM) *.class
