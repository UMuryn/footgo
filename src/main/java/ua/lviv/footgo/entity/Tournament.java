package ua.lviv.footgo.entity;

        import javax.persistence.*;
        import java.util.ArrayList;
        import java.util.List;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "name_en")
    private String name_en;

    @Lob
    private String description;

    @Lob
    private String description_en;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Season> seasonList;

    @OneToOne
    private Season activeSeason;

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

    public String getNameEn() {
        return name_en;
    }

    public void setNameEn(String name_en) {
        this.name_en = name_en;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return description_en;
    }

    public void setDescriptionEn(String description_en) {
        this.description_en = description_en;
    }

    public List<Season> getSeasonList() {
        return seasonList;
    }

    public void setSeasonList(List<Season> seasonList) {
        this.seasonList = seasonList;
    }

    public Season getActiveSeason() {
        return activeSeason;
    }

    public void setActiveSeason(Season activeSeason) {
        this.activeSeason = activeSeason;
    }

    public void addSeason(Season season) {
        if(this.seasonList == null) {
            this.seasonList = new ArrayList<>();
        }
        this.seasonList.add(season);
    }
}
