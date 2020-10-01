package com.org.model.dao;


import java.util.List;

import com.org.exception.AuthenticationException;
import com.org.exception.NotFound;
import com.org.model.beans.Contact;
import com.org.model.beans.Profile;

public interface ProfileDao {
public Profile store(Profile profile);
public List<Profile> getAll();
public Profile authenticate(int id,String password) throws AuthenticationException;
public Profile updateProfile(int id,Profile profile);
public Contact addContact(int id,Contact contact);
public List<Contact> getAllContact(int id);
public Contact get(int id, int contactId);
public int delete(int id, int convertId) throws NotFound;
public int deleteProfile(int id) throws NotFound;
public Contact updateContact(int profileId, int contactId, Contact found);
}