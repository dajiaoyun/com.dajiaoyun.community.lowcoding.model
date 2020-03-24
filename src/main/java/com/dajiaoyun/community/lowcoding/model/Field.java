package com.dajiaoyun.community.lowcoding.model;

public class Field
{
  private String name;
  private String source;
  private String type;
  private String fromtable;
  private boolean primarykey;

  public boolean isPrimarykey()
  {
    return this.primarykey;
  }
  public void setPrimarykey(boolean primarykey) {
    this.primarykey = primarykey;
  }
  public String getFromtable() {
    return this.fromtable;
  }
  public void setFromtable(String fromtable) {
    this.fromtable = fromtable;
  }

  public String getName() {
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
  public String getType() {
    return this.type;
  }
  public void setType(String type) {
    this.type = type;
  }
}
