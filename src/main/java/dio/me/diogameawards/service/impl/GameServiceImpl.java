package dio.me.diogameawards.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import dio.me.diogameawards.domain.model.Game;
import dio.me.diogameawards.domain.model.GameRepository;
import dio.me.diogameawards.service.GameService;
import dio.me.diogameawards.service.exception.BusinessException;
import dio.me.diogameawards.service.exception.NoContentException;

@Service
public class GameServiceImpl implements GameService {



  @Autowired
  private GameRepository repository;

  @Override
  public void vote(long id) {
    Game gameDb = findById(id);
    gameDb.setVotes(gameDb.getVotes() + 1);

    update(id, gameDb);
  }



  @Override
  public List<Game> findAll() {
    List<Game> games = repository.findAll(Sort.by(Direction.DESC,"votes"));
    return games;
  }

  @Override
  public Game findById(long id) {
    Optional <Game> game = repository.findById(id);
    return game.orElseThrow(() -> new NoContentException());
  }

  @Override
  public void insert(Game game) {
    if(game.getId() != null) {
      throw new BusinessException("O ID é diferentede te NULL na inclusão.");
    }

    repository.save(game);
    
  }

  @Override
  public void update(Long id,Game game) {
    Game gameDb = findById(id);
    if(gameDb.getId().equals((game.getId()))) {
      repository.save(game);
    } else {
      throw new BusinessException("Os IDs para alteração são divergentes.");
    }
  }

  @Override
  public void delete(long id) {
    Game gameDb = findById(id);
    repository.delete(gameDb);

  }
  
}
