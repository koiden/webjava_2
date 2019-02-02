package jp.co.systena.tigerscave.blackjack.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.blackjack.model.Deck;
import jp.co.systena.tigerscave.blackjack.model.Game;
import jp.co.systena.tigerscave.blackjack.model.GameForm;
import jp.co.systena.tigerscave.blackjack.model.SelectForm;
import jp.co.systena.tigerscave.blackjack.service.BlackJack;

@Controller
public class GameController {

    @Autowired
      HttpSession session;

    @RequestMapping(path="/selectgame", method = RequestMethod.GET)
    public ModelAndView selectmenu(ModelAndView mav) {

        mav.addObject("selectForm",new SelectForm());


        return mav;
    }

    @RequestMapping(path="selectgame", method = RequestMethod.POST)
    public ModelAndView selectgame(ModelAndView mav, @Valid SelectForm selectForm ,BindingResult bindingResult, HttpServletRequest request) {

        String formData = selectForm.getSelectGame();

        if(formData.equals("hal")) {
            return new ModelAndView("redirect:/highandlow");
        }

        if(formData.equals("bj")) {
            return new ModelAndView("redirect:/blackjack");
        }

        // データをセッションへ保存
        session.setAttribute("form", selectForm);

        return new ModelAndView("redirect:/selectgame");

    }

    @RequestMapping(path="/blackjack", method = RequestMethod.GET)
    public ModelAndView bjplay(ModelAndView mav) {

//      GameForm listForm = (GameForm) session.getAttribute("form");
//      session.removeAttribute("form");

//      mav.addObject("gameForm",new GameForm());

        List<String> deck = new Deck().GetShuffleDeck();
        System.out.println(deck);

        GameForm gameForm = new GameForm();
        int index = gameForm.getIndex();

        String dealerHand = new BlackJack().GetOneCard(deck,index);

        mav.addObject("dealerhand",dealerHand);
        index+=1;

        List<String> userHand = new BlackJack().GetTwoCard(deck,index);
        index+=2;

        mav.addObject("userhand", userHand);

        gameForm.setDeck(deck);
        gameForm.setIndex(index);

        mav.addObject(gameForm);

        mav.setViewName("blackjack");

        return mav;
    }

    @RequestMapping(path="/blackjack", method = RequestMethod.POST)
    public ModelAndView juge(ModelAndView mav, @Valid GameForm gameForm ,BindingResult bindingResult, HttpServletRequest request) {

        //セッション情報
        Game game = (Game)session.getAttribute("gameInfo");
        if( game == null) {
            game = new Game();
          session.setAttribute("gameInfo", game);
        }

        // データをセッションへ保存
        session.setAttribute("form", gameForm);

        System.out.println(gameForm.getMoveFlg());


        return new ModelAndView("redirect:/blackjack");
    }

    @RequestMapping(path="/highandlow", method = RequestMethod.GET)
    public ModelAndView halplay(ModelAndView mav) {

        mav.addObject("selectForm",new SelectForm());


        return mav;
    }


}
