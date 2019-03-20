package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER )
    Set<GamePlayer> gameplayers;



    private String firstName;
    private String lastName;
    private String username;

    public Player() { }

    public Player(String email) {
        username = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) { this.username = username; }

    public String toString() {
        return firstName + " " + lastName;
    }

    public void addGamePlayer(GamePlayer gameplayer) {
        gameplayer.setPlayer(this);
        gameplayers.add(gameplayer);
    }

}
