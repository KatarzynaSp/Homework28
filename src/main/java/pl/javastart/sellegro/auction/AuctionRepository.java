package pl.javastart.sellegro.auction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long> {

    @Query("SELECT auction FROM Auction auction ORDER BY auction.price DESC" )
    List<Auction> findMostExpensive();

    @Query("SELECT auction FROM Auction auction ORDER BY sort")
    List<Auction> findAllBy(String sort);

    @Query("SELECT auction FROM Auction auction ORDER BY auctionFilters")
    List<Auction> findAllByTitleAndCarMakeAndAndColorAndCarModel(AuctionFilters auctionFilters);

}