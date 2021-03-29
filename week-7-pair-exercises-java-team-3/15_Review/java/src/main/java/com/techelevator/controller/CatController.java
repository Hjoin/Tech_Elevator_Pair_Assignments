package com.techelevator.controller;

import com.techelevator.model.*;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cards")

public class CatController {

    private CatCardDAO catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }


    //GET - Provides a new, randomly created Cat Card containing information from
    //the cat fact and picture services.
    @RequestMapping(path = "/random", method = RequestMethod.GET)

    public CatCard generateNewRandomCard() {
        CatCard card = new CatCard();

        CatFact fact = catFactService.getFact();
        CatPic pic = catPicService.getPic();

        card.setCatFact(fact.getText());
        card.setImgUrl(pic.getFile());

        return card;
    }

    //POST - Save a card to the user's collection
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)

    public void saveCard(@Valid @RequestBody CatCard newCard) {
        catCardDao.save(newCard);

    }

    //GET - Provides a list of all Cat Cards in the user's collection
    @RequestMapping(method = RequestMethod.GET)
    public List<CatCard> getCatCardCollection() {
        return catCardDao.list();
    }

    //GET - Provides a Cat Card with the given ID
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard getCatCardById(@PathVariable long id) {
        return catCardDao.get(id);
    }

    //PUT - Updates a card in the user's collection
    @RequestMapping(path= "/{id}", method = RequestMethod.PUT)
    public void updateCatCard(@Valid @PathVariable long id,@RequestBody CatCard catCard) throws  CatCardNotFoundException
    {
        catCardDao.update(id,catCard);
    }


    //DELETE - Removes a card from the user's collection
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path="/{id}",method=RequestMethod.DELETE)
    public void deleteCatCard(@PathVariable long id) throws CatCardNotFoundException {
        catCardDao.delete(id);
    }
}
