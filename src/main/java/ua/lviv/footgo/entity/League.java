package ua.lviv.footgo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Team> teamList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tour> tours;

    private String name;

    private String nameEn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public Long getId() {
        return id;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public void addTeam(Team team) {
        if(this.teamList == null) {
            teamList = new ArrayList<Team>();
        }
        teamList.add(team);
    }
    public void removeTeam(Team team) {
        if(this.teamList == null) {
            return;
        }
        teamList.remove(team);
    }

    public void addTour(Tour tour) {
        if(this.tours == null) {
            tours = new ArrayList<Tour>();
        }
        tours.add(tour);
    }

    public void removeTour(Tour tour) {
        if(this.getTours() == null) {
            return;
        }
        tours.remove(tour);
    }
}
