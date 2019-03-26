package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerrepo, GameRepository gamerepo, GamePlayerRepository gameplayerrepo) {
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

			// create gameplayers
			System.out.println( "do " + p1 );
			gameplayerrepo.save( new GamePlayer( g1, p1 ) );
			gameplayerrepo.save( new GamePlayer( g1, p2 ) );
			gameplayerrepo.save( new GamePlayer( g2, p1 ) );
			gameplayerrepo.save( new GamePlayer( g2, p2 ) );
			gameplayerrepo.save( new GamePlayer( g3, p3 ) );
			gameplayerrepo.save( new GamePlayer( g3, p4 ) );
			gameplayerrepo.save( new GamePlayer( g4, p1 ) );
			gameplayerrepo.save( new GamePlayer( g4, p2 ) );
			gameplayerrepo.save( new GamePlayer( g5, p3 ) );
			gameplayerrepo.save( new GamePlayer( g5, p1 ) );
			gameplayerrepo.save( new GamePlayer( g6, p4 ) );



		};
	}

}
