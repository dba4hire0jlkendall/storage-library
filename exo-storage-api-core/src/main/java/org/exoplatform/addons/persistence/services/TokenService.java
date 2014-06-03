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

package org.exoplatform.addons.persistence.services;

import org.exoplatform.addons.persistence.model.UserBean;

import java.util.HashMap;

public interface TokenService
{
  public static final String M_USERS_COLLECTION = "users";
  public static final String ANONIM_USER = "__anonim_";

  public String getToken(String user);

  public boolean hasUserWithToken(String user, String token);

  public void addUser(String user, String token);

  public void updateValidity(String user, String token);

  public HashMap<String, UserBean> getActiveUsersFilterBy(String user, boolean withUsers, boolean withPublic, boolean isAdmin);

  public HashMap<String, UserBean> getActiveUsersFilterBy(String user, boolean withUsers, boolean withPublic, boolean isAdmin, int limit);

  public boolean isUserOnline(String user);

  public boolean isDemoUser(String user);

}
