package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private long id;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER )
    Set<GamePlayer> gameplayers;


    private Date creationDate;


//    public Game() { }

    public Game( ) {
        setCreationDate( new Date() );
        System.out.println(getCreationDate().toString());
    }

    public Game(String dateString){

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try{
            creationDate = format.parse( dateString );
            System.out.println("Successfully Parsed Date " + creationDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date date) {
        this.creationDate = date;
    }


    public void addGamePlayer(GamePlayer gameplayer) {
        gameplayer.setGame(this);
        gameplayers.add(gameplayer);
    }

    public List<Player> getPlayers() {
        return gameplayers.stream().map(sub -> sub.getPlayer()).collect(toList()); // ???
    }

}
