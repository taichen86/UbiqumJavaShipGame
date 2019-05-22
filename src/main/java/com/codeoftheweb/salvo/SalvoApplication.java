package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerrepo,
									  GameRepository gamerepo,
									  GamePlayerRepository gameplayerrepo,
									  ShipRepository shiprepo) {
		return (args) -> {

			// create players
			Player p1 = new Player("j.bauer@ctu.gov");
			Player p2 = new Player("c.obrian@ctu.gov");
			Player p3 = new Player("t.almeida@ctu.gov");
			Player p4 = new Player("d.palmer@whitehouse.gov");
			System.out.println( "do... " + p1 );


			playerrepo.save( p1 );
			playerrepo.save( p2 );
			playerrepo.save( p3 );
			playerrepo.save( p4 );

			// create games with dates
			Game g1 = new Game( "02-17-2018 15:20:15" );
			Game g2 = new Game( "02-17-2018 16:20:15" );
			Game g3 = new Game( "02-17-2018 17:20:15" );
			Game g4 = new Game( "02-17-2018 18:20:15" );
			Game g5 = new Game( "02-17-2018 19:20:15" );
			Game g6 = new Game( "02-17-2018 20:20:15" );


			gamerepo.save( g1 );
			gamerepo.save( g2 );
			gamerepo.save( g3 );
			gamerepo.save( g4 );
			gamerepo.save( g5 );
			gamerepo.save( g6 );

			// create gameplayers with ships

			GamePlayer gp1 = new GamePlayer( g1, p1 );
			gameplayerrepo.save( gp1 );

			Ship ship01 = new Ship();
			ship01.setType(Ship.Type.DESTROYER);
			ship01.setLocations( Arrays.asList( new String[]{"H2","H3","H4"}) );
			ship01.setGamePlayer( gp1 );
			shiprepo.save( ship01 );



			Ship ship02 = new Ship();
			ship02.setType(Ship.Type.SUBMARINE);
			ship02.setLocations( Arrays.asList( new String[] {"E1", "F1", "G1"}));
			ship02.setGamePlayer( gp1 );
			shiprepo.save( ship02 );


			Ship ship03 = new Ship();
			ship03.setType(Ship.Type.PATROL_BOAT);
			ship03.setLocations( Arrays.asList( new String[] {"B4", "B5"}));
			ship03.setGamePlayer( gp1 );
			shiprepo.save( ship03 );


//			gameplayerrepo.save( gp1 );



			GamePlayer gp2 = new GamePlayer( g1, p2 );
			gameplayerrepo.save( gp2 );


			Ship ship04 = new Ship();
			ship04.setType(Ship.Type.DESTROYER);
			ship04.setLocations( Arrays.asList( new String[] {"B5", "C5", "D5"}));
			shiprepo.save( ship04 );
			ship04.setGamePlayer( gp2 );

			Ship ship05 = new Ship();
			ship05.setType(Ship.Type.PATROL_BOAT);
			ship05.setLocations( Arrays.asList( new String[] {"F1", "F2"}));
			shiprepo.save( ship05 );
			ship05.setGamePlayer( gp2 );



			GamePlayer gp3 = new GamePlayer( g2, p1 );

			Ship ship06 = new Ship();
			ship06.setType(Ship.Type.DESTROYER);
			ship06.setLocations( Arrays.asList( new String[] {"B5", "C5", "D5"}));
			shiprepo.save( ship06 );
			ship06.setGamePlayer( gp3 );

			Ship ship07 = new Ship();
			ship07.setType(Ship.Type.PATROL_BOAT);
			ship07.setLocations( Arrays.asList( new String[] {"C6", "C7"}));
			shiprepo.save( ship07 );
			ship07.setGamePlayer( gp3 );

			gameplayerrepo.save( gp3 );



			GamePlayer gp4 = new GamePlayer( g2, p2 );

			Ship ship08 = new Ship();
			ship08.setType(Ship.Type.SUBMARINE);
			ship08.setLocations( Arrays.asList( new String[] {"A2", "A3", "A4"}));
			shiprepo.save( ship08 );
			ship08.setGamePlayer( gp4 );

			Ship ship09 = new Ship();
			ship09.setType(Ship.Type.PATROL_BOAT);
			ship09.setLocations( Arrays.asList( new String[] {"G6", "H6"}));
			shiprepo.save( ship09 );
			ship07.setGamePlayer( gp4 );

			Ship ship10 = new Ship();
			ship10.setType(Ship.Type.DESTROYER);
			ship10.setLocations( Arrays.asList( new String[] {"B5", "C5", "D5"}));
			shiprepo.save( ship10 );
			ship10.setGamePlayer( gp4 );

			Ship ship11 = new Ship();
			ship11.setType(Ship.Type.PATROL_BOAT);
			ship11.setLocations( Arrays.asList( new String[] {"C6", "C7"}));
			shiprepo.save( ship11 );
			ship11.setGamePlayer( gp4 );


			gameplayerrepo.save( gp4 );



			GamePlayer gp5 = new GamePlayer( g3, p3 );

			Ship ship12 = new Ship();
			ship12.setType(Ship.Type.SUBMARINE);
			ship12.setLocations( Arrays.asList( new String[] {"A2", "A3", "A4"}));
			shiprepo.save( ship12 );
			ship12.setGamePlayer( gp5 );

			Ship ship13 = new Ship();
			ship13.setType(Ship.Type.PATROL_BOAT);
			ship13.setLocations( Arrays.asList( new String[] {"G6", "H6"}));
			shiprepo.save( ship13 );
			ship13.setGamePlayer( gp5 );

			gameplayerrepo.save( gp5 );



//			gameplayerrepo.save( new GamePlayer( g3, p4 ) );
//			gameplayerrepo.save( new GamePlayer( g4, p1 ) );


			GamePlayer gp6 = new GamePlayer( g4, p2 );

			Ship ship14 = new Ship();
			ship14.setType(Ship.Type.DESTROYER);
			ship13.setLocations( Arrays.asList( new String[] {"B5", "C5", "D5"}));
			shiprepo.save( ship14 );
			ship14.setGamePlayer( gp6 );

			Ship ship15 = new Ship();
			ship15.setType(Ship.Type.PATROL_BOAT);
			ship15.setLocations( Arrays.asList( new String[] {"C6", "C7"}));
			shiprepo.save( ship15 );
			ship15.setGamePlayer( gp6 );

			gameplayerrepo.save( gp6 );


			GamePlayer gp7 = new GamePlayer( g4, p1 );

			Ship ship16 = new Ship();
			ship16.setType(Ship.Type.SUBMARINE);
			ship16.setLocations( Arrays.asList( new String[] {"A2", "A3", "A4"}));
			shiprepo.save( ship16 );
			ship16.setGamePlayer( gp7 );

			Ship ship17 = new Ship();
			ship17.setType(Ship.Type.PATROL_BOAT);
			ship17.setLocations( Arrays.asList( new String[] {"G6", "H6"}));
			shiprepo.save( ship17 );
			ship17.setGamePlayer( gp7 );

			gameplayerrepo.save( gp7 );


			GamePlayer gp8 = new GamePlayer( g5, p3 );

			Ship ship18 = new Ship();
			ship18.setType(Ship.Type.DESTROYER);
			ship18.setLocations( Arrays.asList( new String[] {"B5", "C5", "D5"}));
			shiprepo.save( ship18 );
			ship18.setGamePlayer( gp8 );

			Ship ship19 = new Ship();
			ship19.setType(Ship.Type.PATROL_BOAT);
			ship19.setLocations( Arrays.asList( new String[] {"C6", "C7"}));
			shiprepo.save( ship19 );
			ship19.setGamePlayer( gp8 );

			gameplayerrepo.save( gp8 );


//			gameplayerrepo.save( new GamePlayer( g5, p1 ) );
//			gameplayerrepo.save( new GamePlayer( g6, p4 ) );


			// create ships - game 1


		};
	}

}
