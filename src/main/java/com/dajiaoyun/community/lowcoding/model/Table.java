package com.dajiaoyun.community.lowcoding.model;

public class Table
{
  private String name;
  private String source;
  private String implclass;
  private Field[] fields;

  public String getName()
  {
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSource() {
    return this.source;
  }
  public void setSource(String source) {
    this.source = source;
  }
  public String getImplclass() {
    return this.implclass;
  }
  public void setImplclass(String implclass) {
    this.implclass = implclass;
  }
  public Field[] getFields() {
    return this.fields;
  }
  public void setFields(Field[] fields) {
    this.fields = fields;
  }
}
