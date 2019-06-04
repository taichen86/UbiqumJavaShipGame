package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoController {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @RequestMapping("/games")
    public List<Object> getAllGames(){
 //       System.out.println("hello");
//        List<Object> gids = gameRepository.findAll().stream().map( g -> g.getGameID()).collect(Collectors.toList());
//        System.out.println( gids );

        return gameRepository.findAll().stream().map( g -> makeGameDTO(g) ).collect(Collectors.toList());
    }

    @RequestMapping("/game_view/{id}")
    public Map<String, Object> showGameView(@PathVariable("id") long id ) {
        System.out.println("do game view for gameplayer " + id);

        GamePlayer gameplayer = gamePlayerRepository.findById( id ).get();
        Map<String, Object> dto = makeGameDTO( gameplayer.getGame() );
        System.out.println( gameplayer.getShips() );
        dto.put( "ships", gameplayer.getShips().stream().map( ship -> makeShipDTO( ship ) ).collect(Collectors.toList()) );

        List<Object> allSalvoes = new LinkedList<>();
        Set<GamePlayer> gps = gameplayer.getGame().getGamePlayers();
        gps.forEach( gp -> {
        //    System.out.println( "gameplayer --->" + gp.getSalvoes() );
            Set<Salvo> salvoes = gp.getSalvoes();
            salvoes.forEach( salvo -> {
            //    System.out.println( salvo );
                allSalvoes.add( makeSalvoDTO( salvo )  );
            } );
            //  dto.put( "salvoes", gameplayer.getSalvoes().stream().map( salvo -> makeSalvoDTO( salvo ) ).collect(Collectors.toList()) );
        } );
        //    System.out.println( salvos );
        dto.put( "salvoes", allSalvoes );

        return dto;
    }

    private Map<String, Object> makeShipDTO(Ship ship){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put( "type", ship.getType() );
        dto.put( "locations", ship.getLocations() );
        return dto;
    }

    private Map<String, Object> makeSalvoDTO( Salvo salvo ){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put( "player", salvo.getGamePlayer().getPlayer().getPlayerID() );
        dto.put( "turn", salvo.getTurnNumber() );
        dto.put( "locations", salvo.getLocations() );
        return dto;
    }

    private Map<String,Object> makeGameDTO(Game game){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", game.getGameID());
        dto.put("date", game.getCreationDate());
        dto.put("gameplayers", game.getGamePlayers()
                                    .stream()
                                    .map( gp -> makeGamePlayerDTO( gp ) )
                                    .collect((Collectors.toList())));
        return dto;
    }

    private Set<GamePlayer> getGamePlayers(Game game){
        return game.getGamePlayers();
    }

    private Map<String, Object> makeGameViewDTO( Game game ){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", game.getGameID());
        dto.put("date", game.getCreationDate());
        dto.put("gameplayers", game.getGamePlayers()
                .stream()
                .map( gp -> makeGamePlayerDTO( gp ) )
                .collect((Collectors.toList())));
        return dto;
    }

    private Map<String,Object> makeGamePlayerDTO(GamePlayer gameplayer){
        Map<String,Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", gameplayer.getGamePlayerID());
        dto.put("player", makePlayerDTO( gameplayer.getPlayer() ) );
        return dto;
    }

    private Map<String,Object> makePlayerDTO(Player player){
        Map<String,Object> dto = new LinkedHashMap<String, Object>();
        dto.put( "id", player.getPlayerID() );
        dto.put( "email", player.getUsername() );
        return dto;
    }



}
