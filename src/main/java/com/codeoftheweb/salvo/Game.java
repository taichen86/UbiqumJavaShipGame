package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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

}
