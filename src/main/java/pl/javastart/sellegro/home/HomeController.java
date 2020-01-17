package pl.javastart.sellegro.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.sellegro.auction.AuctionRepository;

@Controller
public class HomeController {

    private AuctionRepository auctionRepository;
//    private AuctionService auctionService;

    public HomeController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }


//    public HomeController(AuctionService auctionService) {
//        this.auctionService = auctionService;
//    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cars", auctionRepository.findMostExpensive());
        return "home";
    }

}
