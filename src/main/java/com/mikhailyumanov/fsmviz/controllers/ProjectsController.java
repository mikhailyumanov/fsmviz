package com.mikhailyumanov.fsmviz.controllers;

import com.mikhailyumanov.fsmviz.dao.ProjectDAO;
import com.mikhailyumanov.fsmviz.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectsController {
  private final ProjectDAO projectDAO;

  @Autowired
  public ProjectsController(ProjectDAO projectDAO) {
    this.projectDAO = projectDAO;
  }

  @GetMapping()
  public String index(Model model) {
    model.addAttribute("projects", projectDAO.index());
    return "projects/index";
  }

  @PostMapping
  public String create(@ModelAttribute("project") Project project) {
    projectDAO.save(project);
    return "redirect:/projects";
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") int id) {
    projectDAO.delete(id);
    return "redirect:/projects";
  }

  @GetMapping("/{id}/edit")
  public String edit(Model model, @PathVariable("id") int id) {
    return "redirect:/editor/" + id;
  }

  @PatchMapping("/{id}")
  public String update(@ModelAttribute("project") Project project,
                       @PathVariable("id") int id) {
    projectDAO.update(id, project);
    return "redirect:/projects";
  }
}
