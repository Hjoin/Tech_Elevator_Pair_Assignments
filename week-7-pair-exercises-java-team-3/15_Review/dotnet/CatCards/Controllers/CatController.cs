using System.Collections.Generic;
using CatCards.DAO;
using CatCards.Models;
using CatCards.Services;
using Microsoft.AspNetCore.Mvc;

namespace CatCards.Controllers
{

    public class CatController : ControllerBase
    {
        private readonly ICatCardDAO cardDAO;
        private readonly ICatFactService catFactService;
        private readonly ICatPicService catPicService;

        public CatController(ICatCardDAO _cardDAO, ICatFactService _catFact, ICatPicService _catPic)
        {
            catFactService = _catFact;
            catPicService = _catPic;
            cardDAO = _cardDAO;
        }


    }
}
