package ru.netology.javaqa.javaqamvn.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TasksTest {

    // наполнение объектов для тестирования
    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldGetId() {
        Task task = new Task(0);

        int expected = 0;
        int actual = task.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseByDefault() {
        Task task = new Task(0);

        boolean expected = false;
        boolean actual = task.matches("");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTitle() {
        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtasks() {
        String[] expected = {"Молоко", "Яйца", "Хлеб"};
        String[] actual = epic.getSubtasks();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetTopic() {
        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetProject() {
        String expected = "Приложение НетоБанка";
        String actual = meeting.getProject();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetStart() {
        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchForSimpleTaskTitle() {
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchForEpicSubtask() {
        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchForMeetingTopic() {
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchForMeetingProject() {
        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchForMeetingStart() {
        boolean expected = false;
        boolean actual = meeting.matches("Во вторник после обеда");
        assertEquals(expected, actual);
    }
}
