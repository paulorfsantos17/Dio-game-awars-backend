package dio.me.diogameawards.controller.games;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dio.me.diogameawards.controller.BaseRestController;
import dio.me.diogameawards.domain.model.Game;

import dio.me.diogameawards.service.GameService;


@CrossOrigin
@RestController
public class GameRestController extends BaseRestController {
	
	@Autowired
	private GameService businessLayer;

	
	@GetMapping("games")
	public ResponseEntity<List<Game>> findAll() {
		return ResponseEntity.ok(this.businessLayer.findAll());
	}



	
	@GetMapping("games/{id}")
	public ResponseEntity<Game> findById(@PathVariable Long id) {
		return ResponseEntity.ok(this.businessLayer.findById(id));
	}
	
	@PostMapping("games")
	public ResponseEntity<Game> insert(@RequestBody Game game) {
		businessLayer.insert(game);
		return ResponseEntity.status(HttpStatus.CREATED).body(game);
	}
	
	@PutMapping("games/{id}")
	public ResponseEntity<Game> update(@PathVariable Long id, @RequestBody Game game) {
		businessLayer.update(id, game);
		return ResponseEntity.ok(game);
	}

	@PatchMapping("games/{id}/vote")
	public ResponseEntity<Game> update(@PathVariable Long id) {
		businessLayer.vote(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("games/{id}")
	public ResponseEntity<Game> delete(@PathVariable Long id) {
		businessLayer.delete(id);
		return ResponseEntity.ok().build();
	}

}