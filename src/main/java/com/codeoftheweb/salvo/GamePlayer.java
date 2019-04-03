package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="game_id")
    private Game game;

    @OneToMany(mappedBy="gameplayer", fetch=FetchType.EAGER)
    private Set<Ship> ships = new HashSet<Ship>();


    private Date creationDate;

    public GamePlayer(){}

    public GamePlayer(Game game, Player player) {
        this.game = game;
        this.player = player;
        System.out.println("GamePlayer created " + player + " " + game );
    }

    public long getGamePlayerID(){ return id; }

    public Game getGame(){ return game; }
    public void setGame(Game game){ this.game = game; }

    public Player getPlayer(){ return player; }
    public void setPlayer(Player player){ this.player = player; }

    public Set<Ship> getShips(){ return ships; }
    public void addShip(Ship ship){
        ship.setGamePlayer( this );
        ships.add( ship );
    }




}
