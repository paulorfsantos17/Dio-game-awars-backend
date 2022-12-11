package dio.me.diogameawards.domain.model;

import dio.me.diogameawards.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;

@Entity(name ="GAMES")
public class Game  extends BaseEntity{

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  
  @Column(length = 500)
  private String description;
  private String cover;
  private long votes;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getCover() {
    return cover;
  }
  public void setCover(String cover) {
    this.cover = cover;
  }
  public long getVotes() {
    return votes;
  }
  public void setVotes(long votes) {
    this.votes = votes;
  }
  

}
