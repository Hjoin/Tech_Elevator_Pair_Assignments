package com.techelevator.model;

import java.util.List;

public interface CatCardDAO {

	List<CatCard> list();

	CatCard get(long id);

	boolean save(CatCard cardToSave);

	boolean update(long id, CatCard card);

	boolean delete(long id);

}
