package com.org.model.service;

import java.util.List;

import com.org.exception.AuthenticationException;
import com.org.exception.NotFound;
import com.org.model.beans.Contact;
import com.org.model.beans.Profile;

public interface ProfileService {
public Profile store(Profile profile);
public Profile login(int id,String password) throws AuthenticationException;
public Profile updatePhone(int id,long phone);
public Profile updatePassword(int id,String password);
public Profile updateDob(int id,String dob);
public List<Profile> getAll();
public Contact addContact(int id,Contact contact) throws NotFound;
public Contact getContact(int id, int contactId);
public int deleteContact(int id, int convertId) throws NotFound;
public int deleteProfile(int id) throws NotFound;
public List<Contact> getAllContacts(int id);
public Contact updateContactPhone(int profileId, int contactId, long phoneNumber) throws NotFound;
public Contact updateContactName(int profileId, int contactId, String name) throws NotFound;
}
