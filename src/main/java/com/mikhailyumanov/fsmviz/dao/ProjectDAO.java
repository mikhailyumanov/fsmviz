package com.mikhailyumanov.fsmviz.dao;

import com.mikhailyumanov.fsmviz.models.Project;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProjectDAO {
  private static int PROJECTS_COUNT;
  private final ArrayList<Project> projects;

  {
    projects = new ArrayList<>();

    projects.add(new Project(PROJECTS_COUNT, "Project" + PROJECTS_COUNT++,
        "{\"nodes\":[\n" +
            "    {\"id\": \"1\", \"group\": 1},\n" +
            "    {\"id\": \"2\", \"group\": 1},\n" +
            "    {\"id\": \"3\", \"group\": 2}],\n" +
            "    \"links\": [\n" +
            "    {\"source\": \"1\", \"target\": \"2\", \"curvature\": 0.1, \"text\": \"a\"},\n" +
            "    {\"source\": \"2\", \"target\": \"2\", \"curvature\": 0.5, \"text\": \"b\"},\n" +
            "    {\"source\": \"2\", \"target\": \"3\", \"curvature\": 0.1, \"text\": \"c\"}\n" +
            "]}"));

    projects.add(new Project(PROJECTS_COUNT, "Project" + PROJECTS_COUNT++,
        "{\"nodes\":[\n" +
            "    {\"id\": \"1\", \"group\": 1},\n" +
            "    {\"id\": \"2\", \"group\": 1},\n" +
            "    {\"id\": \"3\", \"group\": 2},\n" +
            "    {\"id\": \"4\", \"group\": 2},\n" +
            "    {\"id\": \"5\", \"group\": 2}],\n" +
            "    \"links\": [\n" +
            "    {\"source\": \"1\", \"target\": \"2\", \"curvature\": 0.1, \"text\": \"a\"},\n" +
            "    {\"source\": \"2\", \"target\": \"2\", \"curvature\": 0.5, \"text\": \"b\"},\n" +
            "    {\"source\": \"2\", \"target\": \"3\", \"curvature\": 0.1, \"text\": \"c\"},\n" +
            "    {\"source\": \"4\", \"target\": \"5\", \"curvature\": 0.1, \"text\": \"a\"},\n" +
            "    {\"source\": \"5\", \"target\": \"2\", \"curvature\": 0.1, \"text\": \"b\"}\n" +
            "]}"));
    projects.add(new Project(PROJECTS_COUNT, "Project" + PROJECTS_COUNT++,
        "{\"nodes\":[\n" +
        "    {\"id\": \"1\", \"group\": 1},\n" +
        "    {\"id\": \"2\", \"group\": 1},\n" +
        "    {\"id\": \"3\", \"group\": 2},\n" +
        "    {\"id\": \"4\", \"group\": 2},\n" +
        "    {\"id\": \"5\", \"group\": 2}],\n" +
        "    \"links\": [\n" +
        "    {\"source\": \"1\", \"target\": \"2\", \"curvature\": 0.1, \"text\": \"a\"},\n" +
        "    {\"source\": \"2\", \"target\": \"2\", \"curvature\": 0.5, \"text\": \"b\"},\n" +
        "    {\"source\": \"2\", \"target\": \"3\", \"curvature\": 0.1, \"text\": \"c\"},\n" +
        "    {\"source\": \"5\", \"target\": \"5\", \"curvature\": 0.1, \"text\": \"a\"},\n" +
        "    {\"source\": \"5\", \"target\": \"4\", \"curvature\": 0.1, \"text\": \"b\"},\n" +
        "    {\"source\": \"4\", \"target\": \"2\", \"curvature\": 0.1, \"text\": \"b\"},\n" +
        "    {\"source\": \"4\", \"target\": \"3\", \"curvature\": 0.1, \"text\": \"b\"}\n" +
        "]}"));
  }

  public ArrayList<Project> index() {
    return projects;
  }

  public void save(Project project) {
    if (project.getTitle() == null) {
      project.setTitle("Project" + PROJECTS_COUNT);
    }

    project.setId(PROJECTS_COUNT++);
    project.setFsm("{\"nodes\": [], \"links\": []}");
    projects.add(project);
  }

  public void delete(int id) {
    projects.removeIf(p -> p.getId() == id);
  }

  public Project show(int id) {
    return projects.stream().filter(p -> p.getId() == id).findAny().orElse(null);
  }

  public void update(int id, Project project) {
    Project updProject = show(id);
    updProject.setTitle(project.getTitle());
    updProject.setFsm(project.getFsm());
  }
}
