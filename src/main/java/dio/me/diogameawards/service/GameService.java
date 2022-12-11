package dio.me.diogameawards.service;

import java.util.List;

import dio.me.diogameawards.domain.model.Game;

public interface GameService {
  List<Game> findAll();

  Game findById(long id);
  
  void insert(Game game);

  void update(Long id,Game game);

  void delete(long id);

  void vote(long id);
}
