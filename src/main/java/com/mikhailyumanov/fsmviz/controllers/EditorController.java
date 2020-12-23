package com.mikhailyumanov.fsmviz.controllers;

import com.mikhailyumanov.fsmviz.dao.ProjectDAO;
import com.mikhailyumanov.fsmviz.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/editor")
public class EditorController {
  private final ProjectDAO projectDAO;

  @Autowired
  public EditorController(ProjectDAO projectDAO) {
    this.projectDAO = projectDAO;
  }

  @GetMapping("/{id}")
  public String edit(Model model, @PathVariable("id") int id) {
    Project project = projectDAO.show(id);
    if (project == null) {
      return "redirect:/projects";
    }

    model.addAttribute("project", project);
    return "editor/index";
  }

  @PatchMapping("/{id}")
  public String update(@ModelAttribute("project") Project project,
                       @PathVariable("id") int id) {
    projectDAO.update(id, project);
    System.out.println(projectDAO.show(id).getFsm());
    return "redirect:/editor/" + id;
  }

}
