import Task.Epic;
import Task.Meeting;
import Task.SimpleTask;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TaskTest {


    @Test
    public void shouldSimpleTaskMatchesTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("родителям");
        boolean expected = true;

        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldSimpleTaskMatchesNotTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        boolean actual = simpleTask.matches("Отправить родителям");

        Assertions.assertFalse(actual);

    }

    @Test
    public void shouldEpicMatchesTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Молоко");


        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldEpicMatchesNotTrue() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        boolean actual = epic.matches("Паста");

        Assertions.assertFalse(actual);

    }

    @Test
    public void shouldMeetingTopicMatchesTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldMeetingTopicMatchesNotTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Выкатка 5й версии приложения");

        Assertions.assertFalse(actual);

    }

    @Test
    public void shouldMeetingProjectMatchesTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean actual = meeting.matches("Приложение");

        Assertions.assertTrue(actual);

    }

    @Test
    public void shouldMeetingProjectMatchesNotTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("приложение нетобанка");

        Assertions.assertFalse(actual);

    }
}

