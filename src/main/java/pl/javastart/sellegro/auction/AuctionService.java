//package pl.javastart.sellegro.auction;
//
//import org.springframework.stereotype.Service;
//import org.springframework.util.comparator.Comparators;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Random;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
//@Service
//public class AuctionService {
//
//    private List<Auction> auctions;
//
//    private static final String[] ADJECTIVES = {"Niesamowity", "Jedyny taki", "IGŁA", "HIT", "Jak nowy",
//            "Perełka", "OKAZJA", "Wyjątkowy"};
//
//    public AuctionService() {
//        try {
//            loadData();
//        } catch (IOException e) {
//            System.out.println("Error loading data: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//
//
//    private List<Auction> loadData() throws IOException {
//        auctions = new ArrayList<>();
//        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
//        InputStream is = classloader.getResourceAsStream("dane.csv");
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
//
//        Random random = new Random();
//
//        String line = bufferedReader.readLine(); // skip first line
//        while ((line = bufferedReader.readLine()) != null) {
//            String[] data = line.split(",");
//            long id = Long.parseLong(data[0]);
//            String randomAdjective = ADJECTIVES[random.nextInt(ADJECTIVES.length)];
//            String title = randomAdjective + " " + data[1] + " " + data[2];
//            BigDecimal price = new BigDecimal(data[4].replace("\\.", ","));
//            LocalDate endDate = LocalDate.parse(data[5]);
//            Auction auction = new Auction(id, title, data[1], data[2], data[3], price, endDate);
//            auctions.add(auction);
//        }return auctions;
//    }
//
//    public List<Auction> find4MostExpensive() {
//        return auctions.stream()
//                .sorted(Comparator.comparing(Auction::getPrice).reversed())
//                .limit(4)
//                .collect(Collectors.toList());
//    }
//
//    public List<Auction> findAllForFilters(AuctionFilters auctionFilters) {
//
//        Predicate<Auction> filtrByTitle = auction -> auctionFilters.getTitle() == null || auction.getTitle().toUpperCase().contains(auctionFilters.getTitle().toUpperCase());
//        Predicate<Auction> filtrByCarMaker = auction -> auctionFilters.getCarMake() == null || auction.getCarMake().toUpperCase().contains(auctionFilters.getCarMake().toUpperCase());
//        Predicate<Auction> filtrByCarModel = auction -> auctionFilters.getCarModel() == null || auction.getCarModel().toUpperCase().contains(auctionFilters.getCarModel().toUpperCase());
//        Predicate<Auction> filtrByColor = auction -> auctionFilters.getColor() == null || auction.getColor().toUpperCase().contains(auctionFilters.getColor().toUpperCase());
//
//        return auctions.stream()
//                .filter(filtrByTitle.and(filtrByCarMaker.and(filtrByCarModel.and(filtrByColor))))
//                .collect(Collectors.toList());
//    }
//
////    public List<Auction> findAllSorted(String sort) {
////        Comparator<Auction> comparator;
////        if (sort.equals("title")) {
////            comparator = Comparator.comparing(Auction::getTitle);
////        } else if (sort.equals("price")) {
////            comparator = Comparator.comparing(Auction::getPrice);
////        } else if (sort.equals("color")) {
////            comparator = Comparator.comparing(Auction::getColor);
////        } else {
////            comparator = Comparator.comparing(Auction::getEndDate);
////        }
////        return auctions.stream()
////                .sorted(comparator)
////                .collect(Collectors.toList());
////    }
//}
