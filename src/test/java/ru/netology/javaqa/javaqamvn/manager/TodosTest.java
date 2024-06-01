package ru.netology.javaqa.javaqamvn.manager;

import org.junit.jupiter.api.Test;
import ru.netology.javaqa.javaqamvn.domain.Epic;
import ru.netology.javaqa.javaqamvn.domain.Meeting;
import ru.netology.javaqa.javaqamvn.domain.SimpleTask;
import ru.netology.javaqa.javaqamvn.domain.Task;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfQueryIsInEveryTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Разработка");

        String[] subtasks = {"Позвонить", "Разработка", "Закрыть задачу"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Разработка",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("Разработка");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfQueryIsTwoTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Разработка");

        String[] subtasks = {"Позвонить", "Разработка", "Закрыть задачу"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("Разработка");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfQueryIsOneTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Позвонить", "Разработка", "Закрыть задачу"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Разработка");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchIfQueryIsNotThere() {
        SimpleTask simpleTask = new SimpleTask(5, "Разработка");

        String[] subtasks = {"Позвонить", "Разработка", "Закрыть задачу"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Разработка",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Тестирование");
        assertArrayEquals(expected, actual);
    }
}