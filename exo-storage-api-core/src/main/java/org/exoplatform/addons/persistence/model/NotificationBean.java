/*
 * Copyright (C) 2012 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.exoplatform.addons.persistence.model;


import java.util.List;

public class NotificationBean {
  private String user, from, type, content, link, category, categoryId;
  private Long timestamp;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(String categoryId) {
    this.categoryId = categoryId;
  }

  public String toJSON()
  {
    StringBuffer sb = new StringBuffer();

    sb.append("{");

    sb.append("\"user\": \""+this.getUser()+"\",");
    sb.append("\"type\": \""+this.getType()+"\",");
    sb.append("\"from\": \""+this.getFrom()+"\",");
    sb.append("\"category\": \""+this.getCategory()+"\",");
    sb.append("\"categoryId\": \""+this.getCategoryId()+"\",");
    sb.append("\"content\": \""+this.getContent().replaceAll("\n", "<br/>")+"\",");
    sb.append("\"link\": \""+this.getLink()+"\",");
    sb.append("\"timestamp\": "+this.getTimestamp());

    sb.append("}");

    return sb.toString();
  }

  public static String notificationstoJSON(List<NotificationBean> notificationBeans)
  {
    StringBuilder sb = new StringBuilder();
    sb.append("\"notifications\": [");
    boolean first=true;
    for (NotificationBean notificationBean:notificationBeans) {
      if (!first) {
        sb.append(",");
      } else {
        first=false;
      }

      sb.append(notificationBean.toJSON());

    }
    sb.append("]");

    return sb.toString();
  }
}
