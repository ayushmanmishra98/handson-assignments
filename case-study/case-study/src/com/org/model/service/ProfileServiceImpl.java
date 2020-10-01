package com.org.model.service;

import java.util.List;

import com.org.exception.AuthenticationException;
import com.org.exception.NotFound;
import com.org.model.beans.Contact;
import com.org.model.beans.Profile;
import com.org.model.dao.ProfileDao;
import com.org.model.utility.FactoryClass;
import com.org.model.utility.Type;

public class ProfileServiceImpl implements ProfileService{

	
	ProfileDao dao;
	public ProfileServiceImpl() {
		dao=(ProfileDao)FactoryClass.getInstance(Type.DAO);
	}

	@Override
	public Profile store(Profile profile) {
		Profile registered=dao.store(profile);
		return registered;
	}

	@Override
	public List<Profile> getAll() {
		return dao.getAll();
	}

	@Override
	public Profile login(int id,String password) throws AuthenticationException{
		Profile profile=dao.authenticate(id,password);
		if(profile==null) {
			throw new AuthenticationException("Sorry internal server error.Please try again.");
		}
		return profile;
	}

	@Override
	public Profile updatePhone(int id, long phone) {
		Profile found=null;
		List<Profile> all=dao.getAll();
		for(Profile p:all) {
			if(p.getProfileId()==id) {
				found=p;
				break;
			}
		}
		found.setPhoneNo(phone);
		Profile updateUser=dao.updateProfile(id,found);
		return updateUser;
	}

	@Override
	public Profile updatePassword(int id, String password) {
		Profile found=null;
		List<Profile> all=dao.getAll();
		for(Profile p:all) {
			if(p.getProfileId()==id) {
				found=p;
				break;
			}
		}
		found.setPassword(password);
		Profile updateUser=dao.updateProfile(id,found);
		return updateUser;
	}

	@Override
	public Profile updateDob(int id, String dob) {
		Profile found=null;
		List<Profile> all=dao.getAll();
		for(Profile p:all) {
			if(p.getProfileId()==id) {
				found=p;
				break;
			}
		}
		found.setDOB(dob);
		Profile updateUser=dao.updateProfile(id,found);
		return updateUser;
	}

	@Override
	public Contact addContact(int id,Contact contact) throws NotFound{
		Profile found=null;
		List<Profile> all=dao.getAll();
		for(Profile p:all) {
			if(p.getProfileId()==id) {
				found=p;
				break;
			}
		}
		Contact addContactProfile=dao.addContact(id,contact);
		if(addContactProfile==null) {
			throw new NotFound("Internal Error.Please try again");
		}
		return addContactProfile;
	}

	@Override
	public Contact getContact(int id, int contactId) {
		return dao.get(id,contactId);
	}

	@Override
	public int deleteContact(int id, int convertId) throws NotFound {
		int flag=dao.delete(id,convertId);
		System.out.println(flag);
		if(flag!=1) {
			throw new NotFound("Entered Details does not exist.");
		}
		return flag;
	}

	@Override
	public int deleteProfile(int id) throws NotFound {
		int flag=dao.deleteProfile(id);
		if(flag!=1) {
			throw new NotFound("Entered Details does not exist.");
		}
		return flag;
		
	}

	@Override
	public List<Contact> getAllContacts(int id) {
		List<Contact> all=dao.getAllContact(id);
		return all;
	}

	@Override
	public Contact updateContactPhone(int profileId, int contactId, long phoneNumber)  throws NotFound{
		Contact found=null;
		List<Profile> all=dao.getAll();
		for(Profile p:all) {
			if(p.getProfileId()==profileId) {
				List<Contact> allContacts=dao.getAllContact(profileId);
				for(Contact c:allContacts) {
					if(c.getId()==contactId) {
						found=c;
					}
				}
			}
		}
		found.setPhone(phoneNumber);
		Contact editContact=dao.updateContact(profileId,contactId,found);
		if(editContact==null) {
			throw new NotFound("Contact not found.");
		}
		return editContact;
	}

	@Override
	public Contact updateContactName(int profileId, int contactId, String name)  throws NotFound{
		Contact found=null;
		List<Profile> all=dao.getAll();
		for(Profile p:all) {
			if(p.getProfileId()==profileId) {
				List<Contact> allContacts=dao.getAllContact(profileId);
				for(Contact c:allContacts) {
					if(c.getId()==contactId) {
						found=c;
					}
				}
			}
		}
		found.setName(name);
		Contact editContact=dao.updateContact(profileId,contactId,found);
		if(editContact==null) {
			throw new NotFound("Contact not found.");
		}
		return editContact;
	}

}
