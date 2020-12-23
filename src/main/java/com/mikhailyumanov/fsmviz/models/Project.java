package com.mikhailyumanov.fsmviz.models;


public class Project {
  private int id;
  private String title;
  private String fsm;

  public Project() {
  }

  public Project(int id, String title, String fsm) {
    this.id = id;
    this.title = title;
    this.fsm = fsm;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getFsm() {
    return fsm;
  }

  public void setFsm(String fsm) {
    this.fsm = fsm;
  }
}
