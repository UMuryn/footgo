package ua.lviv.footgo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "name_en")
    private String nameEn;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Team> teamList;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tour> tours;

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
    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public Long getId() {
        return id;
    }

    public void addTeam(Team team) {
        if(this.teamList == null) {
            teamList = new ArrayList<Team>();
        }
        teamList.add(team);
    }

    public void addTour(Tour tour) {
        if(this.tours == null) {
            tours = new ArrayList<Tour>();
        }
        tours.add(tour);
    }

}
